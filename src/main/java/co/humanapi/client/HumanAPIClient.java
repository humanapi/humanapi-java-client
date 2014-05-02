package co.humanapi.client;

import us.monoid.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/**
 * HumanAPI client class
 */
public class HumanAPIClient {

    /** URL for accessing the API */
    private static final String apiRoot = "https://api.humanapi.co/v1/human";

    /** Logger instance */
    private final static Logger logger = Logger.getLogger(HumanAPIClient.class.getName());

    /** Access token for current session */
    private String accessToken;

    /** Debug flag */
    private Boolean debug = false;

    /**
     * Constructor without params, access token will be taken
     * from HUMANAPI_ACCESS_TOKEN environment variable
     */
    public HumanAPIClient() {

    }

    /**
     * Constructor, requires access token
     *
     * @param accessToken access token to be used in the session
     */
    public HumanAPIClient(String accessToken) {

    }

    /**
     * Set the debug flag
     *
     * @param debug new flag value
     */
    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    /**
     * Execute API GET request and return JSON result
     *
     * @param path path to API resource
     * @return result returned from server
     * @throws HumanAPIException
     */
    public JSONObject execute(String path) throws HumanAPIException {
        Map<String, Object> emptyParams = new HashMap<String, Object>();
        return this.execute(path, emptyParams);
    }

    /**
     * Execute API GET request and return JSON result
     *
     * @param path path to API resource
     * @param parameters extra parameters
     * @return result returned from server
     * @throws HumanAPIException
     */
    public JSONObject execute(String path, Map<String, Object> parameters) throws HumanAPIException {
        return null;
    }
}
