package il.ac.shenkar.sqlCourse.dao.services;

import il.ac.shenkar.sqlCourse.dao.contracts.CourseDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ysapir on 11/23/2015.
 */
public class CourseDaoImpl implements CourseDao {

    private SessionFactory sessionFactory;
    public CourseDaoImpl(){}
    public CourseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Course> getAllCourses() {
        return (List<Course>) sessionFactory.getCurrentSession()
                .createCriteria(Course.class).list();
    }

    @Override
    @Transactional
    public Course getCourseByName(String name) {
        return (Course) sessionFactory.getCurrentSession().get(Course.class,name);
    }

    @Override
    @Transactional
    public void updateCourse(Course updatedCourse) {
        sessionFactory.getCurrentSession().update(updatedCourse);
    }

    @Override
    @Transactional
    public void deleteCourseFromDB(Course course) {
        sessionFactory.getCurrentSession().delete(course);
    }

    @Override
    @Transactional
    public void insertNewCourse(Course course) {
        sessionFactory.getCurrentSession().persist(course);
    }
}
