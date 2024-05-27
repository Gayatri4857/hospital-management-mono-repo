package org.dnyanyog.services;

import org.dnyanyog.dto.PatientRequest;
import org.dnyanyog.dto.PatientResponse;

import jakarta.validation.Valid;

public interface PatientManagementService {
  public PatientResponse addPatient(@Valid PatientRequest request) throws Exception;

  public PatientResponse updatePatient(long patient_id, PatientRequest request);

  public PatientResponse getSinglePatient(long patient_id);

  public PatientResponse deletePatient(long patient_id);
}
