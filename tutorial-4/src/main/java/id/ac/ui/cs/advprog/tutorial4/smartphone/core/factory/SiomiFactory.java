package id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.processor.Processor;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.processor.SnackDragon;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.ram.GeRAM;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.ram.RAM;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.screen.Delo;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.screen.Screen;

// TODO: Fix this class
public class SiomiFactory implements SmartPhoneFactory{
    @Override
    public RAM addRAM() {
        return new GeRAM();
    }

    @Override
    public Processor addProcessor() {
        return new SnackDragon();
    }

    @Override
    public Screen addScreen() {
        return new Delo();
    }
}