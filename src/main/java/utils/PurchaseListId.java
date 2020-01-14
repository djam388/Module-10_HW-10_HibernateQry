package utils;

import javax.persistence.Embeddable;
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
}
