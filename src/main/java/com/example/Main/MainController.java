package com.example.Main;

import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    String countryVatToTextCountriesSortedVAT;
    String countryVatToTextThreeCountriesVatLowest;
    String countryVatToTextThreeCountriesVatHighest;

    String finalTextCountriesSortedVAT = "";
    String finalTextThreeCountriesVatLowest = "";
    String finalTextThreeCountriesVatHighest = "";

    Mapper mapper = new Mapper();
    public MainController() throws JSONException, IOException, InterruptedException {
        this.init();
    }

    private void init() throws JSONException, IOException, InterruptedException {

        CallAppi callAppi = new CallAppi();
        String body = callAppi.callApi();
        mapper = new Mapper();
        mapper.mapToObject(body);
        mapper.switchHashMapToArrayListSort();
    }


    @GetMapping(path = "/getAllCountriesSortedVat")
    public String getAllCountriesSortedVat()  {
        for ( int i=0; i<mapper.switchHashMapToArrayListSort().size(); i++) {
            countryVatToTextCountriesSortedVAT = mapper.switchHashMapToArrayListSort().get(i).toString();
                finalTextCountriesSortedVAT += countryVatToTextCountriesSortedVAT + "\n";
        }
        return "Countries list sorted according VAT: " +"\n" + finalTextCountriesSortedVAT;
    }

    @GetMapping(path = "/getThreeCountriesLowestVat")
    public String getThreeCountriesLowestVat() {
        for (int i = 0; i < 3; i++) {
            countryVatToTextThreeCountriesVatLowest = mapper.switchHashMapToArrayListSort().get(i).toString();
            finalTextThreeCountriesVatLowest += countryVatToTextThreeCountriesVatLowest + "\n";
        }
        return "List of three countries with lowest VAT: " +"\n" + finalTextThreeCountriesVatLowest;
    }

        @GetMapping(path = "/getThreeCountriesHighestVat")
        public String getThreeCountriesHighestVat()  {
        for ( int i= mapper.switchHashMapToArrayListSort().size()-3; i<mapper.switchHashMapToArrayListSort().size(); i++) {
            countryVatToTextThreeCountriesVatHighest = mapper.switchHashMapToArrayListSort().get(i).toString();
            finalTextThreeCountriesVatHighest += countryVatToTextThreeCountriesVatHighest + "\n";
        }
        return "List of three countries with highest VAT: " +"\n" + finalTextThreeCountriesVatHighest;
    }

    @GetMapping(path = "/setEnterAbbrevFromConsole")
    public String setEnterAbbrevFromConsole()  {
        return mapper.setEnterAbbrevFromConsole().toString();
    }


}
