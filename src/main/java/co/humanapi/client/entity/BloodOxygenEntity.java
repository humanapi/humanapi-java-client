package co.humanapi.client.entity;

import co.humanapi.client.HumanAPIClient;

/**
 * Blood oxygen entity.
 */
public class BloodOxygenEntity extends AbstractMeasurementEntity {

    public BloodOxygenEntity(HumanAPIClient client) {
        super(client, "/blood_oxygen");
    }
}
