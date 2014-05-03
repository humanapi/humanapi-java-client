package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;
import org.testng.annotations.Test;
import us.monoid.json.JSONObject;
import static org.testng.Assert.*;

public class HumanEntityTest {
    @Test
    public void testGet() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        //client.setDebug(true);
        HumanEntity humanEntity = client.humanEntity();

        JSONObject res = humanEntity.get();
        assertNotNull(res);
        assertEquals("52e20cb2fff56aac62000001", res.getString("userId"));
    }
}
