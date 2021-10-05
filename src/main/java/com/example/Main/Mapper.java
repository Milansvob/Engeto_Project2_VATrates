package com.example.Main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper {

    private VatResponse vatResponse;
    List<CountryVat> vatSorted;
    String input;
    JSONObject obj;
    String json;


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
        return vatSorted;
    }


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


    public CountryVat setEnterVatFromConsole() {
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

    public JSONObject getJSONObject() throws JSONException {
        obj = new JSONObject();
        for (int i = 0; i < 3; i++) {

            obj.put("Name", vatSorted.get(i).getCountry());
            obj.put("VAT", vatSorted.get(i).getStandardRate());
            System.out.println(obj);

        }
        return obj;
    }



//    public String parseArrayListToJsonList() {
//        GsonBuilder gsonBuilder = new GsonBuilder();
//
//        // This is the main class for using Gson. Gson is typically used by first constructing a Gson instance and then invoking toJson(Object) or fromJson(String, Class) methods on it.
//        // Gson instances are Thread-safe so you can reuse them freely across multiple threads.
//        Gson gson = gsonBuilder.create();
//
//        String JSONObject = gson.toJson(vatSorted);
//        //log("\nConverted JSONObject ==> " + JSONObject);
//
//        Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
//        String prettyJson = prettyGson.toJson(vatSorted);
//
//        log("\nPretty JSONObject ==> " + prettyJson);
//        return prettyJson;
//    }
//    private static void log(Object print) {
//        System.out.println(print);
//    }


//    public String s() {
//        return json = new Gson().toJson(vatSorted );
//    }

}
