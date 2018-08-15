package db;

import models.Lesson;
import models.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.awt.*;
import java.util.List;

public class DBLesson {

    private static Session session;
    private static Transaction transaction;

    public static List<Student> getStudentsForLesson(Lesson lesson){
        List<Student> results = null;
        session = HibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(Student.class);
            cr.createAlias("lessons", "lesson");
            cr.add(Restrictions.eq("lesson.id", lesson.getId()));
            results =cr.list();
        } catch (HeadlessException ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
