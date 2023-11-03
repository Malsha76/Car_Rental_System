package service;

import dto.CustomDTO;
import dto.PaymentDTO;

import java.util.ArrayList;

/**
 * @author Malsha Ekanayaka
 */
public interface PaymentService {
    CustomDTO paymentIdGenerate();
    void savePayment(PaymentDTO dto,String rentID);
    ArrayList<PaymentDTO> getAllPayment();
}
