package il.ac.shenkar.sqlCourse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import il.ac.shenkar.sqlCourse.entities.connectors.TeacherCourse;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 * Created by ysapir on 11/17/2015.
 */
@Entity
@Table(name = "teachers", schema = "collegedata")
public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String city;
    private String street = "";
    private Integer houseNum = 0;
    @JsonIgnore
    private List<TeacherCourse> teacherCourses;

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
        this.birthday = birthday;
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

    @OneToMany(fetch = FetchType.EAGER, targetEntity = TeacherCourse.class,cascade = CascadeType.ALL,mappedBy= "teacher")
    @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
    public List<TeacherCourse> getTeacherCourses() {
        return teacherCourses;
    }
    public void setTeacherCourses(List<TeacherCourse> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (!firstName.equals(teacher.firstName)) return false;
        if (!lastName.equals(teacher.lastName)) return false;
        if (!birthday.equals(teacher.birthday)) return false;
        if (!city.equals(teacher.city)) return false;
        if (!street.equals(teacher.street)) return false;
        if (!houseNum.equals(teacher.houseNum)) return false;
        return teacherCourses.equals(teacher.teacherCourses);

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
        result = 31 * result + teacherCourses.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
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
