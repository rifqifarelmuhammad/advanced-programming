package id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SiomiFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SmartPhoneFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SumsangFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumsangTest {

    private SmartPhone smartPhone;

    @Test
    void whenCreateSumsangShouldAddTheRightComponents() {
        SmartPhoneFactory smartPhoneFactory = new SumsangFactory();
        smartPhone = new Sumsang(smartPhoneFactory);
        smartPhone.create();
        assertNotNull(smartPhone.getProcessor());
        assertNotNull(smartPhone.getRAM());
        assertNotNull(smartPhone.getScreen());
    }

    @Test
    void whenCalculateSumsangPriceWithSumsangFactory() {
        smartPhone = new Sumsang(new SumsangFactory());
        smartPhone.create();
        smartPhone.calculatePrice();
        assertEquals(2685000, smartPhone.getPrice());
    }

    @Test
    void whenCalculateSumsangPriceWithAnotherFactory() {
        smartPhone = new Sumsang(new SiomiFactory());
        smartPhone.create();
        smartPhone.calculatePrice();
        assertEquals(2340000, smartPhone.getPrice());
    }
}