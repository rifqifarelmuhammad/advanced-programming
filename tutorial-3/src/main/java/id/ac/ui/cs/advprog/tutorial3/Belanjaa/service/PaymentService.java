package id.ac.ui.cs.advprog.tutorial3.Belanjaa.service;

import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.PaymentMethods;

public interface PaymentService {
    String makePayment(String itemName, String paymentCode);
}
