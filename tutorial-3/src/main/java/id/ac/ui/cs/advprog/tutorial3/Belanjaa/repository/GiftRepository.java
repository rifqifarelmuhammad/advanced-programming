package id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Gift;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GiftRepository {
    private final Map<String, Gift> giftMap;

    public GiftRepository() {
        this.giftMap = new HashMap<>();
    }

    public void addGift(Gift gift) {
        giftMap.put(gift.getCode(), gift);
    }

    public boolean contains(String code) {
        return giftMap.containsKey(code);
    }

    public Gift getGift(String code) {
        return giftMap.get(code);
    }

    public List<Gift> getAllGift() {
        return giftMap.values().stream().toList();
    }

}
