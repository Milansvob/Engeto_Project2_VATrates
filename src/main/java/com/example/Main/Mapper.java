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
    private List<CountryVat> vatSorted;
    private String input;

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


    public List<CountryVat> switchHashMapToArrayListSort() {
        vatSorted = new ArrayList<>(vatResponse.getRates().values());
        Collections.sort(vatSorted);
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

    public CountryVat setEnterAbbrevFromConsole() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\033[0;1m" + "\u001B[43m" + "Enter Country Abbreviation:" + "\033[0;0m");
        while (vatResponse.getRates().get(input) == null) {
            input = sc.nextLine().toUpperCase();

            if (vatResponse.getRates().get(input) == null) {
                System.out.println("\u001B[41m" + "Was entered wrong country Abbreviation, please choose from :" +"\033[0;0m");
                System.out.println(vatResponse.getRates().keySet());
            }
        }
        return vatResponse.getRates().get(input);
    }

}
