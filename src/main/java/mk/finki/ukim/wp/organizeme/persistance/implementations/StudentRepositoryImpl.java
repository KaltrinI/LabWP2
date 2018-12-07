package mk.finki.ukim.wp.organizeme.persistance.implementations;

import mk.finki.ukim.wp.organizeme.models.Student;
import mk.finki.ukim.wp.organizeme.models.StudyProgram;
import mk.finki.ukim.wp.organizeme.models.dtos.StudentDto;
import mk.finki.ukim.wp.organizeme.models.exceptions.IndexFormatException;
import mk.finki.ukim.wp.organizeme.models.exceptions.MissingArgumentException;
import mk.finki.ukim.wp.organizeme.models.exceptions.StudentNotFoundException;
import mk.finki.ukim.wp.organizeme.models.exceptions.StudyProgramNotFoundException;
import mk.finki.ukim.wp.organizeme.persistance.StudentRepository;
import mk.finki.ukim.wp.organizeme.persistance.StudyProgramRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository , StudyProgramRepository {


    public StudentRepositoryImpl(){
        StudentsInMemoryDatabase.Init();
    }


    @Override
    public void addNewStudent(Student student) throws MissingArgumentException, IndexFormatException, StudyProgramNotFoundException {
        validate(student);
        StudentsInMemoryDatabase.Students.add(student);

    }

    @Override
    public void deleteStudent(String index) {
        StudentsInMemoryDatabase.Students.removeIf(x->x.index.equals(index));
    }

    @Override
    public void updateStudent(Student student) {
        for (Student s : StudentsInMemoryDatabase.Students) {
            if (s.id==student.id)
                s=student;
        }
    }

    @Override
    public Student getStudentByIndex(String index) throws StudentNotFoundException {
        for (Student s : StudentsInMemoryDatabase.Students) {
            if (s.index.equals(index))
                return s;
        }

        throw new StudentNotFoundException(String.format("The student with index %s was not found",index));
    }

    @Override
    public List<StudentDto> listAllStudents() {
        ArrayList<StudentDto> list=new ArrayList<>();
        StudentsInMemoryDatabase.Students.forEach(student -> list.add(new StudentDto(student.index,student.name,student.lastName)));
        return list;
    }

    @Override
    public List<StudentDto> listStudentsByProgram(long program) {
        ArrayList<StudentDto> list=new ArrayList<>();
        StudentsInMemoryDatabase.Students.forEach(student -> {
            if(student.studyProgram.id==program)
                list.add(new StudentDto(student.index,student.name,student.lastName));
        });
        return list;
    }

    @Override
    public List<StudyProgram> listAllStudyPrograms() {
        return StudentsInMemoryDatabase.StudyPrograms;
    }

    @Override
    public void addNewStudyProgram(String programName) {
        StudentsInMemoryDatabase.StudyPrograms.add(new StudyProgram(programName));
    }

    @Override
    public void deleteStudyProgram(String programName) {
        StudentsInMemoryDatabase.StudyPrograms.removeIf(x->x.name.equals(programName));
    }

    private void validate(Student student) throws MissingArgumentException, IndexFormatException, StudyProgramNotFoundException {
        if (student.name==null || student.lastName ==null || student.studyProgram==null || student.index==null)
            throw new MissingArgumentException("Not all info are provided for the given student");

        if (student.index.length()!=6)
            throw new IndexFormatException("Invalid index format");

        boolean exists=false;

        for (StudyProgram sp: StudentsInMemoryDatabase.StudyPrograms) {
            if (sp.name.equals(student.studyProgram.name))
                exists=true;
        }

        if(!exists)
            throw new StudyProgramNotFoundException("Invalid study program");
    }
}
