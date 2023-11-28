package id.ac.ui.cs.advprog.tutorial4.smartphone.service;

import id.ac.ui.cs.advprog.tutorial4.smartphone.core.brand.SmartPhone;
import id.ac.ui.cs.advprog.tutorial4.smartphone.repository.SmartPhoneBrand;

import java.util.List;

//! Do not modify this file!
public interface SmartPhoneService {
    public SmartPhone createSmartPhone(SmartPhoneBrand smartPhoneBrand);
    public List<SmartPhoneBrand> getAllBrands();
}
