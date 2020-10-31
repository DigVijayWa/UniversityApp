package com.university.demo.model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
  private static final long serialVersionUID = -3636582666360007177L;

  @Column(name = "course_id")
  @Id
  @GeneratedValue
  private Long id;

  @Column(name = "course_name")
  private String courseName;

  @Column(name = "field")
  private String field;

  @Column(name = "subject_combination")
  private String subjectCombination;

  @Column(name = "marks_required")
  private int marksRequired;

  @Column(name = "course_fees")
  private int courseFees;

  @Column(name = "stream")
  private String stream;

  @ManyToOne
  @JoinColumn(name = "university_id")
  University university;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getSubjectCombination() {
    return subjectCombination;
  }

  public void setSubjectCombination(String subjectCombination) {
    this.subjectCombination = subjectCombination;
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

  public University getUniversity() {
    return university;
  }

  public void setUniversity(University university) {
    this.university = university;
  }
  public String getStream() {
    return stream;
  }

  public void setStream(String stream) {
    this.stream = stream;
  }
}
