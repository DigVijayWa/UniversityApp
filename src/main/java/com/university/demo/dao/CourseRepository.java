package com.university.demo.dao;

import com.university.demo.model.bean.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
  public List<Course> findByCourseAndStreamAndCountryAndFeesAmountLessThan(String course, String stream, String country, int feesAmount);
}
