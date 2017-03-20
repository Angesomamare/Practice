package edu.school.dao;

import java.util.List;

/**
 * Created by ziwuitu on 10/12/16.
 */


public interface DAO <T> {


    public List<T> list();

    public T retrieveRecord(int id);

    public void saveOrUpdateRecord(T t);

    public void deleteRecord(int id);
//    public T getLoginUser(int id, String password);



}
