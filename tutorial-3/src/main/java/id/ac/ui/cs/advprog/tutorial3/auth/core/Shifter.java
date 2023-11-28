package id.ac.ui.cs.advprog.tutorial3.auth.core;

public class Shifter implements ITransformer {
    private int disposition;

    public Shifter(int disposition) {
        this.disposition = disposition;
    }

    public String transform(String str) {
        // TODO: Complete this function
        String temp = str;

        if (disposition == 3){
            for (int i = 0; i < 3; i++){
                temp = shiftRightByOne(temp);
            }
        }else{
            for (int i = 0; i < 5; i++){
                temp = shiftLeftByOne(temp);
            }
        }

        return temp;
    }

    private String shiftRightByOne(String s) {
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    private String shiftLeftByOne(String s) {
        return s.substring(1) + s.charAt(0);
    }
}
