package id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.adapter;

import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Gift;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Item;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.payment.Payment;

public class GiftAdapter implements Payment {
    private final Gift adaptedGift;

    public GiftAdapter(Gift gift ) {
        this.adaptedGift = gift;
    }

    @Override
    public String pay(Item item) {
        // TODO: implement method

        if (!adaptedGift.isRedeemed()){
            return adaptedGift.redeem(item);
        }else{
            return "Gift is already used";
        }
    }
}
