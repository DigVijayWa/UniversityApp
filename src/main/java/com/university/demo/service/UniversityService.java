package com.university.demo.service;

import com.university.demo.dao.UniversityRepository;
import com.university.demo.dto.UniversityDTO;
import com.university.demo.model.bean.University;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversityService {

  @Autowired
  UniversityRepository universityRepository;


  public List<UniversityDTO> getAllUniversities() {
      return universityRepository.findAll().stream().map( item ->mapUniversity(item)).collect(
          Collectors.toList());
  }


  public UniversityDTO mapUniversity(University university) {
      UniversityDTO universityDTO = new UniversityDTO();

      universityDTO.setName(university.getUniversityName());

      return universityDTO;
  }
}
