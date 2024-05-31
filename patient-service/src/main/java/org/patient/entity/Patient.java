package org.patient.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Table
@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient {

  @Id
  @GeneratedValue
  @Column(nullable = false, insertable = false, updatable = false)
  private Long pateint_id;

  @Column(nullable = false)
  private String patient_name;

  @Column(nullable = false)
  private String mobile_number;

  @Column(nullable = false)
  private String gender;

  @Column(nullable = false)
  private String age;

  @Column(nullable = false)
  private String address;

  public static Patient getInstance() {
    return new Patient();
  }

  public Long getPateint_id() {
    return pateint_id;
  }

  public Patient setPateint_id(Long pateint_id) {
    this.pateint_id = pateint_id;
    return this;
  }

  public String getPatient_name() {
    return patient_name;
  }

  public Patient setPatient_name(String patient_name) {
    this.patient_name = patient_name;
    return this;
  }

  public String getMobile_number() {
    return mobile_number;
  }

  public Patient setMobile_number(String mobile_number) {
    this.mobile_number = mobile_number;
    return this;
  }

  public String getGender() {
    return gender;
  }

  public Patient setGender(String gender) {
    this.gender = gender;
    return this;
  }

  public String getAge() {
    return age;
  }

  public Patient setAge(String age) {
    this.age = age;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Patient setAddress(String address) {
    this.address = address;
    return this;
  }
}
