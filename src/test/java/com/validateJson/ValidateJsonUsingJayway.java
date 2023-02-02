package com.validateJson;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.apache.commons.io.IOUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ValidateJsonUsingJayway {
    String jsonString = "";

    @BeforeTest
    public void beforeclass() throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("TeamRCB.json");
        jsonString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        inputStream.close();
    }

    @Test
    public void validateForeignPlayersCount() throws IOException {
        String jPathExpression = "$.player[?(@.country!='India')]";
        JSONArray foreignPlayerArray = JsonPath.read(jsonString, jPathExpression);
        Assert.assertEquals(foreignPlayerArray.size(), 4);
    }

    @Test
    public void validateWicketKeeperCount() {
        String jPathExpression = "$.player[?(@.role=='Wicket-keeper')]";
        JSONArray wicketKeeperArray = JsonPath.read(jsonString, jPathExpression);
        Assert.assertEquals(wicketKeeperArray.size(), 1);
    }
}
