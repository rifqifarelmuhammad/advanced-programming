package id.ac.ui.cs.advprog.tutorial3.Belanjaa.controller;

import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.CouponRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.GiftRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.ItemRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository.PaymentRepository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = {"belanjaa","belanjaa/"})
public class BelanjaaController {

    private final CouponRepository couponRepository;
    private final PaymentRepository paymentRepository;
    private final GiftRepository giftRepository;
    private final ItemRepository itemRepository;
    private final PaymentService paymentService;

    @Autowired
    public BelanjaaController(CouponRepository couponRepository,
                              PaymentRepository paymentRepository,
                              GiftRepository giftRepository,
                              ItemRepository itemRepository,
                              PaymentService paymentService) {
        this.couponRepository = couponRepository;
        this.paymentRepository = paymentRepository;
        this.giftRepository = giftRepository;
        this.itemRepository = itemRepository;
        this.paymentService = paymentService;
    }

    @GetMapping(path = {""})
    public String home(Model model,@RequestParam(required = false) String item,@RequestParam(required = false) String code) {
        model.addAttribute("items", itemRepository.getAllItem());
        model.addAttribute("payments",paymentRepository.getAllPayment());
        model.addAttribute("gifts",giftRepository.getAllGift());
        model.addAttribute("coupons",couponRepository.getAllCoupon());
        model.addAttribute("log",paymentService.makePayment(item,code));

        return "Belanjaa/home";
    }
}
