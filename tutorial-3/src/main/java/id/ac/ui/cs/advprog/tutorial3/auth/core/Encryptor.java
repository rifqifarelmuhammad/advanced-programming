package id.ac.ui.cs.advprog.tutorial3.auth.core;

import java.util.ArrayList;
import java.util.List;

public class Encryptor {
    private final List<ITransformer> steps;
    public Encryptor() {
        // TODO: Complete this function

        this.steps = new ArrayList<ITransformer>();
        this.steps.add(new Shuffler(11));
        this.steps.add(new Substituter(2));
        this.steps.add(new Shifter(3));
        this.steps.add(new Reverser());
        this.steps.add(new Substituter(15));
        this.steps.add(new Shifter(5));
        this.steps.add(new Shuffler(37));
    }

    public String encrypt(String password) {
        // TODO: Complete this function

        String tempPassword = password;

        for (int i = 0; i < this.steps.size(); i++){
            tempPassword = this.steps.get(i).transform(tempPassword);
        }

        return tempPassword;
    }

}

