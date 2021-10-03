package com.example.Main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryVat implements Comparable<CountryVat>{

        private String country;
    @JsonProperty(value = "standard_rate")
    private Double standardRate;


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(Double standardRate) {
        this.standardRate = standardRate;
    }

    @Override
    public String toString() {
        return " Country - " + getCountry() + " -  Vat standard rate = " + standardRate ;
    }

    @Override
    public int compareTo(CountryVat countryVat) {
        return (int) (this.standardRate - countryVat.getStandardRate());
    }
}
