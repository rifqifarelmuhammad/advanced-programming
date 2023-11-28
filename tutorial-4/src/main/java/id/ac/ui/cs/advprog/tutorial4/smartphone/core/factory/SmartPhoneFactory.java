package id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.processor.Processor;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.screen.Screen;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.ram.RAM;

//! Do not modify this file!
public interface SmartPhoneFactory {
    public RAM addRAM();
    public Processor addProcessor();
    public Screen addScreen();
}