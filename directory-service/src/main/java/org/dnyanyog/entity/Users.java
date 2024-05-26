package org.dnyanyog.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {

  @GeneratedValue(generator = "user_seq") // Auto generated (DB => sequence), primary key
  @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
  @Id
  @Column(nullable = false, insertable = false, updatable = false)
  private long user_code;

  @Column private String first_name;

  @Column private String last_name;

  @Column private String middle_name;

  @Column private String date_of_birth;

  @Column private String address;

  @Column(updatable = true, nullable = false)
  private long user_id;

  @Column private String mobile;

  @Column private String home_phone;

  @Column(unique = true)
  private String email_id;

  public long getUser_code() {
    return user_code;
  }

  public Users setUser_code(long user_code) {
    this.user_code = user_code;
    return this;
  }

  public static Users getInstance() {
    return new Users();
  }

  public String getFirst_name() {
    return first_name;
  }

  public Users setFirst_name(String first_name) {
    this.first_name = first_name;
    return this;
  }

  public String getLast_name() {
    return last_name;
  }

  public Users setLast_name(String last_name) {
    this.last_name = last_name;
    return this;
  }

  public String getMiddle_name() {
    return middle_name;
  }

  public Users setMiddle_name(String middle_name) {
    this.middle_name = middle_name;
    return this;
  }

  public String getDate_of_birth() {
    return date_of_birth;
  }

  public Users setDate_of_birth(String date_of_birth) {
    this.date_of_birth = date_of_birth;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public Users setAddress(String address) {
    this.address = address;
    return this;
  }

  public long getUser_id() {
    return user_id;
  }

  public Users setUser_id(long user_id) {
    this.user_id = user_id;
    return this;
  }

  public String getMobile() {
    return mobile;
  }

  public Users setMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public Users setHome_phone(String home_phone) {
    this.home_phone = home_phone;
    return this;
  }

  public String getEmail_id() {
    return email_id;
  }

  public Users setEmail_id(String email_id) {
    this.email_id = email_id;
    return this;
  }
}
