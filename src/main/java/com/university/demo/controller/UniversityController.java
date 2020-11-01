package com.university.demo.controller;
import com.university.demo.dao.CourseRepository;
import com.university.demo.dao.ExamRepository;
import com.university.demo.dao.UniversityRepository;
import com.university.demo.dto.ListDTO;
import com.university.demo.model.bean.Course;
import com.university.demo.model.bean.Exam;
import com.university.demo.model.bean.University;
import com.university.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class UniversityController {
  @Autowired
  UniversityService universityService;
  @Autowired
  UniversityRepository universityRepository;

  @Autowired
  ExamRepository examRepository;

  @Autowired
  CourseRepository courseRepository;

  @RequestMapping(value="/universities")
  @ResponseBody
  public List<ListDTO> getUniversities(
      @RequestParam(value="country", required=false) String country,
      @RequestParam(value="courses", required = false) String courses,
      @RequestParam(value="fees_amount", required=false, defaultValue = "0") int feesAmount,
      @RequestParam(value="stream", required=false) String stream
  ) {
    return universityService.getCourseList(courses, stream, country, feesAmount);
  }

  @RequestMapping(value="/courses")
  @ResponseBody
  public List<ListDTO> getAllCourses(){
    return universityService.getAllCourses();
  }


  @PostMapping (value="/createUniversities")
  @ResponseBody
  public ResponseEntity<?> addUniversity(@RequestBody University university
  ) {
    universityRepository.save(university);
    return ResponseEntity.ok(HttpStatus.OK);
  }

  @PostMapping (value="/createCourse")
  @ResponseBody
  public ResponseEntity<?> addCourse(@RequestBody Course course
  ) {
    courseRepository.save(course);
    return ResponseEntity.ok(HttpStatus.OK);
  }

  @PostMapping (value="/createExam")
  @ResponseBody
  public ResponseEntity<?> addExam(@RequestBody Exam exam
  ) {
    examRepository.save(exam);
    return ResponseEntity.ok(HttpStatus.OK);
  }


  @PostMapping (value="/addUniversities")
  @ResponseBody
  public ResponseEntity<?> addUniversities(@RequestBody List<University> universities
  ) {
    universityRepository.saveAll(universities);
    return ResponseEntity.ok(HttpStatus.OK);
  }
}