package com.example.Main;

import org.json.JSONException;

import java.io.IOException;

public class Main {

    public static final String VAT_EU_OUTPUT_CSV = "vat-lowest-highest.txt";

    public static void enter (){
        System.out.println();
    }

    public static void main(String[]args) throws IOException, InterruptedException, JSONException {
        //vytvoření instance třídy
        CallAppi callAppi = new CallAppi();
        // zavolání metody callApi
        String body = callAppi.callApi();

        Mapper mapper = new Mapper();
        mapper.mapToObject(body);

        enter();

        System.out.println("\033[0;1m" + "\u001B[43m" + "3 countries with the lowest VAT rates:" + "\033[0;0m");
        for (int i = 0; i < 3; i++) {
            System.out.println(mapper.switchHashMapToArrayListSort().get(i));
        }

        enter();

        System.out.println("\033[0;1m" + "\u001B[43m" + "3 countries with the highest VAT rates:" + "\033[0;0m");
        for (int i = mapper.switchHashMapToArrayListSort().size() - 3; i < mapper.switchHashMapToArrayListSort().size(); i++) {
            System.out.println(mapper.switchHashMapToArrayListSort().get(i));
        }

        enter();

        //Print country according its abbreviation entered in console
        System.out.println(mapper.setEnterAbbrevFromConsole());


        // Import into VAT_EU_OUTPUT1_CSV
        try{
            mapper.exportToFile1(VAT_EU_OUTPUT_CSV);
        }catch (StateException e){
            e.printStackTrace();
        }
    }
}



