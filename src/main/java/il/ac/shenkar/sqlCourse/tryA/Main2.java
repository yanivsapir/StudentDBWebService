package il.ac.shenkar.sqlCourse.tryA;

import il.ac.shenkar.sqlCourse.config.JavaConfig;
import il.ac.shenkar.sqlCourse.dao.contracts.TeacherCourseDao;
import il.ac.shenkar.sqlCourse.dao.contracts.TeacherDao;
import il.ac.shenkar.sqlCourse.entities.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by ysapir on 11/21/2015.
 */
public class Main2 {

    public static void main(String[] args) throws IOException {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class)) {
            TeacherDao service = context.getBean(TeacherDao.class);
            System.out.println(service.getAllTeachers());
        }
    }
}