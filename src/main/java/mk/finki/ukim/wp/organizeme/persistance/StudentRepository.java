package mk.finki.ukim.wp.organizeme.persistance;

import mk.finki.ukim.wp.organizeme.models.Student;
import mk.finki.ukim.wp.organizeme.models.dtos.StudentDto;
import mk.finki.ukim.wp.organizeme.models.exceptions.IndexFormatException;
import mk.finki.ukim.wp.organizeme.models.exceptions.MissingArgumentException;
import mk.finki.ukim.wp.organizeme.models.exceptions.StudentNotFoundException;
import mk.finki.ukim.wp.organizeme.models.exceptions.StudyProgramNotFoundException;

import java.util.List;

public interface StudentRepository {
    void addNewStudent(Student student) throws MissingArgumentException, IndexFormatException, StudyProgramNotFoundException;
    void deleteStudent(String index);
    void updateStudent(Student student);
    Student getStudentByIndex(String index) throws StudentNotFoundException;
    List<StudentDto> listAllStudents();
    List<StudentDto> listStudentsByProgram(long program);

}
