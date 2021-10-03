package com.example.Main;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class Main {

    public static final String VAT_EU_OUTPUT1_CSV = "vat-lowest-highest.txt";


    public static void main(String[]args) throws IOException, InterruptedException {
        //vytvoření instance třídy
        CallAppi callAppi = new CallAppi();
        // zavolání metody callApi
        String body = callAppi.callApi();

        Mapper mapper = new Mapper();
        mapper.mapToObject(body);

//        List<CountryVat> vatSorted = new ArrayList<>(mapper.getVatResponse().getRates().values());
//        Collections.sort(vatSorted);
//
//        System.out.println("3 countries with the lowest VAT rates:");
//        for (int i=0; i< 3;i++) {
//            System.out.println(vatSorted.get(i));
//        }
//
//        System.out.println("3 countries with the highest VAT rates:");
//        for (int i=vatSorted.size()-3; i < vatSorted.size(); i++) {
//            System.out.println(vatSorted.get(i));
//        }

//       SortedSet<CountryVat> values = new TreeSet<>(mapper.getVatResponse().getRates().values());
//       System.out.println(values);
//
//        TreeMap<String, CountryVat> sorted = new TreeMap<>(mapper.getVatResponse().getRates());
//       System.out.println("+++++"+sorted+"++++");


//        for (Map.Entry<String, CountryVat> entry : mapper.getVatResponse().getRates().entrySet()) {
//            String key = entry.getKey();
//            CountryVat value = entry.getValue();
//            System.out.println(key + "  " + value);
//        }


//        mapper.getVatResponse().getRates().entrySet()
//                .stream()
//                .sorted(Map.Entry.comparingByValue())
//                .forEach(System.out::println);

//        // Set of the entries from the HashMap
//        Set<Map.Entry<String, CountryVat> > entrySet
//                = mapper.getVatResponse().getRates().entrySet();
//
//        // Creating an ArrayList of Entry objects
//        List<Map.Entry<String, CountryVat> > listOfEntry
//                = new ArrayList<>(entrySet);
//
//        System.out.println("00000"+listOfEntry);
//
//
//
//
//       // Collections.sort(ListOfEntry);
//        System.out.println("3 countries with the lowest VAT rates:");
//        for (int i=0; i< 3;i++) {
//            System.out.println(listOfEntry.get(i));
//        }


        mapper.switchHashMapToArrayList();

        // First import into PLANTS_OUTPUT_TXT
        try{
            mapper.exportToFile1(VAT_EU_OUTPUT1_CSV);
        }catch (StateException e){
            e.printStackTrace();
        }

        System.out.println(mapper.setEnterVatFromConsole());

    }
}



