package pl.kate.springbootsoap;

import org.springframework.stereotype.Service;
import pl.kate.springbootsoap.student.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students;

    public Student getStudentById(long id){
        return students
                .stream()
                .filter(student -> student.getId() == id)
                .findFirst().get();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudentService() {
        students = new ArrayList<>();
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Kasia");
        student1.setSurname("Tomaszycka");

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Krysia");
        student2.setSurname("Nowak");
    }
}
