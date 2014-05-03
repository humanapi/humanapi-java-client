package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;
import org.testng.annotations.Test;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONObject;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class GeneticTraitEntityTest {

    @Test
    public void testList() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        //client.setDebug(true);
        GeneticTraitEntity geneticTraitEntity = client.geneticTraitEntity();

        JSONArray res = geneticTraitEntity.list();
        assertNotNull(res);
        assertTrue(res.length() > 0);
        JSONObject obj = res.getJSONObject(0);
        assertNotNull(obj.getString("userId"));
        assertNotNull(obj.getString("trait"));
    }
}
