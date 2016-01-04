package il.ac.shenkar.sqlCourse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import il.ac.shenkar.sqlCourse.entities.connectors.StudentCourse;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ysapir on 11/17/2015.
 */
@Entity
@Table(name = "students", schema = "collegedata")
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String city;
    private String street;
    private Integer houseNum;
    @JsonIgnore
    private List<StudentCourse> studentCourses;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "birthday")
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday= birthday;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "houseNum")
    public Integer getHouseNum() {
        return houseNum;
    }
    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    @OneToMany(fetch = FetchType.EAGER, targetEntity = StudentCourse.class,cascade = CascadeType.ALL,mappedBy= "student")
    @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
    public List<StudentCourse> getStudentCourses() { return studentCourses; }
    public void setStudentCourses(List<StudentCourse> studentCourses) { this.studentCourses = studentCourses; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (id != student.id) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!lastName.equals(student.lastName)) return false;
        if (!birthday.equals(student.birthday)) return false;
        if (!city.equals(student.city)) return false;
        if (!street.equals(student.street)) return false;
        if (!houseNum.equals(student.houseNum)) return false;
        return studentCourses.equals(student.studentCourses);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + houseNum.hashCode();
        result = 31 * result + studentCourses.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNum=" + houseNum +
                '}';
    }
}
