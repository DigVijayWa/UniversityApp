package com.university.demo.dao;
import com.university.demo.model.bean.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
  public List<Course> findByCourseName(String course);
  public List<Course> findByStream( String stream);
  public List<Course> findByCourseFeesLessThan(int feesAmount);
  public List<Course> findByCourseNameAndStreamAndCourseFeesLessThan(String course, String stream, int feesAmount);
}