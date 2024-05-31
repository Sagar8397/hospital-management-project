package org.patient.controller;

import org.patient.dto.PatientRequest;
import org.patient.dto.PatientResponse;
import org.patient.service.PatientManagementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientManagementController {

  @Autowired PatientManagementServiceImpl patientManagementServiceImpl;

  @PostMapping(
      path = "/api/v1/patient/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public PatientResponse addPatient(@RequestBody PatientRequest request) {
    return patientManagementServiceImpl.addPatientDetails(request);
  }

  @GetMapping(path = "/api/v1/patient/search/{patient_id}")
  public PatientResponse searchPatientById(@PathVariable long patient_id) {
    return patientManagementServiceImpl.searchPatientById(patient_id);
  }

  @PostMapping(
      path = "/api/v1/patient/update/{patient_id}",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public PatientResponse updatePatient(
      @PathVariable long patient_id, @RequestBody PatientRequest request) {
    return patientManagementServiceImpl.updatePatientDetails(patient_id, request);
  }

  @DeleteMapping(path = "/api/v1/patient/delete/{patientId}")
  public String deletePatient(@PathVariable long patient_id) {
    return patientManagementServiceImpl.deletePatientDetails(patient_id);
  }
}
