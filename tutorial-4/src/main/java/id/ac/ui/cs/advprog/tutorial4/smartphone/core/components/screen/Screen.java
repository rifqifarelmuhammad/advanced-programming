package id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.screen;

//! Do not modify this file!
public interface Screen{
    public Double getRefreshRate(); // in Hz
    public Double getPrice();
    public default String getName() {
        return this.getClass().getSimpleName();
    }
}