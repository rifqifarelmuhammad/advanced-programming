package id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.processor.Processor;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.ram.RAM;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SiomiFactoryTest {

    private SmartPhoneFactory smartPhoneFactory;

    @BeforeEach
    void setUp() {
        smartPhoneFactory = new SiomiFactory();
    }

    @Test
    void testAddRAMInSiomiFactoryShouldAddGeRAM() {
        RAM ram = smartPhoneFactory.addRAM();
        assertEquals("GeRAM", ram.getName());
    }

    @Test
    void testAddProcessorInSiomiFactoryShouldAddSnackDragon() {
        Processor processor = smartPhoneFactory.addProcessor();
        assertEquals("SnackDragon", processor.getName());
    }

    @Test
    void testAddScreenInSiomiFactoryShouldAddDelo() {
        Screen screen = smartPhoneFactory.addScreen();
        assertEquals("Delo", screen.getName());
    }
}