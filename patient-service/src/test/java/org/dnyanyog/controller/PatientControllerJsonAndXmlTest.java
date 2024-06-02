package org.dnyanyog.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.dnyanyog.PatientApplicationMain;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = PatientApplicationMain.class)
public class PatientControllerJsonAndXmlTest {
  @Autowired MockMvc mockMvc;

  @Test
  @Order(1)
  public void verifyDirectoryOperationForPatientSuccess() throws Exception {

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/patient/add")
            .content(
                "{\r\n"
                    + "  \"patientNameEnglish\": \"ramesh\",\r\n"
                    + "  \"patient_name_marathi\": \"फ\",\r\n"
                    + "  \"birth_date\": \"2-04-2006\",\r\n"
                    + "  \"gender\": \"female\",\r\n"
                    + "  \"mobile\": \"9876543241\",\r\n"
                    + "  \"first_examination_date\": \"7-05-2024\"\r\n"
                    + "  \"address\": \"pune\",\r\n"
                    + "}")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Success"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Patient added successfully!"))
        .andReturn();
  }
}
