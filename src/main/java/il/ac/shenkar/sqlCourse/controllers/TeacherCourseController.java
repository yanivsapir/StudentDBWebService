package il.ac.shenkar.sqlCourse.controllers;

import il.ac.shenkar.sqlCourse.dao.contracts.TeacherCourseDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.connectors.TeacherCourse;
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
@RequestMapping(value = "/teacherCourse")
public class TeacherCourseController {

    @Autowired
    private TeacherCourseDao teacherCourseDao;

    @RequestMapping(value = "/getAllTeachersCourses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TeacherCourse> getAllTeachersCourses() {
        return teacherCourseDao.getAllTeacherCourses();
    }


    @RequestMapping(path = "/updateTeacherCourse", method = RequestMethod.POST)
    public ResponseEntity<String> updateTeacherCourse(@RequestBody TeacherCourse teacherCourse) {

        teacherCourseDao.updateTeacherCourse(teacherCourse);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteTeacherCourse", method = RequestMethod.POST)
    public ResponseEntity<String> deleteTeacherCourse(@RequestBody TeacherCourse teacherCourse) {

        teacherCourseDao.deleteTeacherCourse(teacherCourse);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/insertNewTeacherCourseToDB", method = RequestMethod.POST)
    public ResponseEntity<String> insertNewTeacherCourseToDB(@RequestBody TeacherCourse teacherCourse) {

        teacherCourseDao.insertNewTeacherCourseToDB(teacherCourse);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}