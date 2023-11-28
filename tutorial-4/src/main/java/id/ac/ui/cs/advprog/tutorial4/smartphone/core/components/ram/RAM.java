package id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.ram;

//! Do not modify this file!
public interface RAM{
    public Double getSize(); // in GB
    public Double getPrice();
    public default String getName() {
        return this.getClass().getSimpleName();
    }
}