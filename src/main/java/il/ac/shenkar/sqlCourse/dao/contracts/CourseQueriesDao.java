package il.ac.shenkar.sqlCourse.dao.contracts;


import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.CourseQuery;
import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;

import java.util.List;


/**
 * Created by ysapir on 11/21/2015.
 */

public interface CourseQueriesDao {
    List<StudentCourse> getStudentCoursesByCourseId(int CourseId, boolean top, int limit);
}
