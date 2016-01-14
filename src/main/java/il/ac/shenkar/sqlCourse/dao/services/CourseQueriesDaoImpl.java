package il.ac.shenkar.sqlCourse.dao.services;

import il.ac.shenkar.sqlCourse.dao.contracts.CourseDao;
import il.ac.shenkar.sqlCourse.dao.contracts.CourseQueriesDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.CourseQuery;
import il.ac.shenkar.sqlCourse.entities.Student;
import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ysapir on 11/23/2015.
 */
public class CourseQueriesDaoImpl implements CourseQueriesDao {

    private SessionFactory sessionFactory;
    public CourseQueriesDaoImpl(){}
    public CourseQueriesDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<StudentCourse> getStudentCoursesByCourseId(int courseId, boolean top, int limit){

        Course course = (Course) sessionFactory.getCurrentSession().get(Course.class,courseId);
        Order order = top == true ? Order.desc("grade") : Order.asc("grade");
        return sessionFactory.getCurrentSession().createCriteria(StudentCourse.class)
                .add(Restrictions.eq( "course", course)).setMaxResults(limit).addOrder(order)
                .list();
    }
}
