package model;

import utils.PurchaseListId;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "linkedpurchaselist")

public class LinkedPurchaseList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_price")
    private int coursePrice;

    @Column(name = "teacher_name")
    private String teacherName;

    public LinkedPurchaseList() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
