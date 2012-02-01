package com.linkedin.aborigine.api;

public interface ABTest<ExperimentKeyType, ExperimentIdType> {
  String getTreatment(ExperimentKeyType key, ExperimentIdType id);
}
