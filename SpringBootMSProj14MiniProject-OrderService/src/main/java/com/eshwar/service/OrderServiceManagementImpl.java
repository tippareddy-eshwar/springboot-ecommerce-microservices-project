//OrderServiceManagementImpl.java(implemented class for the  OrderServiceManagementImpl interface)
package com.eshwar.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eshwar.dto.InventoryDTO;
import com.eshwar.dto.NotificationDTO;
import com.eshwar.dto.OrderDTO;
import com.eshwar.dto.PaymentDTO;
import com.eshwar.dto.ProductDTO;
import com.eshwar.entity.Order;
import com.eshwar.exception.InsufficientQuantityException;
import com.eshwar.exception.OrderNotFoundException;
import com.eshwar.exception.ProductNotFoundException;
import com.eshwar.producer.NotificationProducer;
import com.eshwar.repository.IOrderRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderServiceManagementImpl implements IOrderServiceManagement
{
	
	
	    private final IOrderRepository repo;
	    
        private final  ProductClientService productService;
	    
	    private final InventoryClientService inventoryService;
	    
	    private final PaymentClientService paymentService;
	    
	    private final NotificationProducer producer;
	    
	    //Constructor Injection
	    public OrderServiceManagementImpl(IOrderRepository repo, ProductClientService productService, InventoryClientService inventoryService, PaymentClientService paymentService, NotificationProducer producer)
	    {
	    	log.debug("OrderServiceManagementImpl Class Parameterized(---,---,---,---,---)  Constructor is Executed...");
	    	this.repo=repo;
	    	this.productService=productService;
	    	this.inventoryService=inventoryService;
	    	this.paymentService=paymentService;
	    	this.producer=producer;
	    }
	    
	  
	    
	@Override
	public String placeOrder(OrderDTO orderDTO) 
	{
		 log.debug("OrderServiceManagementImpl Class placeOrder(---) method is executed...");
		
		 ProductDTO product = productService.getProductById(orderDTO.getProductId());
	
		//product validation
		if(product==null)
		{
			log.error("placeOrder(---) method of OrderServiceManagementImpl Class is throwing ProductNotFoundException");
			throw new ProductNotFoundException("Product Not Avilable");
		}
		
		
		
		 //inventory validation
		 InventoryDTO inventory = inventoryService.getInventory(orderDTO.getProductId());
		  
		//quantity validation
		if(orderDTO.getProductQuantity()>inventory.getAvilableQuantity())
		{
			log.error("placeOrder(---) method of OrderServiceManagementImpl Class is throwing InsufficientQuantityException");
			throw new  InsufficientQuantityException("Requested Quantity Not Available");
		}
		
		//Total Price Calculation
	    Double totalPrice=product.getProductPrice() * orderDTO.getProductQuantity();
	    //DTO->Entity
	    Order order=new Order();
	    order.setCustomerName(orderDTO.getCustomerName());
	    order.setProductId(orderDTO.getProductId());
	    order.setProductQuantity(orderDTO.getProductQuantity());
	    order.setTotalPrice(totalPrice);
	    order.setOrderStatus("PENDING");
		
		//saving order
		 Order orderSaved = repo.save(order);
		
		//Payment Processing
		
		//creating the PaymentDTO Class Object
		PaymentDTO payment=new PaymentDTO();
		payment.setOrderId(orderSaved.getOrderId());
		payment.setAmount(orderSaved.getTotalPrice());
		payment.setPaymentMode("UPI");
		payment.setPaymentStatus("PENDING");
		
		String paymentResponse=  paymentService.makePayment(payment);
		log.info("Payment Response : {}" ,paymentResponse);
		
		//reduce the inventory quantity
		String inventoryResponse = inventoryService.reduceStock(orderSaved.getProductId(),orderSaved.getProductQuantity());
		log.info("Inventory Response : {}" ,inventoryResponse);
		
		//creating the NotificationDTO Class Object
		NotificationDTO notification=new NotificationDTO();
		notification.setOrderId(orderSaved.getOrderId());
		notification.setMessage("Order Placed Sucessfully");
		notification.setNotificationType("EMAIL");
		notification.setStatus("SENT");
		
		//updating the order status
		orderSaved.setOrderStatus("CONFIRMED");
		
		//even if notification fails, the order status is already saved as CONFIRMED.
		repo.save(orderSaved);
		
	    //send Notification
	    producer.sendNotification(notification);
		log.info("Notification Event Published To Kafka...");
		
	    
		log.info("OrderServiceManagementImpl Class placeOrder(---) method is returning String");
		return "Order Placed Sucessfully Whose Order Id is : "+orderSaved.getOrderId();
	}

	   
    @Override
	public List<OrderDTO> getAllOrders() 
	{
		log.debug("OrderServiceManagementImpl Class  getAllOrders()  method is executed...");
		
		log.info("OrderServiceManagementImpl Class  getAllOrders()  method is returning  List<Order>");
		return repo.findAll().stream().map(order->
		      {
		    	  
                    OrderDTO orderDTO=new OrderDTO();
			        orderDTO.setOrderId(order.getOrderId());
			        orderDTO.setCustomerName(order.getCustomerName());
			        orderDTO.setProductId(order.getProductId());
			        orderDTO.setProductQuantity(order.getProductQuantity());
			        orderDTO.setTotalPrice(order.getTotalPrice());
                    orderDTO.setOrderStatus(order.getOrderStatus());
                    return orderDTO;
		      }).toList();
			
		 
	}

	@Override
	public OrderDTO getOrderById(Integer orderId) 
	{
		log.debug("OrderServiceManagementImpl Class  getOrderById(---)  method is executed...");
		
		Order order = repo.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order is Not Found With the Id : "+orderId));
		//Entity->DTO
		OrderDTO orderDTO=new OrderDTO();
		orderDTO.setOrderId(order.getOrderId());
        orderDTO.setCustomerName(order.getCustomerName());
        orderDTO.setProductId(order.getProductId());
        orderDTO.setProductQuantity(order.getProductQuantity());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setOrderStatus(order.getOrderStatus());
        
        log.info("OrderServiceManagementImpl Class  getOrderById(---)  method is returning OrderDTO Class Object");
        return orderDTO;
		
	}

	@Override
	public String deleteOrderById(Integer orderId) 
	{
		log.debug("OrderServiceManagementImpl Class deleteOrderById(---)  method is executed...");
		Order order=repo.findById(orderId).orElseThrow(()->new OrderNotFoundException("Order is Not Found With the Id : "+orderId));
		repo.delete(order);
		
		log.info("OrderServiceManagementImpl Class deleteOrderById(---)  method is returning String");
		return "Order Deleted Sucessfully Whose Order Id is : "+orderId;
	}

}
