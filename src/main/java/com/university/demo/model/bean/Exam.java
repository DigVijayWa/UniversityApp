package com.university.demo.model.bean;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="exam")
public class Exam {
  private static final long serialVersionUID = -3636582666360007177L;

  @Column(name = "exam_id")
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "exam_name")
  private String examName;

  @OneToMany(mappedBy = "exam")
  Set<CourseExam> courseExams;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getExamName() {
    return examName;
  }

  public void setExamName(String examName) {
    this.examName = examName;
  }

  public Set<CourseExam> getCourseExams() {
    return courseExams;
  }

  public void setCourseExams(Set<CourseExam> courseExams) {
    this.courseExams = courseExams;
  }
}
