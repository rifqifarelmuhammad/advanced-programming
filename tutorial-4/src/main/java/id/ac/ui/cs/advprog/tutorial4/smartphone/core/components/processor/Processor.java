package id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.processor;

//! Do not modify this file!
public interface Processor{
    public Double getSpeed(); // in GHz
    public Double getPrice();
    public default String getName() {
        return this.getClass().getSimpleName();
    }

}