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

//
        mapper.switchHashMapToArrayList();


        // First import into PLANTS_OUTPUT_TXT
        try{
            mapper.exportToFile1(VAT_EU_OUTPUT1_CSV);
        }catch (StateException e){
            e.printStackTrace();
        }

        System.out.println(mapper.setEnterVatFromConsole());

//        MainService mainService = new MainService();
//        mainService.g();
        mapper.parseArrayListToJsonList();

    }
}



