package database.database_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Executable;
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

    public void studentDeleteById(Student student) {
        try {
            Optional<Student> dataPresent = studentRepository.findById(student.getStudent_id());
            if (dataPresent.isPresent()) {
                studentRepository.deleteById(student.getStudent_id());
                System.out.println("delete record id " + student.getStudent_id());
            } else {
                System.out.println("record id not found" + student.getStudent_id());
            }
        } catch (Exception e) {
            System.out.println("Error here");
        }
    }


}