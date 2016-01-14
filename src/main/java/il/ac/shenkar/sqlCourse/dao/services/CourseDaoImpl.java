package il.ac.shenkar.sqlCourse.dao.services;

import il.ac.shenkar.sqlCourse.dao.contracts.CourseDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Course.class);
        criteria.add(Restrictions.eq("name",name));
        return (Course) criteria.list().get(0);
    }

    @Override
    @Transactional
    public Course getCourseById(int id) {
        return (Course) sessionFactory.getCurrentSession().get(Course.class,id);
    }

    @Override
    @Transactional
    public void updateCourse(Course updatedCourse) {
        sessionFactory.getCurrentSession().update(updatedCourse);
    }

    @Override
    @Transactional
    public void deleteCourseFromDB(int id) {
        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Course.class,id));
    }

    @Override
    @Transactional
    public void insertNewCourse(Course course) {
        sessionFactory.getCurrentSession().persist(course);
    }
}
