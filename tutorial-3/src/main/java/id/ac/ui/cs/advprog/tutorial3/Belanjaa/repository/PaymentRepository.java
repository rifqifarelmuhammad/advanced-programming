package id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.payment.BelanjaaPayPayment;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.payment.Payment;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PaymentRepository {
    private final Map<String, Payment> paymentMap;

    public PaymentRepository() {
        this.paymentMap = new HashMap<>();
    }

    public Payment getPayment(String code) {
        return paymentMap.get(code);
    }

    public boolean contains(String code) {
        return paymentMap.containsKey(code);
    }

    public void addPayment(Payment payment) {
        if (payment instanceof BelanjaaPayPayment) {
            paymentMap.put(((BelanjaaPayPayment) payment).getBelanjaaPayId(), payment);
        }
    }

    public List<Payment> getAllPayment() {
        return paymentMap.values().stream().toList();
    }

}
