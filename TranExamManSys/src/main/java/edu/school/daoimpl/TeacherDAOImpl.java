package edu.school.daoimpl;

/**
 * Created by ziwuitu on 10/14/16.
 */

import java.util.List;

import edu.school.dao.DAO;
import edu.school.models.Student;
import edu.school.models.Teacher;
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
public class TeacherDAOImpl implements DAO<Teacher> {
    @Autowired
    private SessionFactory teacherSessionFactory;

    public TeacherDAOImpl() {

    }

    public TeacherDAOImpl(SessionFactory sessionFactory) {
        this.teacherSessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Teacher> list() {
        @SuppressWarnings("unchecked")
        List<Teacher> listTeacher = (List<Teacher>) teacherSessionFactory.getCurrentSession()
                .createCriteria(Teacher.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listTeacher;
    }

    @Override
    @Transactional
    public void saveOrUpdateRecord(@Qualifier("teacherSessionFactory") Teacher Teacher) {
        teacherSessionFactory.getCurrentSession().saveOrUpdate(Teacher);
    }

    @Override
    @Transactional
    public void deleteRecord(int id) {
        Teacher TeacherToDelete = new Teacher();
        TeacherToDelete.setteacher_id(id);
        teacherSessionFactory.getCurrentSession().delete(TeacherToDelete);
    }

    @Override
    @Transactional
    public Teacher retrieveRecord(int id) {
        String hql = "from Teacher where teacher_id=" + id;
        Query query = teacherSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Teacher> listTeacher = (List<Teacher>) query.list();

        if (listTeacher != null && !listTeacher.isEmpty()) {
            return listTeacher.get(0);
        }

        return null;
    }
//    @Override
//    @Transactional
//    public Teacher getLoginUser(int id, String password){
//        return null;
//    }
}
