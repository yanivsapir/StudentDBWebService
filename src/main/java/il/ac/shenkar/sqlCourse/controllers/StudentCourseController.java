package il.ac.shenkar.sqlCourse.controllers;

import il.ac.shenkar.sqlCourse.dao.contracts.StudentCourseDao;
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
@RequestMapping(value = "/studentCourse")
public class StudentCourseController {

    @Autowired
    private StudentCourseDao studentCourseDao;

    @RequestMapping(value = "/getAllStudentCourses", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<StudentCourse> getAllStudentCourses() {
        return studentCourseDao.getAllStudentCourses();
    }

    @RequestMapping(path="/getStudentCourseById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public StudentCourse getStudentCourseById(@PathVariable int id) {
        return studentCourseDao.getStudentCourseByID(id);
    }

    @RequestMapping(path = "/updateStudentCourse", method = RequestMethod.POST)
    public ResponseEntity<String> updateStudentCourse(@RequestBody StudentCourse studentCourse) {

        studentCourseDao.updateStudentCourse(studentCourse);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteStudentCourse/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> deleteStudentCourse(@PathVariable int id) {

        studentCourseDao.deleteStudentCourse(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/insertNewStudentCourse", method = RequestMethod.POST)
    public ResponseEntity<String> insertNewStudentCourse(@RequestBody StudentCourse studentCourse) {

        studentCourseDao.insertNewStudentCourse(studentCourse);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}