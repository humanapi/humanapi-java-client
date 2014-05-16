package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONObject;

import java.util.Random;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class AppUserEntityTest {

    private AppUserEntity appUserEntity;

    @BeforeTest
    public void setUp() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        client.setDebug(true);
        appUserEntity = client.appUserEntity(
                "9bac0e053f486619c0795015c99477b49b229961", // appId
                "763af2426481c1e11e75e141d87703372b9f69f8"  // appQueryKey
        );
    }

    @Test
    public void testList() throws Exception {
        JSONArray res = appUserEntity.list();
        assertNotNull(res);
        assertTrue(res.length() > 0);
        JSONObject obj = res.getJSONObject(0);
        assertNotNull(obj.getString("humanId"));
        assertNotNull(obj.getString("externalId"));
    }

    @Test
    public void testGet() throws Exception {
        JSONObject res = appUserEntity.get("770edfcf4ea0c134af0dfd4486ded876");
        assertNotNull(res);
        assertNotNull(res.getString("humanId"));
        assertNotNull(res.getString("externalId"));
    }

    @Test
    public void testCreate() throws Exception {
        Random generator = new Random();
        String s = Integer.toString(generator.nextInt(1000) + 1000);

        JSONObject res = appUserEntity.create("test_user_" + s);
        assertNotNull(res);
        assertNotNull(res.getString("humanId"));
        assertNotNull(res.getString("externalId"));
    }
}
