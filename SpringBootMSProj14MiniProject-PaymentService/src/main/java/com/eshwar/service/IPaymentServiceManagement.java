//IPaymentServiceManagement .java
package com.eshwar.service;
import java.util.List;
import com.eshwar.dto.PaymentDTO;

public interface IPaymentServiceManagement 
{
   public String makePayment(PaymentDTO paymentDTO);
   public PaymentDTO getPaymentById(Integer paymentId);
   public List<PaymentDTO> getAllPayments();
}
