package org.patient.service;

import org.patient.dto.PatientRequest;
import org.patient.dto.PatientResponse;

public interface PatientManagementService {
  public PatientResponse addPatientDetails(PatientRequest patientRequest);

  public PatientResponse searchPatientById(long patientId);

  public PatientResponse updatePatientDetails(long patientId, PatientRequest patientRequest);

  public String deletePatientDetails(long patientId);
}
