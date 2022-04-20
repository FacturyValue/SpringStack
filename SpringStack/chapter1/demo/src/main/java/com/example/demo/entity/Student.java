package com.example.demo.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

/**
 * @version V1.0
 * @Description: Student实体类
 * @author: rudy
 * @date: 2022/4/16 17:53
 */
@ApiModel(value = "Student",description = "学生")
@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @ApiModelProperty(value = "学生Id")
    private Long id;
    @ApiModelProperty(value = "学生姓名")
    private String name;
    @ApiModelProperty(value = "学生的邮件名")
    private String email;
    @ApiModelProperty(value = "学生的出生日期")
    private LocalDate dob;

    @ApiModelProperty(value = "学生的年龄")
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(dob,LocalDate.now()).getYears();
        //return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
