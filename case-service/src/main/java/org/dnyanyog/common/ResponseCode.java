package org.dnyanyog.common;

public enum ResponseCode {
  CASE_ADDED("Success", "Case added successfully!"),
  CASE_FAILED("Fail", "Failed to add case!"),
  CASE_NOT_UPDATED("Fail", "Case not found or invalid request!"),
  CASE_UPDATED("Success", "Case updated successfully!"),
  SEARCH_CASE("Success", "Case found successfully!"),
  SEARCH_CASE_FAILED("Fail", "Case not found or invalid request!"),
  NOT_DELETE_CASE("Fail", "Case not deleted !"),
  DELETE_CASE("Success", "Case deleted successfully !"),
  APPOINTMENT_ADDED("Success", "Appointment added successfully!"),
  APPOINTMENT_FAILED("Fail", "Failed to add Appointment!"),
  APPOINTMENT_NOT_UPDATED("Fail", "Appointment not found or invalid request!"),
  APPOINTMENT_UPDATED("Success", "Appointment updated successfully!"),
  SEARCH_APPOINTMENT("Success", "Appointment found successfully!"),
  SEARCH_APPOINTMENT_FAILED("Fail", "Appointment not found or invalid request!"),
  NOT_DELETE_APPOINTMENT("Fail", "Appointment not deleted !"),
  DELETE_APPOINTMENT("Success", "Appointment deleted successfully !");

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
