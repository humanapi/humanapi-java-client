package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class ActivityEntityTest {

    private ActivityEntity activityEntity;

    @BeforeTest
    public void setUp() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        //client.setDebug(true);
        activityEntity = client.activityEntity();
    }

    @Test
    public void testList() throws Exception {
        JSONArray res = activityEntity.list();
        assertNotNull(res);
        assertTrue(res.length() > 0);
        JSONObject obj = res.getJSONObject(0);
        assertNotNull(obj.getString("id"));
        assertNotNull(obj.getString("startTime"));
        assertNotNull(obj.getInt("duration"));
        assertNotNull(obj.getString("source"));
    }

    @Test
    public void testGet() throws Exception {
        JSONObject res = activityEntity.get("52e20cb5fff56aac62000b73");
        assertNotNull(res);
        assertNotNull(res.getString("id"));
        assertNotNull(res.getString("startTime"));
        assertNotNull(res.getInt("duration"));
        assertNotNull(res.getString("source"));
    }

    @Test
    public void testDaily() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        JSONArray res = activityEntity.daily(df.parse("2014-01-24"));
        assertNotNull(res);
        assertTrue(res.length() > 0);
        JSONObject obj = res.getJSONObject(0);
        assertNotNull(obj.getString("id"));
        assertNotNull(obj.getString("startTime"));
        assertNotNull(obj.getInt("duration"));
        assertNotNull(obj.getString("source"));
    }

    @Test
    public void testSummary() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        JSONObject res = activityEntity.summary(df.parse("2014-01-24"));
        assertNotNull(res);
        assertNotNull(res.getString("id"));
        assertNotNull(res.getString("date"));
        assertNotNull(res.getInt("duration"));
        assertNotNull(res.getString("source"));
    }
}
