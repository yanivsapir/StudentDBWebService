package il.ac.shenkar.sqlCourse.controllers;

import il.ac.shenkar.sqlCourse.dao.contracts.CourseDao;
import il.ac.shenkar.sqlCourse.dao.contracts.CourseQueriesDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.CourseQuery;
import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by ysapir on 11/21/2015.
 */

@RestController
@RequestMapping(value = "/courseQueries")
public class CourseQueriesController {

    @Autowired
    private CourseQueriesDao courseQueriesDao;

    @RequestMapping(value = "/getStudentCoursesByCourseId/{courseId}/{topOrBottom}/{limit}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<StudentCourse> getStudentCoursesByCourseId(@PathVariable int courseId, @PathVariable boolean topOrBottom, @PathVariable int limit) {
        return courseQueriesDao.getStudentCoursesByCourseId(courseId, topOrBottom, limit);
    }
}