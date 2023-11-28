package id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.OddoFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SmartPhoneFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SumsangFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddoTest {

    private SmartPhone smartPhone;

    @Test
    void whenCreateOddoShouldAddTheRightComponents() {
        SmartPhoneFactory smartPhoneFactory = new OddoFactory();
        smartPhone = new Oddo(smartPhoneFactory);
        smartPhone.create();
        assertNotNull(smartPhone.getProcessor());
        assertNotNull(smartPhone.getRAM());
        assertNotNull(smartPhone.getScreen());
    }

    @Test
    void whenCalculateOddoPriceWithOddoFactory() {
        smartPhone = new Oddo(new OddoFactory());
        smartPhone.create();
        smartPhone.calculatePrice();
        assertEquals(1700000, smartPhone.getPrice());
    }

    @Test
    void whenCalculateOddoPriceWithAnotherFactory() {
        smartPhone = new Oddo(new SumsangFactory());
        smartPhone.create();
        smartPhone.calculatePrice();
        assertEquals(2040000, smartPhone.getPrice());
    }
}