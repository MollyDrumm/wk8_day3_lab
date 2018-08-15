import db.DBHelper;
import db.DBLesson;
import db.DBStudent;
import models.Course;
import models.Lesson;
import models.Mentor;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args){

        Course course1 = new Course("Computer Sience", "BSC");
        DBHelper.save(course1);
        Course course2 = new Course("English", "BEng");
        DBHelper.save(course2);
        Course course3 = new Course("Languages", "MA");
        DBHelper.save(course3);

        Lesson lesson1 = new Lesson("French", 20, course3);
        DBHelper.save(lesson1);
        Lesson lesson2 = new Lesson("Ruby", 2, course1);
        DBHelper.save(lesson2);
        Lesson lesson3 = new Lesson("Poetry", 23, course2);
        DBHelper.save(lesson3);

        Mentor mentor1 = new Mentor("Pawel");
        DBHelper.save(mentor1);
        Mentor mentor2 = new Mentor("Colin");
        DBHelper.save(mentor2);
        Mentor mentor3 = new Mentor("Alex");
        DBHelper.save(mentor3);

        Student student1 = new Student("Rosie", 27, 123, course1, mentor1);
        DBHelper.save(student1);
        Student student2 = new Student("Amy", 31, 123, course3, mentor2);
        DBHelper.save(student2);
        Student student3 = new Student("Darren", 34, 123, course2, mentor3);
        DBHelper.save(student3);


        DBStudent.addStudentToLesson(student1, lesson3);
        DBStudent.addStudentToLesson(student1, lesson2);

        List<Student> students = DBLesson.getStudentsForLesson(lesson1);

        List<Lesson> lessons = DBStudent.getLessonsForStudents(student1);



    }
}
