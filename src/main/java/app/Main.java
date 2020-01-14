package app;

import model.Course;
import model.PurchaseList;
import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import utils.PurchaseListId;

public class Main
{
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();

        Student students = session.get(Student.class, 1);

        Course course = session.get(Course.class, 10);

        PurchaseList purchaseList = session.get(PurchaseList.class, new PurchaseListId(students.getName(), course.getName()));


        System.out.println(students.getId() + ": " + students.getName());

        System.out.println("Teacher: " + course.getTeacher().getName());

        System.out.println("Id: (" + purchaseList.getCourse().getId() + ") " + purchaseList.getCourse().getName()
                        + " - " +
                        "Id: (" + purchaseList.getStudent().getId() + ") " + purchaseList.getStudent().getName());

        sessionFactory.close();
    }
}
