package database.database_service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    public Optional<Student> displayById(Student student) {

        return studentRepository.findById(student.getStudent_id());

    }

    public List<Student> displayStudents() {

        return studentRepository.findAll();

    }

    public Student createStudent(StudentEntity studentEntity) {

        Student student = new Student();
        student.setStudent_fname(studentEntity.getStudent_fname());
        student.setStudent_lname(studentEntity.getStudent_lname());
        student.setStudent_age(studentEntity.getStudent_age());

        student.setStudent_salary(studentEntity.getStudent_salary());
        student.setStudent_dep(studentEntity.getStudent_dep());
        student.setStudent_cource(studentEntity.getStudent_cource());

        return studentRepository.save(student);

    }
}
