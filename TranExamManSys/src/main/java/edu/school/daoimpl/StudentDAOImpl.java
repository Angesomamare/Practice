package edu.school.daoimpl;

import edu.school.dao.DAO;

/**
 * Created by ziwuitu on 10/12/16.
 */

import java.util.List;

import edu.school.models.Student;
import edu.school.models.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
@Component
public class StudentDAOImpl implements DAO<Student> {
    @Autowired
    private SessionFactory studentSessionFactory;

    public StudentDAOImpl() {

    }

    public StudentDAOImpl(@Qualifier("studentSessionFactory") SessionFactory sessionFactory) {
        this.studentSessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Student> list() {
        @SuppressWarnings("unchecked")
        List<Student> listStudent = (List<Student>) studentSessionFactory.getCurrentSession()
                .createCriteria(Student.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listStudent;
    }

    @Override
    @Transactional
    public void saveOrUpdateRecord(Student student) {
        studentSessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    @Override
    @Transactional
    public void deleteRecord(int id) {
        Student StudentToDelete = new Student();
        StudentToDelete.setStudent_id_number(id);
        studentSessionFactory.getCurrentSession().delete(StudentToDelete);
    }

    @Override
    @Transactional
    public Student retrieveRecord(int id) {
        String hql = "from Student where student_id_number=" + id;
        Query query = studentSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Student> listStudent = (List<Student>) query.list();

        if (listStudent != null && !listStudent.isEmpty()) {
            return listStudent.get(0);
        }

        return null;
    }
//    @Override
//    @Transactional
//    public Student getLoginUser(int id, String password){
//        return null;
//    }
}
