package id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.adapter;

import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Coupon;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Item;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.payment.Payment;

public class CouponAdapter  implements Payment {
    private final Coupon adaptedCoupon;

    public CouponAdapter(Coupon coupon) {
        this.adaptedCoupon = coupon;
    }

    @Override
    public String pay(Item item) {
        // TODO: implement method
        if (!adaptedCoupon.isRedeemed()){
            return adaptedCoupon.redeem(item);
        }else{
            return "Coupon is already used";
        }
    }
}
