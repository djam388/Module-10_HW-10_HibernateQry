package utils;

import model.Course;
import model.Student;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PurchaseListId implements Serializable {


    private String student_name;
    private String course_name;

    public PurchaseListId(String student_name, String course_name) {
        this.student_name = student_name;
        this.course_name = course_name;
    }

    public PurchaseListId() {
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseListId that = (PurchaseListId) o;
        return Objects.equals(student_name, that.student_name) &&
                Objects.equals(course_name, that.course_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_name, course_name);
    }

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="student_name", referencedColumnName = "name")
//    private Student studentName;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="course_name", referencedColumnName = "name")
//    private Course courseName;
//
//    public PurchaseListId() {
//    }
//
//    public PurchaseListId(Student studentName, Course courseName) {
//        this.studentName = studentName;
//        this.courseName = courseName;
//    }
//
//    public Student getStudentName() {
//        return studentName;
//    }
//
//    public void setStudentName(Student studentName) {
//        this.studentName = studentName;
//    }
//
//    public Course getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(Course courseName) {
//        this.courseName = courseName;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PurchaseListId that = (PurchaseListId) o;
//        return Objects.equals(studentName, that.studentName) &&
//                Objects.equals(courseName, that.courseName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(studentName, courseName);
//    }
}
