package org.patient.service;

import java.util.Optional;
import org.patient.common.ResponseCode;
import org.patient.dto.PatientRequest;
import org.patient.dto.PatientResponse;
import org.patient.entity.Patient;
import org.patient.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class PatientManagementServiceImpl implements PatientManagementService {
  @Autowired PatientRepository patientRepo;

  @Autowired PatientResponse patientRespone;

  @Autowired PatientRequest patientRequest;

  public PatientResponse addPatientDetails(PatientRequest patientRequest) {
    Patient patient =
        Patient.getInstance()
            .setPatient_name(patientRequest.getPatient_name())
            .setMobile_number(patientRequest.getMobile_number())
            .setGender(patientRequest.getGender())
            .setAge(patientRequest.getAge())
            .setAddress(patientRequest.getAddress());
    try {
      patient = patientRepo.save(patient);
    } catch (Exception e) {
      e.printStackTrace();
    }
    patientRespone.setPatient_id(patient.getPateint_id());
    patientRespone.setStatus(ResponseCode.ADD_PATIENT_SUCCESS.getStatus());
    patientRespone.setMessage(ResponseCode.ADD_PATIENT_SUCCESS.getMessage());
    return patientRespone;
  }

  public PatientResponse searchPatientById(long patient_id) {
    Optional<Patient> patient = patientRepo.findById(patient_id);
    if (patient == null) {
      patientRespone.setStatus(ResponseCode.SEARCH_PATIENT_FAILURE.getStatus());
      patientRespone.setMessage(ResponseCode.SEARCH_PATIENT_FAILURE.getMessage());
    } else {
      Patient patientDetails = patient.get();
      patientRespone.setPatient_name(patientDetails.getPatient_name());
      patientRespone.setMobile_number(patientDetails.getMobile_number());
      patientRespone.setGender(patientDetails.getGender());
      patientRespone.setAge(patientDetails.getAge());
      patientRespone.setAddress(patientDetails.getAddress());

      patientRespone.setStatus(ResponseCode.SEARCH_PATIENT_SUCCESS.getStatus());
      patientRespone.setMessage(ResponseCode.SEARCH_PATIENT_SUCCESS.getMessage());
    }
    return patientRespone;
  }

  public PatientResponse updatePatientDetails(long patient_id, PatientRequest patientRequest) {
    Optional<Patient> receivedPatient = patientRepo.findById(patient_id);
    if (receivedPatient == null) {
      patientRespone.setStatus(ResponseCode.UPDATE_PATIENT_FAILURE.getStatus());
      patientRespone.setMessage(ResponseCode.UPDATE_PATIENT_FAILURE.getMessage());
    } else {
      Patient patient =
          Patient.getInstance()
              .setPatient_name(patientRequest.getPatient_name())
              .setMobile_number(patientRequest.getMobile_number())
              .setGender(patientRequest.getGender())
              .setAge(patientRequest.getAge())
              .setAddress(patientRequest.getAddress());
      try {
        patient = patientRepo.save(patient);
      } catch (Exception e) {
        e.printStackTrace();
      }
      patient = patientRepo.save(patient);
      patientRespone.setStatus(ResponseCode.UPDATE_PATIENT_SUCCESS.getStatus());
      patientRespone.setMessage(ResponseCode.UPDATE_PATIENT_SUCCESS.getMessage());
    }

    return patientRespone;
  }

  public String deletePatientDetails(long patient_id) {
    patientRepo.deleteById(patient_id);
    return "Patient " + "of ID -" + patient_id + "  is deleted";
  }
}
