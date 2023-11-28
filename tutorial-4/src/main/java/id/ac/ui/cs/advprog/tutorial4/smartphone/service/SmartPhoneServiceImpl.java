package id.ac.ui.cs.advprog.tutorial4.smartphone.service;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.SmartPhone;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.builder.AndriodBuilder;
import id.ac.ui.cs.advprog.tutorial4.smartphone.core.builder.SmartPhoneBuilder;
import id.ac.ui.cs.advprog.tutorial4.smartphone.repository.SmartPhoneBrand;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

//! Do not modify this file!
@Service
public class SmartPhoneServiceImpl implements SmartPhoneService{
    SmartPhoneBuilder builder = new AndriodBuilder();
    @Override
    public SmartPhone createSmartPhone(SmartPhoneBrand smartPhoneBrand) {
        SmartPhone smartPhone = builder.getSmartPhone(smartPhoneBrand);
        return smartPhone;
    }

    @Override
    public List<SmartPhoneBrand> getAllBrands() {
        return Arrays.asList(SmartPhoneBrand.values());
    }

}
