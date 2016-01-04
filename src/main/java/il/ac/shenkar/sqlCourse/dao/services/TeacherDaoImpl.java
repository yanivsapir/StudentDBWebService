package il.ac.shenkar.sqlCourse.dao.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import il.ac.shenkar.sqlCourse.dao.contracts.TeacherDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Teacher;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ysapir on 11/21/2015.
 */
public class TeacherDaoImpl implements TeacherDao {
    private SessionFactory sessionFactory;

    public TeacherDaoImpl(){}
    public TeacherDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Teacher> getAllTeachers() {
        return (List<Teacher>) sessionFactory.getCurrentSession()
                .createCriteria(Teacher.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    @Override
    @Transactional
    public List<Course> getTeacherCoursesByTeacherId(int id) {

        List<Course> courses = new ArrayList<>();
        getTeacherByID(id).getTeacherCourses()
                .forEach(teacherCourse -> courses.add(teacherCourse.getCourse()));
        return courses;
    }

    @Override
    @Transactional
    public Teacher getTeacherByID(int id) {
        return (Teacher) sessionFactory.getCurrentSession().get(Teacher.class,id);
    }

    @Override
    @Transactional
    public void updateTeacher(Teacher updatedTeacher) { sessionFactory.getCurrentSession().update(updatedTeacher);}

    @Override
    @Transactional
    public void deleteTeacherFromDB(int id) {

        sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().get(Teacher.class,id));
    }

    @Override
    @Transactional
    public void insertNewTeacherToDB(Teacher teacher) {

        sessionFactory.getCurrentSession().save(teacher);
    }
}