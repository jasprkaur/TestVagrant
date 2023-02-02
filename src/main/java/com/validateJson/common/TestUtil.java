package com.validateJson.common;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.text.ParseException;

public class TestUtil {
    static JSONObject jsonObject;

    /**
     * Get JSON data from json file
     *
     */
    public static JSONObject getJsonData() {
        try {
            InputStream inputStream = TestUtil.class.getClassLoader().getResourceAsStream("TeamRCB.json");
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    /**
     * Get number of foreign players
     *
     */
    public static int getForeignPlayersCount(JSONObject jsonObject) {
        int foreignPlayerCount = 0;
        try {
            JSONArray arrayData = (JSONArray) jsonObject.get("player");
            for (int i = 0; i < arrayData.size(); i++) {
                JSONObject player = (JSONObject) arrayData.get(i);
                if (!player.get("country").equals("India")) {
                    foreignPlayerCount = foreignPlayerCount + 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foreignPlayerCount;
    }


    /**
     * Get number of players with wicket-keeper role
     *
     */
    public static int getWicketKeeperCount(JSONObject jsonObject) {
        int wicketKeeperCount = 0;
        JSONArray jsonArray = (JSONArray) jsonObject.get("player");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject player = (JSONObject) jsonArray.get(i);
            if (player.get("role").equals("Wicket-keeper")) {
                wicketKeeperCount++;
            }
        }
        return wicketKeeperCount;
    }


}


