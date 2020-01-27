package utils;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LinkedPurchasedListId implements Serializable {

    @Column(insertable = false, updatable = false)
    private int courseId;
    @Column(insertable = false, updatable = false)
    private int studentId;

    public LinkedPurchasedListId() {
    }

    public LinkedPurchasedListId(int courseId, int studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinkedPurchasedListId that = (LinkedPurchasedListId) o;
        return courseId == that.courseId &&
                studentId == that.studentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }
}
