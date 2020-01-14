package model;

import utils.PurchaseListId;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "purchaselist")
public class PurchaseList
{

    @EmbeddedId
    private PurchaseListId id;

    @ManyToOne
    @JoinColumn(name = "student_name", referencedColumnName = "name", insertable = false, updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_name", referencedColumnName = "name", insertable = false, updatable = false)
    private Course course;

    private int price;
    private Date subscription_date;

    public PurchaseListId getId() {
        return id;
    }

    public void setId(PurchaseListId id) {
        this.id = id;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscription_date() {
        return subscription_date;
    }

    public void setSubscription_date(Date subscription_date) {
        this.subscription_date = subscription_date;
    }
}
