package edu.school.dao;

import org.hibernate.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by mezgeboa on 10/31/2016.
 */
public interface GenericDAO<T, K extends Serializable> {
    public List<T> list(Class<T> entity);


    public void saveOrUpdateRecord(final T t);

    public T retrieveRecord(final Class<T> entity, final K key);


    public void deleteRecord(final T entity);



}
