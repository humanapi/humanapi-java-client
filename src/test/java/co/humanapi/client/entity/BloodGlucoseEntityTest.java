package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.testng.Assert.*;

public class BloodGlucoseEntityTest {

    private BloodGlucoseEntity bloodGlucoseEntity;

    @BeforeTest
    public void setUp() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        //client.setDebug(true);
        bloodGlucoseEntity = client.bloogGlucoseEntity();
    }

    @Test
    public void testLatest() throws Exception {
        JSONObject res = bloodGlucoseEntity.latest();
        assertNotNull(res);
        assertNotNull(res.getString("id"));
        assertNotNull(res.getString("timestamp"));
        assertNotNull(res.getInt("value"));
        assertNotNull(res.getString("source"));
    }

    @Test
    public void testReadings() throws Exception {
        JSONArray res = bloodGlucoseEntity.readings();
        assertNotNull(res);
        assertTrue(res.length() > 0);
        JSONObject obj = res.getJSONObject(0);
        assertNotNull(obj.getString("id"));
        assertNotNull(obj.getString("timestamp"));
        assertNotNull(obj.getInt("value"));
        assertNotNull(obj.getString("source"));
    }

    @Test
    public void testReading() throws Exception {
        JSONObject res = bloodGlucoseEntity.reading("52e20cb3fff56aac6200044a");
        assertNotNull(res);
        assertNotNull(res.getString("id"));
        assertNotNull(res.getString("timestamp"));
        assertNotNull(res.getInt("value"));
        assertNotNull(res.getString("source"));
    }

    @Test
    public void testDaily() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        JSONArray res = bloodGlucoseEntity.daily(df.parse("2014-01-23"));
        assertNotNull(res);
        assertTrue(res.length() > 0);
        JSONObject obj = res.getJSONObject(0);
        assertNotNull(obj.getString("id"));
        assertNotNull(obj.getString("timestamp"));
        assertNotNull(obj.getInt("value"));
        assertNotNull(obj.getString("source"));
    }

    @Test
    public void testDaily1() throws Exception {

    }
}
