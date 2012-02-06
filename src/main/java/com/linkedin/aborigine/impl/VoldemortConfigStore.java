package com.linkedin.aborigine.impl;

import com.google.common.base.Function;
import com.linkedin.aborigine.api.DynamicConfigStore;
import voldemort.client.StoreClient;
import voldemort.utils.Pair;

public class VoldemortConfigStore<ExperimentKeyType, ExperimentIdType> implements DynamicConfigStore<ExperimentKeyType, ExperimentIdType> {
    private final StoreClient<Pair<ExperimentKeyType, ExperimentIdType>, String> storeClient;

    public VoldemortConfigStore(StoreClient<Pair<ExperimentKeyType, ExperimentIdType>, String> storeClient) {
        this.storeClient = storeClient;
    }

    @Override
    public String getConfig(ExperimentKeyType experimentKey, ExperimentIdType experimentId) {
        return storeClient.getValue(Pair.create(experimentKey, experimentId));
    }
}
