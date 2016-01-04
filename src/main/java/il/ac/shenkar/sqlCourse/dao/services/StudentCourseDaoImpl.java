package il.ac.shenkar.sqlCourse.dao.services;

import il.ac.shenkar.sqlCourse.dao.contracts.StudentCourseDao;
import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ysapir on 11/21/2015.
 */
public class StudentCourseDaoImpl implements StudentCourseDao {
    private SessionFactory sessionFactory;

    public StudentCourseDaoImpl(){}
    public StudentCourseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<StudentCourse> getAllStudentCourses() {

        return (List<StudentCourse>) sessionFactory.getCurrentSession()
                .createCriteria(StudentCourse.class).list();
    }

    @Override
    @Transactional
    public StudentCourse getStudentCourseByID(int id) {
        return (StudentCourse) sessionFactory.getCurrentSession().get(StudentCourse.class,id);
    }

    @Override
    @Transactional
    public void updateStudentCourse(StudentCourse updatedStudentCourse) {

        sessionFactory.getCurrentSession().update(updatedStudentCourse);
    }

    @Override
    @Transactional
    public void deleteStudentCourse(StudentCourse studentCourse) {
        sessionFactory.getCurrentSession().delete(studentCourse);
    }

    @Override
    @Transactional
    public void insertNewStudentCourse(StudentCourse studentCourse) {
        sessionFactory.getCurrentSession().persist(studentCourse);
    }
}