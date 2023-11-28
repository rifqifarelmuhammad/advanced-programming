package id.ac.ui.cs.advprog.tutorial4.smartphone.core.builder;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.SmartPhone;
import id.ac.ui.cs.advprog.tutorial4.smartphone.repository.SmartPhoneBrand;

public abstract class SmartPhoneBuilder {
    protected abstract SmartPhone createSmartPhone(SmartPhoneBrand smartPhoneBrand);

    public SmartPhone getSmartPhone(SmartPhoneBrand smartPhoneBrand){
        SmartPhone smartPhone = createSmartPhone(smartPhoneBrand);
        // TODO: do something here
        smartPhone.create();

        return  smartPhone;
    }
}