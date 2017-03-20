package edu.school.daoimpl;

import edu.school.dao.DAO;
import edu.school.models.GradeSection;
import edu.school.models.Student;
import edu.school.models.Subject;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by mezgeboa on 10/21/2016.
 */
@Component
public class GradeSectionDAOImpl implements DAO<GradeSection> {
    @Autowired
    private SessionFactory gradeSessionFactory;
    public GradeSectionDAOImpl(){

    }
    public GradeSectionDAOImpl(SessionFactory sessionFactory){
        this.gradeSessionFactory = sessionFactory;
    }
    @Override
    @Transactional
    public List<GradeSection> list() {
        @SuppressWarnings("unchecked")
        List<GradeSection> listgrade = (List<GradeSection>) gradeSessionFactory.getCurrentSession()
                .createCriteria(GradeSection.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listgrade;
    }
    @Override
    @Transactional
    public void saveOrUpdateRecord(GradeSection gradesection) {
        gradeSessionFactory.getCurrentSession().saveOrUpdate(gradesection);
        //sessionFactory.getCurrentSession().saveOrUpdate(subject);
    }

    @Override
    @Transactional
    public void deleteRecord(int grade_section_id) {
        GradeSection gradeSectionToDelete = new GradeSection();
        gradeSectionToDelete.setGrade_section_id(grade_section_id);
        //gradeSectionToDelete.setGradesection(grade_section_id);
        gradeSessionFactory.getCurrentSession().delete(gradeSectionToDelete);
    }

    @Override
    @Transactional
    public GradeSection retrieveRecord(int id) {
        String hql = "from GradeSection where grade_section_id=" + id;
        Query query = gradeSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<GradeSection> listGradeSection = (List<GradeSection>) query.list();

        if (listGradeSection != null && !listGradeSection.isEmpty()) {
            return listGradeSection.get(0);
        }

        return null;
    }
//    @Override
//    @Transactional
//    public GradeSection getLoginUser(int id, String password){
//        return null;
//    }


}
