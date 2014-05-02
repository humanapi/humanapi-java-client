package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;

/**
 * Basic entity class.
 */
public class AbstractEntity {

    protected HumanAPIClient client;

    public AbstractEntity(HumanAPIClient client) {
        this.client = client;
    }
}
