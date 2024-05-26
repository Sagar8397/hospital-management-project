package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

@Component
public class UserRequest {

  private String first_name;
  private String last_name;
  private String middle_name;
  private String date_of_birth;
  private String address;
  private String mobile;
  private String home_phone;
  private String email_id;
  private long user_id;

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public void setLast_name(String last_name) {
    this.last_name = last_name;
  }

  public String getMiddle_name() {
    return middle_name;
  }

  public void setMiddle_name(String middle_name) {
    this.middle_name = middle_name;
  }

  public String getDate_of_birth() {
    return date_of_birth;
  }

  public void setDate_of_birth(String date_of_birth) {
    this.date_of_birth = date_of_birth;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getHome_phone() {
    return home_phone;
  }

  public void setHome_phone(String home_phone) {
    this.home_phone = home_phone;
  }

  public String getEmail_id() {
    return email_id;
  }

  public void setEmail_id(String email_id) {
    this.email_id = email_id;
  }

  public long getUser_id() {
    return user_id;
  }

  public void setUser_id(long user_id) {
    this.user_id = user_id;
  }
}
