//IOrderServiceManagement.java
package com.eshwar.service;
import java.util.List;
import com.eshwar.dto.OrderDTO;
public interface IOrderServiceManagement 
{
   public String placeOrder(OrderDTO orderDTO);
   public List<OrderDTO> getAllOrders();
   public OrderDTO getOrderById(Integer orderId);
   public String deleteOrderById(Integer orderId);
   
}
