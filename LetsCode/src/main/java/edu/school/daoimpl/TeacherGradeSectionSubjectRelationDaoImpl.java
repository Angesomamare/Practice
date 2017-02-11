package edu.school.daoimpl;

import edu.school.dao.DAO;

import edu.school.models.Subject;
import edu.school.models.TeacherGradeSectionSubjectRelation;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mezgeboa on 10/29/2016.
 */
@Component
public class TeacherGradeSectionSubjectRelationDaoImpl implements DAO<TeacherGradeSectionSubjectRelation> {
    @Autowired
    private SessionFactory teacherGradeSectionSubjectRelationSessionFactory;
    public TeacherGradeSectionSubjectRelationDaoImpl (){

    }
    public TeacherGradeSectionSubjectRelationDaoImpl(@Qualifier("teacherGradeSectionSubjectRelationSessionFactory") SessionFactory sessionFactory){
        this.teacherGradeSectionSubjectRelationSessionFactory= sessionFactory;
    }


    @Override
    @Transactional
    public List<TeacherGradeSectionSubjectRelation> list(){
        @SuppressWarnings("unchecked")
        List<TeacherGradeSectionSubjectRelation> listTeacherGradeSectionSubjectRelation = (List<TeacherGradeSectionSubjectRelation>)
                teacherGradeSectionSubjectRelationSessionFactory.getCurrentSession()
                .createCriteria(TeacherGradeSectionSubjectRelation.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listTeacherGradeSectionSubjectRelation;
    }

    @Override
    @Transactional
    public void saveOrUpdateRecord(TeacherGradeSectionSubjectRelation teacherGradeSectionSubjectRelation){
        teacherGradeSectionSubjectRelationSessionFactory.getCurrentSession().saveOrUpdate(teacherGradeSectionSubjectRelation);
    }

    @Override
    @Transactional
    public void deleteRecord (int teacher_gradesection_subject_id){
        TeacherGradeSectionSubjectRelation teachersubjectToDelete = new TeacherGradeSectionSubjectRelation();
        teachersubjectToDelete.setTeacher_gradesection_subject_id(teacher_gradesection_subject_id);
        teacherGradeSectionSubjectRelationSessionFactory.getCurrentSession().delete(teachersubjectToDelete);
    }

    @Override
    @Transactional
    public TeacherGradeSectionSubjectRelation retrieveRecord(int id) {
        String hql = "from teacherGradeSectionSubjectRelation where teacher_gradesection_subject_id=" + id;
        Query query = teacherGradeSectionSubjectRelationSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<TeacherGradeSectionSubjectRelation> listTeacherGradeSubject = (List<TeacherGradeSectionSubjectRelation>) query.list();

        if (listTeacherGradeSubject != null && !listTeacherGradeSubject.isEmpty()) {
            return listTeacherGradeSubject.get(0);
        }

        return null;
    }



}
