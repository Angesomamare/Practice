package edu.school.daoimpl;

import edu.school.dao.DAO;
import edu.school.models.Student;
import edu.school.models.StudentGradeSectionRelation;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Created by ziwuitu on 10/22/16.
 */
public class StudentGradeSectionRelationDAOImpl implements DAO<StudentGradeSectionRelation> {

    @Autowired
    private SessionFactory studentGradeSectionRelationSessionFactory;

    public StudentGradeSectionRelationDAOImpl() {

    }

    public StudentGradeSectionRelationDAOImpl(@Qualifier("studentGradeSectionRelationSessionFactory") SessionFactory sessionFactory) {
        this.studentGradeSectionRelationSessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<StudentGradeSectionRelation> list() {
        @SuppressWarnings("unchecked")
        List<StudentGradeSectionRelation> listStudentGradeSectionRelation = (List<StudentGradeSectionRelation>) studentGradeSectionRelationSessionFactory.getCurrentSession()
                .createCriteria(StudentGradeSectionRelation.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listStudentGradeSectionRelation;
    }

    @Override
    @Transactional
    public void saveOrUpdateRecord(StudentGradeSectionRelation StudentGradeSectionRelation) {
        studentGradeSectionRelationSessionFactory.getCurrentSession().saveOrUpdate(StudentGradeSectionRelation);
    }

    @Override
    @Transactional
    public void deleteRecord(int id) {
        StudentGradeSectionRelation StudentGradeSectionRelationToDelete = new StudentGradeSectionRelation();
        StudentGradeSectionRelationToDelete.setStudent_grade_section_id(id);
        studentGradeSectionRelationSessionFactory.getCurrentSession().delete(StudentGradeSectionRelationToDelete);
    }

    @Override
    @Transactional
    public StudentGradeSectionRelation retrieveRecord(int id) {
        String hql = "from StudentGradeSectionRelation where student_grade_section_id=" + id;
        Query query = studentGradeSectionRelationSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<StudentGradeSectionRelation> listStudentGradeSectionRelation = (List<StudentGradeSectionRelation>) query.list();

        if (listStudentGradeSectionRelation != null && !listStudentGradeSectionRelation.isEmpty()) {
            return listStudentGradeSectionRelation.get(0);
        }

        return null;
    }
//    @Override
//    @Transactional
//    public StudentGradeSectionRelation getLoginUser(int id, String password){
//        return null;
//    }
}
