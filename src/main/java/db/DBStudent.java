package db;


import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.awt.*;
import java.util.List;

public class DBStudent {

    private static Session session;
    private static Transaction transaction;

    public static void addStudentToLesson(Student student, Lesson lesson){
        student.addLesson(lesson);
        lesson.addStudent(student);
        DBHelper.update(student);
    }

    public static List<Lesson> getLessonsForStudents(Student student){
        List<Lesson> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Lesson.class);
            cr.createAlias("students", "student");
            cr.add(Restrictions.eq("student.id", student.getId()));
            results = cr.list();
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
