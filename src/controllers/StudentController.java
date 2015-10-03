package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.Student;
import dao.StudentService;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

   
    @RequestMapping(value="/service/student/")
    public ModelAndView getAllStudents() {
        List<Student> Students = studentService.getAllStudents();
        ModelAndView model= new ModelAndView("autowireTest");
        model.addObject("student",Students.get(0).getName());
        return model;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Student getStudentById(@PathVariable int id) {
        Student Student = studentService.getStudentById(id);
        return Student;
    }
}