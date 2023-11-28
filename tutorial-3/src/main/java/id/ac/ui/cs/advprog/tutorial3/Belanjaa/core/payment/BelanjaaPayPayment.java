package id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.payment;

import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Item;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BelanjaaPayPayment implements Payment {
    private String belanjaaPayId;
    private double balance;

    public BelanjaaPayPayment(String belanjaaPayId, double balance) {
        this.belanjaaPayId = belanjaaPayId;
        this.balance = balance;
    }

    @Override
    public String pay(Item item) {
        double reducedBalance =  this.balance - item.getPrice();
        if (reducedBalance < 0) {
            return String.format("Your BelanjaaPay balance is not enough to pay %s", item.getName());
        }
        else {
            this.balance = reducedBalance;
            return String.format("Successfully paid %s using BelanjaaPay", item.getName());
        }
    }
}
