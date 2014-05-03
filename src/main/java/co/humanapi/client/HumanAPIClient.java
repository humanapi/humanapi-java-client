package co.humanapi.client;

import co.humanapi.client.entity.HumanEntity;
import co.humanapi.client.entity.ProfileEntity;
import gumi.builders.UrlBuilder;
import us.monoid.json.JSONException;
import us.monoid.json.JSONObject;
import us.monoid.web.Content;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;
import us.monoid.web.TextResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * HumanAPI client class
 */
public class HumanAPIClient {

    /** URL for accessing the API */
    private static final String apiRoot = "https://api.humanapi.co/v1/human";

    /** Logger instance */
    private static Logger logger = Logger.getLogger(HumanAPIClient.class.getName());

    /** Access token for current session */
    private String accessToken;

    /** Debug flag */
    private Boolean debug = false;

    /**
     * Constructor without params, access token will be taken
     * from HUMANAPI_ACCESS_TOKEN environment variable
     */
    public HumanAPIClient() {
        // TODO
    }

    /**
     * Constructor, requires access token
     *
     * @param accessToken access token to be used in the session
     */
    public HumanAPIClient(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Set the debug flag.
     * If true, then all request and response details will be
     * sent to the logger instance.
     *
     * @param debug new flag value
     */
    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    /**
     * Writes out debug message to logger
     * @param message debug message
     */
    private void debug(String message) {
        if (debug) {
            logger.info(message);
        }
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
        String url = apiRoot + path;
        logger.info(String.format("GET %s %s", url, parameters.toString()));
        try {
            // build url
            UrlBuilder builder = UrlBuilder.fromString(url);
            for (String name : parameters.keySet()) {
                builder = builder.addParameter(name, parameters.get(name).toString());
            }
            builder = builder.setParameter("access_token", this.accessToken);
            debug("complete URL = " + builder.toString());

            // send req
            Resty resty = new Resty();
            TextResource res = resty.text(builder.toString());
            debug("result = " + res.toString());

            // check res
            if (!res.status(200)) {
                logger.severe(String.format("Error response: [%d] %s", res.http().getResponseCode(), res.toString()));
                throw new HumanAPIException(String.format("Error response: [%d]", res.http().getResponseCode()));
            }
            logger.info("done, response [200]");
            return new JSONObject(res.toString());
        } catch (IOException e) {
            throw new HumanAPIException(e);
        } catch (JSONException e) {
            throw new HumanAPIException(e);
        }
    }

    /** Builds HumanEntity */
    public HumanEntity humanEntity() {
        return new HumanEntity(this);
    }

    /** Builds ProfileEntity */
    public ProfileEntity profileEntity() {
        return new ProfileEntity(this);
    }
}
