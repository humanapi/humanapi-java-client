package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import us.monoid.json.JSONObject;

import static org.testng.Assert.*;

public class BloodPressureEntityTest {

    private BloodPressureEntity bloodPressureEntity;

    @BeforeTest
    public void setUp() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        //client.setDebug(true);
        bloodPressureEntity = client.bloogPressureEntity();
    }

    @Test
    public void testLatest() throws Exception {
        JSONObject res = bloodPressureEntity.latest();
        assertNotNull(res);
        assertNotNull(res.getString("id"));
        assertNotNull(res.getString("timestamp"));
        assertNotNull(res.getInt("systolic"));
        assertNotNull(res.getInt("diastolic"));
        assertNotNull(res.getString("source"));
    }
}
