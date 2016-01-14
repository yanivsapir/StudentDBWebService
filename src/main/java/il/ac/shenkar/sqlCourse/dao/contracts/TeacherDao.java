package il.ac.shenkar.sqlCourse.dao.contracts;


import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Teacher;
import il.ac.shenkar.sqlCourse.entities.connectors.TeacherCourse;

import java.io.IOException;
import java.util.List;


/**
 * Created by ysapir on 11/21/2015.
 */

public interface TeacherDao {
    public List<Teacher> getAllTeachers();
    public List<TeacherCourse> getTeacherCoursesByTeacherId(int id);
    public Teacher getTeacherByID(int id);
    public void updateTeacher(Teacher teacher);
    public void deleteTeacherFromDB(int id);
    public void insertNewTeacherToDB(Teacher teacher);
}
