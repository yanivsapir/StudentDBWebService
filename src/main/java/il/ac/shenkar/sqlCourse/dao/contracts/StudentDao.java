package il.ac.shenkar.sqlCourse.dao.contracts;


import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Student;
import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;

import java.util.List;


/**
 * Created by ysapir on 11/21/2015.
 */

public interface StudentDao {
    public List<Student> getAllStudents();
    public List<StudentCourse> getStudentCoursesByStudentId(int id);
    public Student getStudentByID(int id);
    public void updateStudent(Student student);
    public void deleteStudentFromDB(int id);
    public void insertNewStudentToDB(Student student);
}
