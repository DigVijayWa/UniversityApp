package com.university.demo.model.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="university")
public class University implements Serializable {


  private static final long serialVersionUID = -3636582666360007177L;

  @Column(name = "university_id")
  @Id
  private Long id;

  @Column(name = "university_name")
  private String universityName;

  @Column(name = "country")
  private String floorNo;

  @Column(name = "exams")
  private String exams;

  @Column(name = "marks_required")
  private int marksRequired;

  @Column(name = "course_fees")
  private int courseFees;

  public University() {
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUniversityName() {
    return universityName;
  }

  public void setUniversityName(String universityName) {
    this.universityName = universityName;
  }

  public String getFloorNo() {
    return floorNo;
  }

  public void setFloorNo(String floorNo) {
    this.floorNo = floorNo;
  }

  public String getExams() {
    return exams;
  }

  public void setExams(String exams) {
    this.exams = exams;
  }

  public int getMarksRequired() {
    return marksRequired;
  }

  public void setMarksRequired(int marksRequired) {
    this.marksRequired = marksRequired;
  }

  public int getCourseFees() {
    return courseFees;
  }

  public void setCourseFees(int courseFees) {
    this.courseFees = courseFees;
  }
}

