package com.university.demo.model.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseExamKey implements Serializable{

    private static final long serialVersionUID = -4570797692426852060L;

    @Column(name="course_id")
    Long courseId;

    @Column(name="exam_id")
    Long examId;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public Long getExamId() {
    return examId;
  }

  public void setExamId(Long examId) {
    this.examId = examId;
  }
}
