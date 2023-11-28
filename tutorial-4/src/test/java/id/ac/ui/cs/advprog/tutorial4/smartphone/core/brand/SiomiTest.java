package id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.OddoFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SiomiFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SmartPhoneFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SiomiTest {

    private SmartPhone smartPhone;

    @Test
    void whenCreateSiomiShouldAddTheRightComponents() {
        SmartPhoneFactory smartPhoneFactory = new SiomiFactory();
        smartPhone = new Siomi(smartPhoneFactory);
        smartPhone.create();
        assertNotNull(smartPhone.getProcessor());
        assertNotNull(smartPhone.getRAM());
        assertNotNull(smartPhone.getScreen());
    }

    @Test
    void whenCalculateSiomiPriceWithSiomiFactory() {
        smartPhone = new Siomi(new SiomiFactory());
        smartPhone.create();
        smartPhone.calculatePrice();
        assertEquals(1310000, smartPhone.getPrice());
    }

    @Test
    void whenCalculateSiomiPriceWithAnotherFactory() {
        smartPhone = new Siomi(new OddoFactory());
        smartPhone.create();
        smartPhone.calculatePrice();
        assertEquals(1390000, smartPhone.getPrice());
    }
}