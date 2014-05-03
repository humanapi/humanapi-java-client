package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;
import org.testng.annotations.Test;
import us.monoid.json.JSONObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ProfileEntityTest {
    @Test
    public void testGet() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        ProfileEntity profileEntity = client.profileEntity();

        JSONObject res = profileEntity.get();
        assertNotNull(res);
        assertEquals("52e20cb2fff56aac62000001", res.getString("userId"));
        assertEquals("demo@humanapi.co", res.getString("email"));
    }
}
