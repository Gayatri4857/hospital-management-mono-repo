package org.dnyanyog.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.dnyanyog.DirectoryServiceMain;
import org.dnyanyog.common.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Order;
import org.springframework.test.web.servlet.RequestBuilder;
import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = DirectoryServiceMain.class)
public class DirectoryCOntrollerJsonAndXmlTestCase {

  @Autowired MockMvc mockMvc;

  @Test
  @Order(1)
  public void verifyDirectoryOperationForDirectorySuccess() throws Exception {

    RequestBuilder requestBuilder =
        MockMvcRequestBuilders.post("/api/v1/directory/add")
            .content(
                "{\r\n"
                    + "  \"confirm_password\": \"5678912\",\r\n"
                    + "  \"password\": \"5678912\",\r\n"
                    + "  \"email\": \"sdga123@gmail.com\",\r\n"
                    + "  \"userName\": \"hari\",\r\n"
                    + "  \"role\": \"user\",\r\n"
                    + "  \"mobileNumber\": \"1234567898\",\r\n"
                    + "}")
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .accept(MediaType.APPLICATION_JSON_VALUE);

    mockMvc
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.status").value(ResponseCode.USER_ADDED.getStatus()))
        .andExpect(
            MockMvcResultMatchers.jsonPath("$.message").value(ResponseCode.USER_ADDED.getMessage()))
        .andReturn();
  }
}
