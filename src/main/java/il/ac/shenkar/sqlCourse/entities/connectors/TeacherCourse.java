package il.ac.shenkar.sqlCourse.entities.connectors;

import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Teacher;

import javax.persistence.*;

/**
 * Created by ysapir on 11/17/2015.
 */
@Entity
@Table(name = "teacherscourses", schema = "collegedata")
public class TeacherCourse {
    private int id;
    private Teacher teacher;
    private Course course;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="lecturer_id")
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherCourse that = (TeacherCourse) o;

        if (id != that.id) return false;
        if (!teacher.equals(that.teacher)) return false;
        return course.equals(that.course);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + teacher.hashCode();
        result = 31 * result + course.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TeacherCourse{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", course=" + course +
                '}';
    }
}
