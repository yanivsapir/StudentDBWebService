package il.ac.shenkar.sqlCourse.controllers;

import il.ac.shenkar.sqlCourse.dao.contracts.CourseDao;
import il.ac.shenkar.sqlCourse.entities.Course;
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
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseDao courseDao;

    @RequestMapping(value = "/getAllCourses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @RequestMapping(path="/getCourseByName/{name}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Course getCourseByName(@PathVariable String name) {
        return courseDao.getCourseByName(name);
    }

    @RequestMapping(path="/getCourseById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Course getCourseById(@PathVariable int id) {
        return courseDao.getCourseById(id);
    }

    @RequestMapping(path = "/updateCourse", method = RequestMethod.POST)
    public ResponseEntity<String> updateCourse(@RequestBody Course course) {

        courseDao.updateCourse(course);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteCourse/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

        courseDao.deleteCourseFromDB(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/insertNewCourse", method = RequestMethod.POST)
    public ResponseEntity<String> insertNewCourse(@RequestBody Course course) {

        courseDao.insertNewCourse(course);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}