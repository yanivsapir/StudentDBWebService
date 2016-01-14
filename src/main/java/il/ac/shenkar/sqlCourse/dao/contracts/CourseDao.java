package il.ac.shenkar.sqlCourse.dao.contracts;


import il.ac.shenkar.sqlCourse.entities.Course;

import java.util.List;


/**
 * Created by ysapir on 11/21/2015.
 */

public interface CourseDao {
    public List<Course> getAllCourses();
    public Course getCourseByName(String name);
    public Course getCourseById(int id);
    public void updateCourse(Course course);
    public void deleteCourseFromDB(int id);
    public void insertNewCourse(Course course);
}
