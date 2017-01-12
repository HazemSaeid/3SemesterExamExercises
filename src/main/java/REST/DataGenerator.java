/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package REST;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author HazemSaeid
 */
public class DataGenerator {

    public String getData(int amount, String data) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String[] temp = data.split(",");
        List<String> list = new ArrayList();
        list.add(RandomStringUtils.random(5, true, true));
        list.add(RandomStringUtils.random(7, true, true));
        list.add(RandomStringUtils.random(8, true, true));
        list.add(RandomStringUtils.random(3, true, true));
        list.add(RandomStringUtils.random(9, true, true));
        list.add(RandomStringUtils.random(3, true, true));


        JSONArray names = new JSONArray();
        Random r = new Random();
        for (int i = 0; i < amount; i++) {
        JsonObject person = new JsonObject();
            for (String s : temp) {
                person.addProperty(s, list.get(r.nextInt(list.size())));
            }
            names.add(person);

        }

        String jsonStr = gson.toJson(names); //The JSON string is ready
        System.out.println(jsonStr);
        return jsonStr;
    }

    public static void main(String[] args) {
        DataGenerator d = new DataGenerator();
        List<String> data1 = new ArrayList();
        d.getData(20, "fName,lName,street");
    }
}
