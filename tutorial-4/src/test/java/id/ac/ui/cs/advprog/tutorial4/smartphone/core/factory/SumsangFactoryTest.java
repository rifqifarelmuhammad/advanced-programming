package id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.processor.Processor;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.ram.RAM;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumsangFactoryTest {

    private SmartPhoneFactory smartPhoneFactory;

    @BeforeEach
    void setUp() {
        smartPhoneFactory = new SumsangFactory();
    }

    @Test
    void testAddRAMInSumsangFactoryShouldAddSeRAM() {
        RAM ram = smartPhoneFactory.addRAM();
        assertEquals("SeRAM", ram.getName());
    }

    @Test
    void testAddProcessorInSumsangFactoryShouldAddExyYes() {
        Processor processor = smartPhoneFactory.addProcessor();
        assertEquals("ExyYes", processor.getName());
    }

    @Test
    void testAddScreenInSumsangFactoryShouldAddAlomed() {
        Screen screen = smartPhoneFactory.addScreen();
        assertEquals("Alomed", screen.getName());
    }
}