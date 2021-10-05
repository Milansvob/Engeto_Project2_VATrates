package com.example.Main;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    final Mapper mapper;
    public MainController(Mapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping(path = "/getJSONObject")
    public JSONObject getJSONObject() throws JSONException {
        return mapper.getJSONObject();
    }
}

