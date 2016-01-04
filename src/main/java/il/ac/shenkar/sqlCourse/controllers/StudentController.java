package il.ac.shenkar.sqlCourse.controllers;

import il.ac.shenkar.sqlCourse.dao.contracts.StudentDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Student;
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
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @RequestMapping(value = "/getAllStudents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @RequestMapping(path="/getStudentById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student getStudentById(@PathVariable int id) {
        return studentDao.getStudentByID(id);
    }

    @RequestMapping(path="/getStudentCoursesByStudentId/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Course> getStudentCoursesByStudentId(@PathVariable int id) {

        return studentDao.getStudentCoursesByStudentId(id);
    }

    @RequestMapping(path = "/updateStudent", method = RequestMethod.POST)
    public ResponseEntity<String> updateStudent(@RequestBody Student student) {

        studentDao.updateStudent(student);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteStudent/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {

        studentDao.deleteStudentFromDB(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/insertNewStudentToDB", method = RequestMethod.POST)
    public ResponseEntity<String> insertNewStudentToDB(@RequestBody Student student) {

        studentDao.insertNewStudentToDB(student);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}