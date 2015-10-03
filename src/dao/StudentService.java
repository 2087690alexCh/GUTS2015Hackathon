package dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service("StudentService")
public class StudentService {

    public List<Student> getAllStudents() {
        List<Student> Students = new ArrayList<Student>();

        Student student = new Student();
        student.setName("Rockey");
        Students.add(student);

        student = new Student();
        student.setName("Jose");
        Students.add(student);

        return Students;
    }

    public Student getStudentById(int StudentId) {
        Student student = null;
        if (StudentId == 1) {
            student = new Student();
            student.setName("Jose");
        }else{
            student = new Student();
            student.setName("Invalid Student");
        }
        return student;
    }
}