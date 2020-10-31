package com.university.demo.model.bean;

import java.util.Set;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="university")
public class University implements Serializable {


  private static final long serialVersionUID = -3636582666360007177L;

  @Column(name = "university_id")
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "university_name")
  private String universityName;

  @Column(name = "country")
  private String country;

  @Column(name = "exams")
  private String exams;

  @Column(name = "marks_required")
  private int marksRequired;

  @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<Course> course;

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

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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

  public Set<Course> getCourse() {
    return course;
  }

  public void setCourse(Set<Course> course) {
    this.course = course;
  }
}

