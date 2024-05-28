package org.dnyanyog.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class UserData {

  @NotBlank(message = "User name is mandatory")
  @Size(min = 3, max = 50, message = "User name must be between 3 and 50 characters")
  private String user_name;

  @NotBlank(message = "Email is mandatory")
  @Email(message = "Email should be valid")
  private String email;

  @NotBlank(message = "Mobile number is mandatory")
  @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number should be 10 digits")
  private String mobile_number;

  @NotBlank(message = "Role is mandatory")
  private String role;

  @NotBlank(message = "Password is mandatory")
  @Size(min = 6, message = "Password must be at least 6 characters long")
  private String password;

  @NotBlank(message = "Confirm password is mandatory")
  @Size(min = 6, message = "Confirm password must be at least 6 characters long")
  private String confirm_password;

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobile_number() {
    return mobile_number;
  }

  public void setMobile_number(String mobile_number) {
    this.mobile_number = mobile_number;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirm_password() {
    return confirm_password;
  }

  public void setConfirm_password(String confirm_password) {
    this.confirm_password = confirm_password;
  }
}