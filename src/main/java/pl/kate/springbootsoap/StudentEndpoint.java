package pl.kate.springbootsoap;

import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pl.kate.springbootsoap.student.GetResponse;
import pl.kate.springbootsoap.student.GetStudent;
import pl.kate.springbootsoap.student.Student;

@Endpoint
public class StudentEndpoint {

    private StudentService studentService;

    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @PayloadRoot(namespace = "http://kate.pl/soap", localPart = "getStudent")
    @ResponsePayload
    public GetResponse getStudentById(@RequestPayload GetStudent getStudent){
        Student studentById = studentService.getStudentById(getStudent.getId());
        GetResponse getResponse = new GetResponse();
        getResponse.setStudent(studentById);
        return getResponse;
    }
}
