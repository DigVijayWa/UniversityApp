package com.university.demo.controller;

import com.university.demo.dto.UniversityDTO;
import com.university.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UniversityController {

  @Autowired
  UniversityService universityService;

  @RequestMapping(value="/universities")
  @ResponseBody
  public List<UniversityDTO> ValidateLoginCredentials(
      @RequestParam(value="country", required=false) String country,
      @RequestParam(value="courses", required = false) String courses,
      @RequestParam(value="fees_amount", required=false) int feesAmount,
      @RequestParam(value="stream", required=false) String stream
  ) {


    return universityService.getAllUniversities(country, courses, feesAmount, stream);
  }
}