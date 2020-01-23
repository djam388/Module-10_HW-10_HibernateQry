package app;

import model.Course;
import model.LinkedPurchaseList;
import model.PurchaseList;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import utils.PurchaseListId;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main
{
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

//        Student students = session.get(Student.class, 1);
//
        Course course = session.get(Course.class, 10);
//
//        PurchaseList purchaseList = session.get(PurchaseList.class, new PurchaseListId(students.getName(), course.getName()));
//
//
//        System.out.println(students.getId() + ": " + students.getName());
//
        System.out.println("Teacher: " + course.getTeacher().getName() + " Students quantity: " + course.getStudents().size());
//
//        System.out.println("Id: (" + purchaseList.getCourse().getId() + ") " + purchaseList.getCourse().getName()
//                        + " - " +
//                        "Id: (" + purchaseList.getStudent().getId() + ") " + purchaseList.getStudent().getName());

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> query = builder.createQuery(PurchaseList.class);
        Root<PurchaseList> root = query.from(PurchaseList.class);
        query.select(root);
        Query<PurchaseList> q = session.createQuery(query);
        List<PurchaseList> list = q.getResultList();

        for (PurchaseList purchased : list)
        {
            LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();


            System.out.println("Course Id: " + purchased.getCourse().getId() + " Course name: " + purchased.getCourse().getName()
                                + " --> Student Id: " + purchased.getStudent().getId() + " Student name: " + purchased.getStudent().getName());

            linkedPurchaseList.setCourseId(purchased.getCourse().getId());
            linkedPurchaseList.setCourseName(purchased.getCourse().getName());
            linkedPurchaseList.setCoursePrice(purchased.getCourse().getPrice());
            linkedPurchaseList.setTeacherName(purchased.getCourse().getTeacher().getName());
            linkedPurchaseList.setStudentId(purchased.getStudent().getId());
            linkedPurchaseList.setStudentName(purchased.getStudent().getName());
            //session.beginTransaction();
            session.save(linkedPurchaseList);
            session.beginTransaction().commit();
        }

        sessionFactory.close();
    }
}
