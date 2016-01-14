package il.ac.shenkar.sqlCourse.dao.contracts;

import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.connectors.TeacherCourse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by ysapir on 11/21/2015.
 */

public interface TeacherCourseDao {
    public List<TeacherCourse> getAllTeacherCourses();
    public TeacherCourse getTeacherCourseById(int id);
    public void updateTeacherCourse(TeacherCourse teacherCourse);
    public void deleteTeacherCourse(int id);
    public void insertNewTeacherCourseToDB(TeacherCourse teacherCourse);
}
