package org.cases.service;

import org.cases.dto.CaseRequest;
import org.cases.dto.CaseResponse;

public interface CaseManagementService {

  public CaseResponse addCases(CaseRequest caseRequest);

  public CaseResponse searchCases(long patient_id);

  public String deleteCases(long patient_id);
}
