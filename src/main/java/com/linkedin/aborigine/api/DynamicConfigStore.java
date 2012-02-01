package com.linkedin.aborigine.api;

public interface DynamicConfigStore<ExperimentKeyType, ExperimentIdType> {
  String getConfig(ExperimentKeyType experimentKey, ExperimentIdType experimentId);
}
