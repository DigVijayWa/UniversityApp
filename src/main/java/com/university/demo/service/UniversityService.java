package com.university.demo.service;
import com.university.demo.dao.CourseRepository;
import com.university.demo.dao.UniversityRepository;
import com.university.demo.dto.ListDTO;
import com.university.demo.model.bean.Course;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UniversityService {
  @Autowired
  UniversityRepository universityRepository;
  @Autowired
  CourseRepository courseRepository;

  public ListDTO mapCourse(Course course){
    ListDTO listDTO = new ListDTO();
    HashMap<String, Float> hashMap = new HashMap<>();
    course.getCourseExams().stream().forEach(item-> {
        hashMap.put(item.getExam().getExamName(), item.getCutoff());
    });
    listDTO.setExams(hashMap);
    listDTO.setFees(course.getCourseFees());
    listDTO.setCourseName(course.getCourseName());
    listDTO.setUniversityName(course.getUniversity().getUniversityName());
    listDTO.setUniversityLink(course.getUniversity().getUniversityLink());
    listDTO.setUniversityLogo(course.getUniversity().getUniversityLogo());
    return listDTO;
  }
  public List<Course> filterAllFields(List<Course> courses, String course, String stream, int feesAmount) {
      return courses.stream().filter(item->{
        if(course != null) {
          return item.getCourseName().compareTo(course) == 0;
        }
        return true;
      }).filter(item->{
        if(stream != null) {
          return item.getCourseName().compareTo(stream) == 0;
        }
        return true;
      }).filter(item -> {
        if(feesAmount != 0) {
          return item.getCourseFees() < (feesAmount);
        }
        return true;
      }).collect(Collectors.toList());
  }

  public List<ListDTO> getCourseList(String course, String stream, String country, int feesAmount){
    List<Course> courseList= courseRepository.findAll();
    System.out.println(courseList);
    List<Course> list = filterAllFields(courseList,course, stream, feesAmount).stream().filter(item -> { return isCourseInCountry(country,item);}).collect(Collectors.toList());
    return list.stream().map(item-> mapCourse(item)).collect(Collectors.toList());
  }
  public boolean isCourseInCountry(String country, Course course){
    return course.getUniversity().getCountry().compareTo(country)==0;
  }

  public List<ListDTO> getAllCourses() {
    return courseRepository.findAll().stream().map(item->mapCourse(item)).collect(Collectors.toList());
  }
}