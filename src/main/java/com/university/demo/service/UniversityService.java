package com.university.demo.service;

import com.university.demo.dao.UniversityRepository;
import com.university.demo.dto.UniversityDTO;
import com.university.demo.model.bean.Course;
import com.university.demo.model.bean.University;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

  @Autowired
  UniversityRepository universityRepository;


  public List<UniversityDTO> getAllUniversities(String country, String course, int feesAmount, String stream) {
      return
  }

  public  filterUniversities(Course course, String course, int feesAmount, String stream) {
      if( university.getCourse())
  }
}
