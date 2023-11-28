package id.ac.ui.cs.advprog.tutorial4.smartphone.repository;

//! Do not modify this file!
public enum SmartPhoneBrand {
    SUMSANG, SIOMI, ODDO;

    public String toString() {
        switch(this) {
            case SUMSANG: return "Sumsang";
            case SIOMI: return "Siomi";
            case ODDO: return "Oddo";
            default: throw new IllegalArgumentException();
        }
    }
}
