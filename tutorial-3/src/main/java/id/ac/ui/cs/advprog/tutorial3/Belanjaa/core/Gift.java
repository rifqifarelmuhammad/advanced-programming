package id.ac.ui.cs.advprog.tutorial3.Belanjaa.core;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Gift {
    private String code;
    private String itemGiftName;
    private boolean isRedeemed;

    public Gift(String code, String itemGiftName) {
        this.code = code;
        this.itemGiftName = itemGiftName;
    }

    public String redeem(Item item) {
        if (item.getName().equals(this.itemGiftName)) {
            this.isRedeemed = true;
            return String.format("Successfully paid %s using gift", item.getName());
        }
        else {
            return String.format("Your gift is not compatible with %s", item.getName());
        }
    }
}
