package mk.finki.ukim.wp.organizeme.persistance;

import mk.finki.ukim.wp.organizeme.models.StudyProgram;

import java.util.List;

public interface StudyProgramRepository {
    List<StudyProgram> listAllStudyPrograms();
    void addNewStudyProgram(String programName);
    void deleteStudyProgram(String programName);
}
