package com.example.Main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private VatResponse vatResponse;
    //private List<Entry<String, CountryVat>> listOfEntry;
    List<CountryVat> vatSorted;
    String input;


    // teď je potřeba udělat mapování k tomu ptřebuju ObjecMapper a vytvořit si třídy do kterých to budu ukládat
    // ten string, který jsme si zavolali z toho Appy přemapujeme do tohohle objektu
    public VatResponse mapToObject(String body) throws JsonProcessingException {

        //Mapper přemapovává hodnoty uložené v Json do Javových objektů a zase zpátky
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        vatResponse = objectMapper.readValue(body, VatResponse.class);

        // tohle mi vytiskne kolik je tam zemí
        System.out.println("Rates count " + vatResponse.getRates().size());

        // z vatRespons udělat zpátky String
        //String out = objectMapper.writeValueAsString(vatResponse);

        return vatResponse;
    }

    public VatResponse getVatResponse() {
        return vatResponse;
    }

    public void setVatResponse(VatResponse vatResponse) {
        this.vatResponse = vatResponse;
    }

    // public List<Entry<String, CountryVat>> switchHashMapToArrayList() {
    public List<CountryVat> switchHashMapToArrayList() {
        vatSorted = new ArrayList<>(vatResponse.getRates().values());
        Collections.sort(vatSorted);

        System.out.println("3 countries with the lowest VAT rates:");
        for (int i = 0; i < 3; i++) {
            System.out.println(vatSorted.get(i));
        }

        System.out.println("3 countries with the highest VAT rates:");
        for (int i = vatSorted.size() - 3; i < vatSorted.size(); i++) {
            System.out.println(vatSorted.get(i));
        }


        // Set of the entries from the HashMap
//        Set<Map.Entry<String, CountryVat>> entrySet
//                = vatResponse.getRates().entrySet();

//         listOfEntry = vatResponse.getRates().entrySet()
//                .stream()
//                .collect(Collectors.toList());

        // Creating an ArrayList of Entry objects
        //listOfEntry = new ArrayList<>(entrySet);


        return vatSorted;
    }

//    public void select3CountriesWLowestVAT() {
//        System.out.println("3 countries with the lowest VAT rates:");
//        for (int i = 0; i < 3; i++) {
//            System.out.println(switchHashMapToArrayList().get(i));
//        }
//    }

    public void exportToFile1(String filename) throws StateException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
            for (int i = 0; i < 3; i++) {
                writer.println(vatSorted.get(i));
            }
            for (int i = vatSorted.size() - 3; i < vatSorted.size(); i++) {
                writer.println(vatSorted.get(i));
            }
        } catch (FileNotFoundException e) {
            throw new StateException("");
        }
    }

    public CountryVat setEnterVatFromConsole()  {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Country Abbreviation:");
        while (vatResponse.getRates().get(input) == null) {
            input = sc.nextLine().toUpperCase();

            if (vatResponse.getRates().get(input) == null) {
                System.out.println("Was entered wrong country Abbreviation, please reenter:");
            }
        }
        return vatResponse.getRates().get(input);
    }
}
