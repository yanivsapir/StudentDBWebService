package il.ac.shenkar.sqlCourse.tryA;

import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Student;
import il.ac.shenkar.sqlCourse.entities.Teacher;
import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;
import il.ac.shenkar.sqlCourse.entities.connectors.TeacherCourse;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.List;

public class DBTransaction {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            configuration
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Teacher.class)
                    .addAnnotatedClass(StudentCourse.class)
                    .addAnnotatedClass(TeacherCourse.class);

            ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
            registry.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
            factory = configuration.buildSessionFactory(serviceRegistry);
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        DBTransaction ME = new DBTransaction();
        ME.listEmployees();
    }
    /* Method to  READ all the employees */
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //Student student = new Student();
            //Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());;


//            Criteria c = session.createCriteria(Student.class,"stud");
//            c.createCriteria("grades", "g");//Teacher class should contain students collection
//            c.add(Restrictions.gt("g.grade", 20));
//            List employees = c.list();

            Query query = session.createSQLQuery(
                    "SELECT * FROM courses t").addEntity(Course.class);

            List employees = query.list();

            //List employees = session.createQuery("FROM Student s join Grade g on g.studentId = s.id")
            //        .list();
            for (Object employee1 : employees) {
                Course employee = (Course) employee1;
                System.out.println("First Name: " + employee.getTeacherCourses());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}