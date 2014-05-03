package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import us.monoid.json.JSONObject;

import static org.testng.Assert.*;

public class BloodOxygenEntityTest {

    private BloodOxygenEntity bloodOxygenEntity;

    @BeforeTest
    public void setUp() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        client.setDebug(true);
        bloodOxygenEntity = client.bloogOxygenEntity();
    }

    @Test
    public void testLatest() throws Exception {
        // No data for testing, test commented
        /*
        JSONObject res = bloodOxygenEntity.latest();
        assertNotNull(res);
        assertNotNull(res.getString("id"));
        assertNotNull(res.getString("timestamp"));
        //assertNotNull(res.getInt("value"));
        assertNotNull(res.getString("source"));
        */
    }
}
