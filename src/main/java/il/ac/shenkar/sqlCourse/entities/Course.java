package il.ac.shenkar.sqlCourse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;
import il.ac.shenkar.sqlCourse.entities.connectors.TeacherCourse;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

/**
 * Created by ysapir on 11/17/2015.
 */
@Entity
@Table(name = "courses", schema = "collegedata")
public class Course {
    private int id;
    private String name;
    private String semester;
    private String year;
    @JsonIgnore
    List<StudentCourse> studentCourses;
    @JsonIgnore
    List<TeacherCourse> teacherCourses;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "semester")
    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    @Basic
    @Column(name = "year")
    public String getYear() { return year; }
    public void setYear(String year) { this.year = year; }

    @OneToMany(targetEntity = StudentCourse.class,cascade = CascadeType.ALL,mappedBy= "course")
    @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
    public List<StudentCourse> getStudentCourses() {
        return studentCourses;
    }
    public void setStudentCourses(List<StudentCourse> studentCourses) {
        this.studentCourses= studentCourses;
    }

    @OneToMany(targetEntity = TeacherCourse.class,cascade = CascadeType.ALL,mappedBy= "course")
    @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
    public List<TeacherCourse> getTeacherCourses() {
        return teacherCourses;
    }
    public void setTeacherCourses(List<TeacherCourse> teacherCourses) {
        this.teacherCourses= teacherCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (id != course.id) return false;
        if (year != course.year) return false;
        if (!name.equals(course.name)) return false;
        if (!semester.equals(course.semester)) return false;
        if (!studentCourses.equals(course.studentCourses)) return false;
        return teacherCourses.equals(course.teacherCourses);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + semester.hashCode();
        result = 31 * result + year.hashCode();
        result = 31 * result + studentCourses.hashCode();
        result = 31 * result + teacherCourses.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", semester='" + semester + '\'' +
                ", year=" + year +
                '}';
    }
}
