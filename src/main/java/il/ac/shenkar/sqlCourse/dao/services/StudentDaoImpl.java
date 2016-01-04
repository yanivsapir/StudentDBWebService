package il.ac.shenkar.sqlCourse.dao.services;

import il.ac.shenkar.sqlCourse.dao.contracts.StudentDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Student;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysapir on 11/21/2015.
 */
public class StudentDaoImpl implements StudentDao {
    private SessionFactory sessionFactory;

    public StudentDaoImpl(){}
    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Student> getAllStudents() {

        return (List<Student>) sessionFactory.getCurrentSession()
                .createCriteria(Student.class).list();
    }

    @Override
    @Transactional
    public List<Course> getStudentCoursesByStudentId(int id) {

        List<Course> courses = new ArrayList<>();
        getStudentByID(id).getStudentCourses()
                .forEach(teacherCourse -> courses.add(teacherCourse.getCourse()));
        return courses;
    }

    @Override
    @Transactional
    public Student getStudentByID(int id) {
        return (Student) sessionFactory.getCurrentSession().get(Student.class,id);
    }

    @Override
    @Transactional
    public void updateStudent(Student updatedStudent) {

        sessionFactory.getCurrentSession().update(updatedStudent);
    }

    @Override
    @Transactional
    public void deleteStudentFromDB(int id) {

        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Student.class,id));
    }

    @Override
    @Transactional
    public void insertNewStudentToDB(Student student) {
        sessionFactory.getCurrentSession().persist(student);
    }
}