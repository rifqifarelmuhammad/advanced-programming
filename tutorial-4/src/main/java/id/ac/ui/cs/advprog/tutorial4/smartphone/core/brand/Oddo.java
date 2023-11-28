package id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SmartPhoneFactory;

public class Oddo extends SmartPhone{
    SmartPhoneFactory smartPhoneFactory;

    public Oddo(SmartPhoneFactory smartPhoneFactory){
        this.smartPhoneFactory = smartPhoneFactory;
        setName("Oddo");
    }

    // TODO: Complete this method
    public void create(){
        System.out.println("Creating smartphone " + getName());
        this.setRAM(this.smartPhoneFactory.addRAM());
        this.setProcessor(this.smartPhoneFactory.addProcessor());
        this.setScreen(this.smartPhoneFactory.addScreen());
        calculatePrice();
    }

    // TODO: Complete this method
    public void calculatePrice() {
        System.out.println("Calculating price for " + getName());
        this.setPrice((2 * this.getProcessor().getPrice()) + (2 * this.getRAM().getPrice()) + (2 * this.getScreen().getPrice()));
    }
}