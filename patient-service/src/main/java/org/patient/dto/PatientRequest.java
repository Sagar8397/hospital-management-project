package org.patient.dto;

import jakarta.validation.constraints.Pattern;
import org.springframework.stereotype.Component;

@Component
public class PatientRequest {

  @Pattern(regexp = "[A-Za-z]{2,10}")
  private String patient_name;

  @Pattern(regexp = "[930][0-9]{9}")
  private String mobile_number;

  private String gender;
  private String age;

  private String address;

  public String getPatient_name() {
    return patient_name;
  }

  public void setPatient_name(String patient_name) {
    this.patient_name = patient_name;
  }

  public String getMobile_number() {
    return mobile_number;
  }

  public void setMobile_number(String mobile_number) {
    this.mobile_number = mobile_number;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
