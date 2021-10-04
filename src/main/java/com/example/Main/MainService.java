package com.example.Main;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

//@Service
public class MainService {

    CallAppi callAppi = new CallAppi();

    String body = callAppi.callApi();


    public MainService() throws IOException, InterruptedException {
    }

    public  String vatCountryList() {
        return this.body;
    }
}


//    public void g(){
//        String[][] strArray = {{"elem1-1", "elem1-2"}, {"elem2-1", "elem2-2"}};
//        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
//        for (int i = 0; i < strArray.length; i++) {
//            ArrayList<String> nextElement = new ArrayList<>();
//            for (int j = 0; j < strArray[i].length; j++) {
//                nextElement.add(strArray[i][j] + "-B");
//            }
//            arrayList.add(nextElement);
//        }
//        VatResponse jsonObj = new VatResponse();
//        // array to JsonArray
//        JsonArray jsonArray1 = new Gson().toJsonTree(strArray).getAsJsonArray();
//        // ArrayList to JsonArray
//        JsonArray jsonArray2 = new Gson().toJsonTree(arrayList).getAsJsonArray();
//        jsonObj.add("jsonArray1", jsonArray1);
//        jsonObj.add("jsonArray2", jsonArray2);
//        System.out.println(jsonObj.toString());
//    }
//}
