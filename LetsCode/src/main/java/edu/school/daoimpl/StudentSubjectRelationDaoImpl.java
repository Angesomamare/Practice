package edu.school.daoimpl;

import edu.school.dao.DAO;
import edu.school.models.Student;
import edu.school.models.StudentSubjectRelation;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by mezgeboa on 10/24/2016.
 */
@Component
public class StudentSubjectRelationDaoImpl implements DAO<StudentSubjectRelation> {
    @Autowired
    private SessionFactory studentSubjectRelationSessionFactory;
    public  StudentSubjectRelationDaoImpl(){
            }
    public StudentSubjectRelationDaoImpl(SessionFactory sessionFactory){
        this.studentSubjectRelationSessionFactory = sessionFactory;
    }
    @Override
    @Transactional
    public List<StudentSubjectRelation> list() {
        @SuppressWarnings("unchecked")
        List<StudentSubjectRelation> listStudentSubjectRelation = (List<StudentSubjectRelation>) studentSubjectRelationSessionFactory.getCurrentSession()
                .createCriteria(StudentSubjectRelation.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listStudentSubjectRelation;
    }
    @Override
    @Transactional
    public void saveOrUpdateRecord(StudentSubjectRelation StudentSubjectRelation) {
        studentSubjectRelationSessionFactory.getCurrentSession().saveOrUpdate(StudentSubjectRelation);
    }

    @Override
    @Transactional
    public void deleteRecord(int id) {
        StudentSubjectRelation StudentSubjectRelationToDelete = new StudentSubjectRelation();
        StudentSubjectRelationToDelete.setStudent_subject_id(id);
        studentSubjectRelationSessionFactory.getCurrentSession().delete(StudentSubjectRelationToDelete);
    }

    @Override
    @Transactional
    public StudentSubjectRelation retrieveRecord(int id) {
        String hql = "from StudentSubjectRelation where student_subject_id=" + id;
        Query query = studentSubjectRelationSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<StudentSubjectRelation> listStudentSubjectRelation = (List<StudentSubjectRelation>) query.list();

        if (listStudentSubjectRelation != null && !listStudentSubjectRelation.isEmpty()) {
            return listStudentSubjectRelation.get(0);
        }

        return null;
    }
//    @Override
//    @Transactional
//    public StudentSubjectRelation getLoginUser(int id, String password){
//        return null;
//    }


}
