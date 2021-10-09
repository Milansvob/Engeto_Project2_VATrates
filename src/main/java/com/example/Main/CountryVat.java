package com.example.Main;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryVat implements Comparable<CountryVat>{

    private String country;
    @JsonProperty(value = "standard_rate")
    private Double standardRate;
    @JsonProperty(value = "reduced_rate")
    private String reducedRate;


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

    public String getReducedRate() {
        return reducedRate;
    }

    public void setReducedRate(String reducedRate) {
        this.reducedRate = reducedRate;
    }

    @Override
    public String toString() {
        //return " Country - " + getCountry() + " | Vat standard rate = " + getStandardRate() + " | " + getReduced_rate() ;
        return  "Standard Rate: " + getStandardRate() + " | Reduced Rate: " + getReducedRate() + " | Country: " + getCountry()  ;
    }

    @Override
    public int compareTo(CountryVat countryVat) {
        return (int) (this.standardRate - countryVat.getStandardRate());
    }
}