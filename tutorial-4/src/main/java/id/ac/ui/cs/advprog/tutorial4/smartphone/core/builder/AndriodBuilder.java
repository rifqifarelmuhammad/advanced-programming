package id.ac.ui.cs.advprog.tutorial4.smartphone.core.builder;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.Oddo;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.Siomi;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.Sumsang;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.OddoFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SiomiFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SmartPhoneFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.SmartPhone;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.factory.SumsangFactory;
import id.ac.ui.cs.advprog.tutorial4.smartphone.repository.SmartPhoneBrand;

public class AndriodBuilder extends SmartPhoneBuilder{
    // TODO: Complete this method
    protected SmartPhone createSmartPhone(SmartPhoneBrand smartPhoneBrand){
        SmartPhone smartPhone = null;
        SmartPhoneFactory smartPhoneFactory;

        if(smartPhoneBrand.equals(SmartPhoneBrand.SUMSANG)){
            smartPhoneFactory = new SumsangFactory();
            smartPhone = new Sumsang(smartPhoneFactory);
        }else if(smartPhoneBrand.equals(SmartPhoneBrand.SIOMI)){
            smartPhoneFactory = new SiomiFactory();
            smartPhone = new Siomi(smartPhoneFactory);
        }else if(smartPhoneBrand.equals(SmartPhoneBrand.ODDO)){
            smartPhoneFactory = new OddoFactory();
            smartPhone = new Oddo(smartPhoneFactory);
        }

        return  smartPhone;
    }
}