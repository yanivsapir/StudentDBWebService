package il.ac.shenkar.sqlCourse.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import il.ac.shenkar.sqlCourse.dao.contracts.*;
import il.ac.shenkar.sqlCourse.dao.services.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

/**
 * Created by ysapir on 11/21/2015.
 */
@Configuration
@ComponentScan("il.ac.shenkar.sqlCourse")
@EnableTransactionManagement
public class JavaConfig {

    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource(){
        BasicDataSource bc = new BasicDataSource();
        bc.setDriverClassName("com.mysql.jdbc.Driver");
        bc.setUrl("jdbc:mysql://localhost:3306/collegedata");
        bc.setUsername("root");
        bc.setPassword("password");
        return bc;
    }

    @Bean
    public SessionFactory sessionFactory(){
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(dataSource());
        lsfb.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        try {
            lsfb.afterPropertiesSet();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lsfb.getObject();
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        return new HibernateTransactionManager(sessionFactory());
    }

    @Bean
    public StudentDao studentDao(){
        return new StudentDaoImpl(sessionFactory());
    }

    @Bean
    public CourseDao courseDao(){
        return new CourseDaoImpl(sessionFactory());
    }

    @Bean
    public TeacherDao teacherDao(){
        return new TeacherDaoImpl(sessionFactory());
    }

    @Bean
    public TeacherCourseDao teacherCourseDao(){ return new TeacherCourseDaoImpl(sessionFactory()); }

    @Bean
    public StudentCourseDao studentCourseDao(){
        return new StudentCourseDaoImpl(sessionFactory());
    }
}
