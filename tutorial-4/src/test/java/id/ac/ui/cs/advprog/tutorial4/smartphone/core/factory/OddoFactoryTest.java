package id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.processor.Processor;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.ram.RAM;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OddoFactoryTest {

    private SmartPhoneFactory smartPhoneFactory;

    @BeforeEach
    void setUp() {
        smartPhoneFactory = new OddoFactory();
    }

    @Test
    void testAddRAMInOddoFactoryShouldAddSeRAM() {
        RAM ram = smartPhoneFactory.addRAM();
        assertEquals("SeRAM", ram.getName());
    }

    @Test
    void testAddProcessorInOddoFactoryShouldAddMediaPack() {
        Processor processor = smartPhoneFactory.addProcessor();
        assertEquals("MediaPack", processor.getName());
    }

    @Test
    void testAddScreenInOddoFactoryShouldAddDelo() {
        Screen screen = smartPhoneFactory.addScreen();
        assertEquals("Delo", screen.getName());
    }
}