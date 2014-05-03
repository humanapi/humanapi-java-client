package co.humanapi.client;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HumanAPIClientTest {
    @Test
    public void testConstructorSuccess() throws Exception {
        HumanAPIClient client = new HumanAPIClient("test");
        assertNotNull(client);
    }

    @Test(expectedExceptions = HumanAPIException.class)
    public void testConstructorFail() throws Exception {
        HumanAPIClient client = new HumanAPIClient("");
    }

    @Test
    public void testConstructorSuccessEnv() throws Exception {
        HumanAPIClient client = new HumanAPIClient();
        assertNotNull(client);
    }
}
