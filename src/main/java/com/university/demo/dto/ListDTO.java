package com.university.demo.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ListDTO {

  private String universityName;
  private String courseName;
  private String universityLogo;
  private int fees;
  private HashMap<String,Float> exams;
  private String universityLink;

  public String getUniversityLogo() {
    return universityLogo;
  }

  public void setUniversityLogo(String universityLogo) {
    this.universityLogo = universityLogo;
  }

  public int getFees() {
    return fees;
  }

  public void setFees(int fees) {
    this.fees = fees;
  }

  public HashMap<String, Float> getExams() {
    return exams;
  }

  public void setExams(HashMap<String, Float> exams) {
    this.exams = exams;
  }

  public String getUniversityLink() {
    return universityLink;
  }

  public void setUniversityLink(String universityLink) {
    this.universityLink = universityLink;
  }

  public String getUniversityName() {
    return universityName;
  }

  public void setUniversityName(String universityName) {
    this.universityName = universityName;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
}
