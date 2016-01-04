package il.ac.shenkar.sqlCourse.controllers;

import il.ac.shenkar.sqlCourse.dao.contracts.TeacherDao;
import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


/**
 * Created by ysapir on 11/21/2015.
 */

@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Autowired
    private TeacherDao teacherDao;

    @RequestMapping(value = "/getAllTeachers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }

    @RequestMapping(path="/getTeacherById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherDao.getTeacherByID(id);
    }

    @RequestMapping(path="/getTeacherCoursesByTeacherId/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Course> getTeacherCoursesByTeacherId(@PathVariable int id) {

        return teacherDao.getTeacherCoursesByTeacherId(id);
    }

    @RequestMapping(path = "/updateTeacher", method = RequestMethod.POST)
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher) {

        teacherDao.updateTeacher(teacher);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/deleteTeacher/{id}", method = RequestMethod.POST)
    public ResponseEntity<String> deleteTeacher(@PathVariable int id) {

        teacherDao.deleteTeacherFromDB(id);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(path = "/insertNewTeacherToDB", method = RequestMethod.POST)
    public ResponseEntity<String> insertNewTeacherToDB(@RequestBody Teacher teacher) {

        teacherDao.insertNewTeacherToDB(teacher);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}