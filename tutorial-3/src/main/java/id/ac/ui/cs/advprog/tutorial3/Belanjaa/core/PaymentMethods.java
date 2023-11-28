package id.ac.ui.cs.advprog.tutorial3.Belanjaa.core;

import lombok.Getter;

@Getter
public enum PaymentMethods {
    COUPON("Coupon"),
    GIFT("Gift"),
    BELANJAAPAYMENT("Belanjaa Payment");

    private final String name;

    PaymentMethods(String name) {
        this.name = name;
    }

}
