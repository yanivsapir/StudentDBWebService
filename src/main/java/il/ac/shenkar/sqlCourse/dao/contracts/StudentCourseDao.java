package il.ac.shenkar.sqlCourse.dao.contracts;


import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;

import java.util.List;


/**
 * Created by ysapir on 11/21/2015.
 */

public interface StudentCourseDao {
    public List<StudentCourse> getAllStudentCourses();
    public StudentCourse getStudentCourseByID(int Id);
    public void updateStudentCourse(StudentCourse studentCourse);
    public void deleteStudentCourse(int id);
    public void insertNewStudentCourse(StudentCourse studentCourse);
}
