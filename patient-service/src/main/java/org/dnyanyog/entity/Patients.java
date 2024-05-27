package org.dnyanyog.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patients {

  @GeneratedValue
  @Id
  @Column(name = "PatientId", nullable = false, insertable = true, updatable = false)
  private long patient_id;

  @Column(nullable = false, insertable = true, updatable = false, length = 50)
  private String patient_name_english;

  @Column(nullable = false, insertable = true, updatable = false, length = 50)
  private String patient_name_marathi;

  @Column private String mobile;

  @Column private String gender;

  @Column private String birth_date;

  @Column private String first_examination_date;

  @Column private String address;

  public String getPatient_name_english() {
    return patient_name_english;
  }

  public void setPatient_name_english(String patient_name_english) {
    this.patient_name_english = patient_name_english;
  }

  public String getPatient_name_marathi() {
    return patient_name_marathi;
  }

  public void setPatient_name_marathi(String patient_name_marathi) {
    this.patient_name_marathi = patient_name_marathi;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getBirth_date() {
    return birth_date;
  }

  public void setBirth_date(String birth_date) {
    this.birth_date = birth_date;
  }

  public String getFirst_examination_date() {
    return first_examination_date;
  }

  public void setFirst_examination_date(String first_examination_date) {
    this.first_examination_date = first_examination_date;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
