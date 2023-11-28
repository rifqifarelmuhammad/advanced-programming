package id.ac.ui.cs.advprog.tutoriral6.service;

import id.ac.ui.cs.advprog.tutoriral6.core.*;
import id.ac.ui.cs.advprog.tutoriral6.core.dto.PaymentDto;
import id.ac.ui.cs.advprog.tutoriral6.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class PaymentService implements IPaymentService{

    private final FoodRepository foodRepository;
    private final CouponRepository couponRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final PaymentLogRepository paymentLogRepository;


    @Autowired
    PaymentService(FoodRepository foodRepository,
                   CouponRepository couponRepository,
                   CustomerRepository customerRepository,
                   OrderRepository orderRepository,
                    PaymentLogRepository paymentLogRepository
    ) {
        this.foodRepository = foodRepository;
        this.couponRepository = couponRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.paymentLogRepository = paymentLogRepository;
    }

    @Override
    public List<Food> allFood() {
        return foodRepository.all();
    }

    @Override
    public List<Coupon> allCoupon() {
        return couponRepository.all();
    }

    @Override
    public List<Customer> allCustomer() {
        return customerRepository.all();
    }

    @Override
    public List<Order> allOrder() {
        return orderRepository.all();
    }

    @Override
    @Async
    public Order pay(PaymentDto paymentDto) throws InterruptedException, ExecutionException {
        CompletableFuture<Food> food = foodRepository.getFuture(paymentDto.getFoodId());
        CompletableFuture<Coupon> coupon = couponRepository.getFuture(paymentDto.getCouponId());
        CompletableFuture<Customer> customer = customerRepository.getFuture(paymentDto.getCustomerId());
        CompletableFuture.allOf(customer, food, coupon).join();

        reduceCustomerBalance(customer.get(),food.get(),coupon.get());
        return new Order(customer.get().getName(), food.get().getName(), coupon.get().getDiscount());
    }

    private void reduceCustomerBalance(Customer customer, Food food, Coupon coupon) {
        CompletableFuture.runAsync(() -> {
            synchronized (customer){
                double foodPrice = food.getPrice();
                double discountedPrice = getDiscountedPrice(coupon, foodPrice);
                if (!(discountedPrice == -1)) {
                    couponNotUsed(customer, food, coupon, discountedPrice);
                } else {
                    couponIsUsed(customer, food, foodPrice);
                }
            }
        });
    }

    private double getDiscountedPrice(Coupon coupon, double foodPrice){
        try {
            return coupon.redeem(foodPrice);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void couponNotUsed(Customer customer, Food food, Coupon coupon, double discountedPrice){
        try {
            customer.setBalance(customer.getBalance() - discountedPrice);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        paymentLogRepository.add(new PaymentLog(customer, food, coupon, discountedPrice));
    }

    private void couponIsUsed(Customer customer, Food food, double foodPrice){
        try {
            customer.setBalance(customer.getBalance() - foodPrice);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        paymentLogRepository.add(new PaymentLog(customer, food, foodPrice));
    }
}
