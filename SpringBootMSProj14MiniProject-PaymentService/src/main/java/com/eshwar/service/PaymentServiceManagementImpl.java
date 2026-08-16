// PaymentServiceManagementImpl.java(implemented class IPaymentServiceManagement interface)
package com.eshwar.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.eshwar.dto.PaymentDTO;
import com.eshwar.entity.Payment;
import com.eshwar.exceptions.PaymentNotFoundException;
import com.eshwar.repository.IPaymentRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PaymentServiceManagementImpl implements IPaymentServiceManagement
{
	
    private final IPaymentRepository repo;
    
    //constructor injection
    public PaymentServiceManagementImpl(IPaymentRepository repo) 
    {
    	log.debug("PaymentServiceManagementImpl Class Parameterized Constructor is Executed...");
    	this.repo=repo;
    }
	
	@Override
	public String makePayment(PaymentDTO paymentDTO)
	{
		log.debug("PaymentServiceManagementImpl Class makePayment(---) method is executed...");
		
		log.info("In  makePayment(---) method of PaymentServiceManagementImpl Class setting payment status to Success");
		//DTO->Entity
		Payment payment=new Payment();
		payment.setOrderId(paymentDTO.getOrderId());
		payment.setAmount(paymentDTO.getAmount());
		payment.setPaymentMode(paymentDTO.getPaymentMode());
		
		//calling the setPaymentStatus(---) method of payment class
		payment.setPaymentStatus("Success");
		//calling the save(---) method of CrudRepository interface
		Payment savedPayment = repo.save(payment);
		log.info("PaymentServiceManagementImpl Class makePayment(---) method is returning String");
		return "Payment Done Sucessfully with The Payment Id : "+savedPayment.getPaymentId();
	}

	@Override
	public PaymentDTO getPaymentById(Integer paymentId) 
	{
		 log.debug("PaymentServiceManagementImpl Class getPaymentById(---) method is executed...");
		
	     //Entity
		 Payment payment=repo.findById(paymentId).orElseThrow(()->new PaymentNotFoundException("Payment Not Found"));
		 //Entity->DTO
		 PaymentDTO paymentDTO=new PaymentDTO();
		 paymentDTO.setPaymentId(payment.getPaymentId());
		 paymentDTO.setOrderId(payment.getOrderId());
	     paymentDTO.setAmount(payment.getAmount());
	     paymentDTO.setPaymentStatus(payment.getPaymentStatus());
	     paymentDTO.setPaymentMode(payment.getPaymentMode());
	     
	     log.info("PaymentServiceManagementImpl Class getPaymentById(---) method is returning Payment DTO Class Object");
	     return paymentDTO;
		 
	}

	@Override
	public List<PaymentDTO> getAllPayments() 
	{
	    log.debug("PaymentServiceManagementImpl Class getAllPayments() method is executed...");
	    //Entity->DTO
	    List<PaymentDTO>listOfPaymentDTOs=repo.findAll().stream().map(payment->
	          {
	        	  PaymentDTO paymentDTO=new PaymentDTO();
	        	  paymentDTO.setPaymentId(payment.getPaymentId());
                  paymentDTO.setOrderId(payment.getOrderId());
                  paymentDTO.setAmount(payment.getAmount());
                  paymentDTO.setPaymentStatus(payment.getPaymentStatus());
                  paymentDTO.setPaymentMode(payment.getPaymentMode());
                  return paymentDTO;
	          }).toList();
	    		
	    log.info("PaymentServiceManagementImpl Class getAllPayments() method is returning List<PaymentDTO>");
		
		return listOfPaymentDTOs;
	}

}
