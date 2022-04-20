package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version V1.0
 * @Description:
 * @author: rudy
 * @date: 2022/4/16 18:02
 */
@Api(value = "Student",description = "学生")
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @ApiOperation(value = "获取所有学生信息")
    @GetMapping(path = "/listAll")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @ApiOperation(value = "根据Id获取学生信息")
    @GetMapping(value = "/list/{studentId}")
    public Student getStudentById(
            @ApiParam(required = true,name = "studentId",value = "学生Id")
            @PathVariable(value = "studentId") Long studentId){
        return studentService.getStudentById(studentId);

    }
    @ApiOperation(value = "添加Student信息")
    @PostMapping(value = "/create")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @ApiOperation(value = "根据Id修改Student信息",response = com.example.demo.entity.Student.class,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping(path = "/update/{studentId}")
    public void updateStudent(@ApiParam(required = true,name = "studentId",value = "学生Id")
                              @PathVariable("studentId") Long studentId,
                              @ApiParam(required = false,name = "name",value = "学生的姓名")
                              @RequestParam(required = false)String name,
                              @ApiParam(required = false,name = "email",value = "学生的邮件")
                              @RequestParam(required = false)String email){
        studentService.updateStudent(studentId,name,email);
    }
    @ApiOperation(value = "根据Id删除学生信息")
    @DeleteMapping(path = "/delete/{studentId}")
    @ApiImplicitParams({
            @ApiImplicitParam(name="studentId",value="学生Id",required=true)
    })
    public void deleteStudent(
            //@ApiParam(required = true,name = "studentId",value = "学生Id")
            @PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }
}
