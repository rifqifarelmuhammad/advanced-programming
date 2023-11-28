package id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.processor.Processor;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.screen.Screen;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.components.ram.RAM;

public abstract class SmartPhone {
    private String name;
    private Processor processor;
    private RAM ram;
    private Screen screen;
    private Double price;

    public abstract void create();
    public abstract void calculatePrice();

    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public Processor getProcessor(){ return processor; }
    public void setProcessor(Processor processor){ this.processor = processor; }

    public RAM getRAM(){ return ram; }
    public void setRAM(RAM ram){ this.ram = ram; }

    public Screen getScreen(){ return screen; }
    public void setScreen(Screen screen){ this.screen = screen; }

    public Double getPrice(){ return price; }
    public void setPrice(Double price){ this.price = price; }
}