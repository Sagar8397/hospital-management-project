package org.cases.entity;

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
public class Cases {
  @Id @GeneratedValue @Column private long patient_id;

  @Column private String patient_name;

  @Column private String case_number;

  @Column private String symptoms;

  @Column private String prescription;

  public static Cases getInstanace() {
    return new Cases();
  }

  public long getPatient_id() {
    return patient_id;
  }

  public Cases setPatient_id(long patient_id) {
    this.patient_id = patient_id;
    return this;
  }

  public String getPatient_name() {
    return patient_name;
  }

  public Cases setPatient_name(String patient_name) {
    this.patient_name = patient_name;
    return this;
  }

  public String getCase_number() {
    return case_number;
  }

  public Cases setCase_number(String case_number) {
    this.case_number = case_number;
    return this;
  }

  public String getSymptoms() {
    return symptoms;
  }

  public Cases setSymptoms(String symptoms) {
    this.symptoms = symptoms;
    return this;
  }

  public String getPrescription() {
    return prescription;
  }

  public Cases setPrescription(String prescription) {
    this.prescription = prescription;
    return this;
  }
}
