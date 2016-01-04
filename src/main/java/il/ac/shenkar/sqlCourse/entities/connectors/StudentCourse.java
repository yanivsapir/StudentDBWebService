package il.ac.shenkar.sqlCourse.entities.connectors;

import il.ac.shenkar.sqlCourse.entities.Course;
import il.ac.shenkar.sqlCourse.entities.Student;

import javax.persistence.*;

/**
 * Created by ysapir on 11/17/2015.
 */
@Entity
@Table(name = "studentcourses", schema = "collegedata")
public class StudentCourse {
    private int id;
    private int grade;
    private Course course;
    private Student student;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "grade")
    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
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
    @JoinColumn(name="student_id")
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) { this.student = student; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourse that = (StudentCourse) o;

        if (id != that.id) return false;
        if (grade != that.grade) return false;
        if (!course.equals(that.course)) return false;
        return student.equals(that.student);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + grade;
        result = 31 * result + course.hashCode();
        result = 31 * result + student.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
                "id=" + id +
                ", grade=" + grade +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
