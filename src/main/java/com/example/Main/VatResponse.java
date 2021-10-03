package com.example.Main;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class VatResponse {

    // anotace z důvodu nazvu atributu lastUpdate ale z Json souboru je last_udated
    @JsonProperty(value = "last_updated")
    private String lastUpdated;
    private String disclaimer;
//    private String countryAbbrev;
    private Map<String, CountryVat> rates = new HashMap<>();

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Map<String, CountryVat> getRates() {
        return rates;
    }

    public void setRates(Map<String, CountryVat> rates) {
        this.rates = rates;
    }

    // převedení klíčů do pole a
//    public Object getCountyAbbrev(int i) {
//        TreeMap<String, CountryVat> sorted = new TreeMap<>(getRates());
//        Object[] abbrevs = rates.keySet().toArray();
//        return abbrevs[i];
//    }
//
//    public void setCountyAbbrev(String countyAbbrev) {
//        this.countryAbbrev = countyAbbrev;
//    }

//    public void exportToFile(String filename) throws StateException {
//        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))){
//            for (int i = 0; i<rates.size();i++){
//                writer.println(rates.get(i));
//            }
//        }catch (FileNotFoundException e){
//            throw new StateException("");
//        }
//    }




}
