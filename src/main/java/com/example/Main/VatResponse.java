package com.example.Main;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonArray;

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

    public void add(String jsonArray1, JsonArray jsonArray11) {
    }
}
