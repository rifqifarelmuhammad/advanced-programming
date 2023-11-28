package id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository;

import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Coupon;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CouponRepository {
    private final Map<String, Coupon> couponMap;

    public CouponRepository() {
        this.couponMap = new HashMap<>();
    }

    public void addCoupon(Coupon coupon) {
        couponMap.put(coupon.getCode(), coupon);
    }

    public boolean contains(String code) {
        return couponMap.containsKey(code);
    }

    public Coupon getCoupon(String code) {
        return couponMap.get(code);
    }

    public List<Coupon> getAllCoupon() {
        return couponMap.values().stream().toList();
    }

}
