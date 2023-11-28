package id.ac.ui.cs.advprog.tutorial4.smartphone.core.builder;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.SmartPhone;
import id.ac.ui.cs.advprog.tutorial4.smartphone.repository.SmartPhoneBrand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AndriodBuilderTest {

    private AndriodBuilder andriodBuilder;

    @BeforeEach
    void setUp() {
        andriodBuilder = new AndriodBuilder();
    }

    @Test
    void testCreateOddoSmartPhone() {
        SmartPhone smartPhone = andriodBuilder.createSmartPhone(SmartPhoneBrand.ODDO);
        assertEquals("Oddo", smartPhone.getName());
    }

    @Test
    void testCreateSiomiSmartPhone() {
        SmartPhone smartPhone = andriodBuilder.createSmartPhone(SmartPhoneBrand.SIOMI);
        assertEquals("Siomi", smartPhone.getName());
    }

    @Test
    void testCreateSumsangSmartPhone() {
        SmartPhone smartPhone = andriodBuilder.createSmartPhone(SmartPhoneBrand.SUMSANG);
        assertEquals("Sumsang", smartPhone.getName());
    }
}