package id.ac.ui.cs.advprog.tutorial3.Belanjaa;

import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.CodeGenerator;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Coupon;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Gift;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Item;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.payment.BelanjaaPayPayment;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.CouponRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.GiftRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.PaymentRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BelanjaaInitializer {
    // don't modify the code

    private final CouponRepository couponRepository;
    private final GiftRepository giftRepository;
    private final ItemRepository itemRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public BelanjaaInitializer(CouponRepository couponRepository,
                               GiftRepository giftRepository,
                               ItemRepository itemRepository,
                               PaymentRepository paymentRepository) {
        this.couponRepository = couponRepository;
        this.giftRepository = giftRepository;
        this.itemRepository = itemRepository;
        this.paymentRepository = paymentRepository;
    }

    @PostConstruct
    public void init() {
        // Add initial Item
        itemRepository.addItem(new Item("Face Mask", 15_000));
        itemRepository.addItem(new Item("Kemeja", 200_000));
        itemRepository.addItem(new Item("Headphone", 25_000));
        itemRepository.addItem(new Item("Laptop", 12_000_000));
        itemRepository.addItem(new Item("Lip Balm", 50_000));
        itemRepository.addItem(new Item("Topi", 70_000));

        // Add BelanjaaPay
        paymentRepository.addPayment(new BelanjaaPayPayment(CodeGenerator.generate(), 2_000_000));
        paymentRepository.addPayment(new BelanjaaPayPayment(CodeGenerator.generate(), 150_000));
        paymentRepository.addPayment(new BelanjaaPayPayment(CodeGenerator.generate(), 20_000_000));

        // add Coupon
        couponRepository.addCoupon(new Coupon(CodeGenerator.generate(),25_000));
        couponRepository.addCoupon(new Coupon(CodeGenerator.generate(),25_000));
        couponRepository.addCoupon(new Coupon(CodeGenerator.generate(),50_000));
        couponRepository.addCoupon(new Coupon(CodeGenerator.generate(),15_000));

        // add Gift
        giftRepository.addGift(new Gift(CodeGenerator.generate(),"Face Mask"));
        giftRepository.addGift(new Gift(CodeGenerator.generate(),"Kemeja"));
        giftRepository.addGift(new Gift(CodeGenerator.generate(),"Headphone"));

    }

}