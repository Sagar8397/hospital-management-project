package org.cases.service;

import java.util.List;
import org.cases.common.ResponseCode;
import org.cases.dto.CaseRequest;
import org.cases.dto.CaseResponse;
import org.cases.entity.Cases;
import org.cases.repo.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class CaseManagementServiceImpl implements CaseManagementService {

  @Autowired CaseRepository caseRepo;

  @Autowired CaseResponse caseResponse;

  @Autowired CaseRequest caseRequest;

  public CaseResponse addCases(CaseRequest caseRequest) {
    Cases cases =
        Cases.getInstanace()
            .setPatient_name(caseRequest.getPatient_name())
            .setCase_number(caseRequest.getCase_number())
            .setSymptoms(caseRequest.getSymptoms())
            .setPrescription(caseRequest.getPrescription());
    try {
      caseRepo.save(cases);
    } catch (Exception e) {
      e.printStackTrace();
    }
    caseResponse.setStatus(ResponseCode.ADD_CASES_SUCCESS.getStatus());
    caseResponse.setMessage(ResponseCode.ADD_CASES_SUCCESS.getMessage());

    return caseResponse;
  }

  public CaseResponse searchCases(long patient_id) {
    List<Cases> receivedCases = caseRepo.findByPatient_id(patient_id);
    if (receivedCases.isEmpty()) {
      caseResponse.setStatus(ResponseCode.SEARCH_CASES_FAILURE.getStatus());
      caseResponse.setMessage(ResponseCode.SEARCH_CASES_FAILURE.getMessage());
    } else {
      Cases cases = receivedCases.get(0);
      caseResponse.setPatient_name(cases.getPatient_name());
      caseResponse.setCase_number(cases.getCase_number());
      caseResponse.setSymptoms(cases.getSymptoms());
      caseResponse.setPrescription(cases.getPrescription());

      caseResponse.setStatus(ResponseCode.SEARCH_CASES_SUCCESS.getStatus());
      caseResponse.setMessage(ResponseCode.SEARCH_CASES_SUCCESS.getMessage());
    }
    return caseResponse;
  }

  public String deleteCases(long patient_id) {
    caseRepo.deleteById(patient_id);
    return "Case for patientId " + patient_id + "  is deleted";
  }
}
