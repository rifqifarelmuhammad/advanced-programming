package id.ac.ui.cs.advprog.tutorial7.leap.year.service;

import id.ac.ui.cs.advprog.tutorial7.leap.year.core.YearCategory;
import org.springframework.stereotype.Service;

import static id.ac.ui.cs.advprog.tutorial7.leap.year.core.YearCategory.*;

@Service
public class LeapYearServiceImpl implements LeapYearService {
    @Override
    public String getYearCategoryAsString(long year) {
        YearCategory yearCategory = getYearCategory(year);

        final String isLeapYear = yearCategory.isLeapYear() ? "is":"isn't";

        return String.format("%d %s a leap year because it is %s.", year, isLeapYear, yearCategory.toString());
    }

    private YearCategory getYearCategory(long year){
        if (year % 400 == 0){
            return DIVISIBLE_BY_400;
        }

        if (year % 100 == 0){
            return DIVISIBLE_BY_100;
        }

        if (year % 4 == 0){
            return DIVISIBLE_BY_4;
        }

        return NOT_DIVISIBLE_BY_4;
    }
}
