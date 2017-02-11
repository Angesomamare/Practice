package edu.school.daoimpl;

import edu.school.dao.GenericDAO;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by mezgeboa on 10/31/2016.
 */
@SuppressWarnings("unchecked")
@Repository
@Component
//@Transactional(propagation = Propagation.MANDATORY)
public  class GenericDAOImpl<T, K extends Serializable>  implements GenericDAO<T, K> {

    @Autowired
    private SessionFactory sessionFactory;

    public GenericDAOImpl(){

    }

    public GenericDAOImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<T> list(final Class<T> entity){

        @SuppressWarnings("unchecked")
        List<T> listall = (List<T>) sessionFactory.getCurrentSession()
                .createCriteria(entity)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listall;

    }
    @Override
    @Transactional
    public void saveOrUpdateRecord(final T t) {

        sessionFactory.getCurrentSession().saveOrUpdate(t);
        //sessionFactory.getCurrentSession().clear();
        //sessionFactory.getCurrentSession().flush();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public void deleteRecord(final T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    @Transactional

    public T retrieveRecord (final Class<T> entity, final K key) {
        //@SuppressWarnings("unchecked")
        return (T) sessionFactory.getCurrentSession().get(entity, key);
    }


}
