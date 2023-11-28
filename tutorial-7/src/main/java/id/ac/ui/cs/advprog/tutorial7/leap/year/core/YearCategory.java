package id.ac.ui.cs.advprog.tutorial7.leap.year.core;

public enum YearCategory {
    NOT_DIVISIBLE_BY_4(false),
    DIVISIBLE_BY_4(true),
    DIVISIBLE_BY_100(false),
    DIVISIBLE_BY_400(true);
    
    private final boolean leapYear;

    YearCategory(boolean isLeapYear){
        this.leapYear = isLeapYear;
    }
    
    public boolean isLeapYear(){
        return this.leapYear;
    }
    
    @Override
    public String toString() {
        return this.name().replace('_', ' ').toLowerCase();
    }
}
