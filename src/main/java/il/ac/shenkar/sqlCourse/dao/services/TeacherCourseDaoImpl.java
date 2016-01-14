package il.ac.shenkar.sqlCourse.dao.services;

import il.ac.shenkar.sqlCourse.dao.contracts.TeacherCourseDao;
import il.ac.shenkar.sqlCourse.dao.contracts.TeacherDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Teacher;
import il.ac.shenkar.sqlCourse.entities.connectors.TeacherCourse;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysapir on 11/21/2015.
 */
public class TeacherCourseDaoImpl implements TeacherCourseDao{
    private SessionFactory sessionFactory;

    public TeacherCourseDaoImpl(){}
    public TeacherCourseDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<TeacherCourse> getAllTeacherCourses() {

        return (List<TeacherCourse>) sessionFactory.getCurrentSession()
                .createCriteria(TeacherCourse.class).list();
    }

    @Override
    @Transactional
    public TeacherCourse getTeacherCourseById(int id) {
        return (TeacherCourse) sessionFactory.getCurrentSession().get(TeacherCourse.class,id);
    }

    @Override
    @Transactional
    public void updateTeacherCourse(TeacherCourse updatedTeacherCourse) {

        sessionFactory.getCurrentSession().update(updatedTeacherCourse);
    }

    @Override
    @Transactional
    public void deleteTeacherCourse(int id) {
        Query q = sessionFactory.getCurrentSession().createQuery("delete TeacherCourse where id = " + id);
        q.executeUpdate();
    }

    @Override
    @Transactional
    public void insertNewTeacherCourseToDB(TeacherCourse teacherCourse) {
        sessionFactory.getCurrentSession().save(teacherCourse);
    }
}