package mk.finki.ukim.wp.organizeme.models;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Student {

    @Column
    @GeneratedValue(strategy = AUTO)
    public long id;

    @Id
    @Column
    public String index;
    @Column
    public String name;
    @Column
    public String lastName;
    @OneToOne
    public StudyProgram studyProgram;

    public Student(String index, String name, String lastName, StudyProgram studyProgram){
        this.index=index;
        this.name=name;
        this.lastName=lastName;
        this.studyProgram=studyProgram;
    }
}
