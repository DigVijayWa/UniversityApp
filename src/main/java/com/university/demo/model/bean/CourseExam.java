package com.university.demo.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "course_exam")
public class CourseExam implements Serializable {

  private static final long serialVersionUID = 8557843374441515748L;


  @EmbeddedId
  CourseExamKey id;

  @ManyToOne
  @MapsId("course_id")
  @JoinColumn(name = "course_id")
  Course course;

  @ManyToOne
  @MapsId("exam_id")
  @JoinColumn(name = "exam_id")
  Exam exam;

  @Column(name = "cutoff")
  float cutoff;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public CourseExamKey getId() {
    return id;
  }

  public void setId(CourseExamKey id) {
    this.id = id;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Exam getExam() {
    return exam;
  }

  public void setExam(Exam exam) {
    this.exam = exam;
  }

  public float getCutoff() {
    return cutoff;
  }

  public void setCutoff(float cutoff) {
    this.cutoff = cutoff;
  }
}
