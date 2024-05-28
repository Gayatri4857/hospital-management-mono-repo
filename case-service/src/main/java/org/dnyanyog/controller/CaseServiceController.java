package org.dnyanyog.controller;

import org.dnyanyog.dto.CaseRequest;
import org.dnyanyog.dto.CaseResponse;
import org.dnyanyog.service.CaseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseServiceController {

  @Autowired CaseServiceImp caseService;

  @PostMapping(
      path = "/api/v1/case/add",
      consumes = {"application/json", "application/xml"},
      produces = {"application/json", "application/xml"})
  public CaseResponse addCase(@RequestBody CaseRequest caseRequest) throws Exception {
    return caseService.addCase(caseRequest);
  }

  @PostMapping(path = "/api/v1/case/{patient_id}")
  public CaseResponse updateCase(
      @PathVariable String patient_id, @RequestBody CaseRequest request) {
    return caseService.updateCase(patient_id, request);
  }

  @GetMapping(path = "/api/v1/case/{patient_id}")
  public CaseResponse getSingleCase(@PathVariable String patient_id) {

    return caseService.getSingleCase(patient_id);
  }

  @DeleteMapping(path = "/api/v1/case/{patient_id}")
  public CaseResponse deleteCase(@PathVariable String patient_id) {
    return caseService.deleteCase(patient_id);
  }
}
