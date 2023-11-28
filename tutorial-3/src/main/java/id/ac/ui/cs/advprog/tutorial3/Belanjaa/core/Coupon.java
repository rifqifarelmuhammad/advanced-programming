package id.ac.ui.cs.advprog.tutorial3.Belanjaa.core;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Coupon {
    private String code;
    private double balance;
    private boolean isRedeemed;

    public Coupon(String code, double balance) {
        this.code = code;
        this.balance = balance;
    }

    public String redeem(Item item) {
        if (item.getPrice() == this.balance) {
            this.isRedeemed = true;
            return String.format("Successfully paid %s using coupon", item.getName());
        }
        else {
            return String.format("Your coupon balance is not enough to pay %s", item.getName());
        }
    }

}
