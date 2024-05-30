package org.cases.common;

public enum ResponseCode {
  ADD_CASES_SUCCESS("Success", "Cases added successfully"),
  SEARCH_CASES_SUCCESS("Success", "Case detail found"),
  SEARCH_CASES_FAILURE("Fail", "Case detail not found"),
  UPDATE_CASES_SUCCESS("success", "Case detail updated"),
  UPDATE_CASES_FAILURE("Fail", "Case detail not updated");

  private final String status;
  private final String message;

  ResponseCode(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }
}
