package com.validateJson;

import com.validateJson.common.TestUtil;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

public class validateJsonUsingJsonSimple {
    JSONObject jsonObject;

    @BeforeClass
    public void beforeMethod() throws IOException {
        jsonObject = TestUtil.getJsonData();
    }

    @Test
    public void validateForeignPlayersCount() {
        Assert.assertEquals(TestUtil.getForeignPlayersCount(jsonObject), 4);
    }

    @Test
    public void validateWicketKeeperCount() {
        Assert.assertEquals(TestUtil.getWicketKeeperCount(jsonObject), 1);
    }
}
