package com.example.Main;

import java.util.Comparator;



public class MyComparatorVatRate implements Comparator<CountryVat> {
    @Override
    public int compare(CountryVat o1, CountryVat o2) {
        return (int) (o1.getStandardRate() - o2.getStandardRate());
    }
}
