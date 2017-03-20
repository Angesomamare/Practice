package edu.school.daoimpl;

import edu.school.dao.DAO;

/**
 * Created by mezgeboa on 10/17/2016.
 */
import java.util.List;

import edu.school.models.Student;
import edu.school.models.Subject;
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
public class SubjectDaoImpl implements DAO<Subject>{
   @Autowired
    private SessionFactory subjectSessionFactory;

    public SubjectDaoImpl(){

    }
    public SubjectDaoImpl(@Qualifier("subjectSessionFactory") SessionFactory sessionFactory){
        this.subjectSessionFactory = sessionFactory;

    }

    @Override
    @Transactional
    public List<Subject> list() {
        @SuppressWarnings("unchecked")
        List<Subject> listSubject = (List<Subject>) subjectSessionFactory.getCurrentSession()
                .createCriteria(Subject.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listSubject;
    }
    @Override
    @Transactional
    public void saveOrUpdateRecord(Subject subject) {
        subjectSessionFactory.getCurrentSession().saveOrUpdate(subject);
        //sessionFactory.getCurrentSession().saveOrUpdate(subject);
    }

    @Override
    @Transactional
    public void deleteRecord(int subject_id) {
        Subject subjectToDelete = new Subject();
        subjectToDelete.setSubject_id(subject_id);
        subjectSessionFactory.getCurrentSession().delete(subjectToDelete);
    }

    @Override
    @Transactional
    public Subject retrieveRecord(int id) {
        String hql = "from subject where subject_id=" + id;
        Query query = subjectSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<Subject> listSubject = (List<Subject>) query.list();

        if (listSubject != null && !listSubject.isEmpty()) {
            return listSubject.get(0);
        }

        return null;
    }
//    @Override
//    @Transactional
//    public Subject getLoginUser(int id, String password){
//        return null;
//    }

}
