package mk.finki.ukim.wp.organizeme.persistance.implementations;

import mk.finki.ukim.wp.organizeme.models.Student;
import mk.finki.ukim.wp.organizeme.models.StudyProgram;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Profile("in-memory-db")
public class StudentsInMemoryDatabase {

    public static ArrayList<Student> Students= new ArrayList<>();
    public static ArrayList<StudyProgram> StudyPrograms=new ArrayList<>();
    @PostConstruct
    public static void Init(){

        StudyPrograms.add(new StudyProgram("KNI"));
        StudyPrograms.add(new StudyProgram("MT"));
        StudyPrograms.add(new StudyProgram("IKI"));
        StudyPrograms.add(new StudyProgram("PET"));
        StudyPrograms.add(new StudyProgram("ASI"));


        StudyProgram kni=StudyPrograms.get(0);
        StudyProgram mt=StudyPrograms.get(1);
        StudyProgram iki=StudyPrograms.get(2);
        StudyProgram pet=StudyPrograms.get(3);
        StudyProgram asi=StudyPrograms.get(4);

        Students.add(new Student("151093","Kaltrin","Ismaili",kni));
        Students.add(new Student("151193","John","Doe",kni));
        Students.add(new Student("151293","Simo","Hayha",kni));
        Students.add(new Student("151393","Jack","Bauer",kni));
        Students.add(new Student("151493","Scott","Adkins",kni));
        Students.add(new Student("152093","John","Travolta",mt));
        Students.add(new Student("152193","Mary","Jane",mt));
        Students.add(new Student("152293","Jane","Smith",mt));
        Students.add(new Student("152393","Scarlett","Johannson",mt));
        Students.add(new Student("152493","Skylar","Gray",mt));
        Students.add(new Student("153093","Nicki","Minaj",iki));
        Students.add(new Student("153193","Jason","Funk",iki));
        Students.add(new Student("153293","Juniper","Lee",iki));
        Students.add(new Student("153393","Danny","DeVito",iki));
        Students.add(new Student("153493","Brad","Pitt",iki));
        Students.add(new Student("154093","Angelina","Jolie",pet));
        Students.add(new Student("154193","Jack","Sparrow",pet));
        Students.add(new Student("154293","Penny","Wise",pet));
        Students.add(new Student("154393","Bruce","Banner",pet));
        Students.add(new Student("154493","Denice","Rose",pet));
        Students.add(new Student("155093","Denephew","Rose",asi));
        Students.add(new Student("155193","Tracy","Stones",asi));
        Students.add(new Student("155293","Kim","Jongun",asi));
        Students.add(new Student("155393","Dennis","Campbell",asi));
        Students.add(new Student("155493","Penelope","Cruz",asi));
    }



}
