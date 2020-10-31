package com.university.demo.dto;

public class UniversityDTO {

    private String name;
    private String universityLogo;
    private String fees;
    private String exams;
    private String universityLink;

  public String getUniversityLogo() {
    return universityLogo;
  }

  public void setUniversityLogo(String universityLogo) {
    this.universityLogo = universityLogo;
  }

  public String getFees() {
    return fees;
  }

  public void setFees(String fees) {
    this.fees = fees;
  }

  public String getExams() {
    return exams;
  }

  public void setExams(String exams) {
    this.exams = exams;
  }

  public String getUniversityLink() {
    return universityLink;
  }

  public void setUniversityLink(String universityLink) {
    this.universityLink = universityLink;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
