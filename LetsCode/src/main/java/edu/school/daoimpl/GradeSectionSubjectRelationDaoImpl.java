package edu.school.daoimpl;

import edu.school.dao.DAO;
import edu.school.models.GradeSectionSubjectRelation;

import edu.school.models.Student;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mezgeboa on 10/26/2016.
 */
public class GradeSectionSubjectRelationDaoImpl implements DAO<GradeSectionSubjectRelation> {
    @Autowired
    private SessionFactory gradeSectionSubjectRelationSessionFactory;
    private GradeSectionSubjectRelationDaoImpl(){

    }


    public GradeSectionSubjectRelationDaoImpl(@Qualifier("gradeSectionSubjectRelationSessionFactory") SessionFactory sessionFactory) {
        this.gradeSectionSubjectRelationSessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<GradeSectionSubjectRelation> list() {
        @SuppressWarnings("unchecked")
        List<GradeSectionSubjectRelation> listGradeSectionSubjectRelation = (List<GradeSectionSubjectRelation>) gradeSectionSubjectRelationSessionFactory.getCurrentSession()
                .createCriteria(GradeSectionSubjectRelation.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listGradeSectionSubjectRelation;
    }

    @Override
    @Transactional
    public void saveOrUpdateRecord(GradeSectionSubjectRelation GradeSectionSubjectRelation) {
        gradeSectionSubjectRelationSessionFactory.getCurrentSession().saveOrUpdate(GradeSectionSubjectRelation);
    }

    @Override
    @Transactional
    public void deleteRecord(int id) {
        GradeSectionSubjectRelation GradeSectionSubjectRelationToDelete = new GradeSectionSubjectRelation();
        GradeSectionSubjectRelationToDelete.setGrade_section_subject_id(id);
        gradeSectionSubjectRelationSessionFactory.getCurrentSession().delete(GradeSectionSubjectRelationToDelete);
    }

    @Override
    @Transactional
    public GradeSectionSubjectRelation retrieveRecord(int id) {
        String hql = "from GradeSectionSubjectRelation where grade_section_subject_id=" + id;
        Query query = gradeSectionSubjectRelationSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<GradeSectionSubjectRelation> listGradeSectionSubjectRelation = (List<GradeSectionSubjectRelation>) query.list();

        if (listGradeSectionSubjectRelation != null && !listGradeSectionSubjectRelation.isEmpty()) {
            return listGradeSectionSubjectRelation.get(0);
        }

        return null;
    }
//    @Override
//    @Transactional
//    public GradeSectionSubjectRelation getLoginUser(int id, String password){
//        return null;
//    }

}
