package edu.school.daoimpl;

import edu.school.dao.DAO;
import edu.school.models.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ziwuitu on 10/26/16.
 *
 */

@Component
public class UserDAOImpl implements DAO<User> {


    @Autowired
    private SessionFactory userSessionFactory;
    public UserDAOImpl(){

    }
    public UserDAOImpl(@Qualifier("userSessionFactory") SessionFactory sessionFactory){
        this.userSessionFactory = sessionFactory;
    }
    @Override
    @Transactional
    public List<User> list() {
        @SuppressWarnings("unchecked")
        List<User> listgrade = (List<User>) userSessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listgrade;
    }
    @Override
    @Transactional
    public void saveOrUpdateRecord(User User) {

        userSessionFactory.getCurrentSession().saveOrUpdate(User);
        //sessionFactory.getCurrentSession().saveOrUpdate(subject);
    }

    @Override
    @Transactional
    public void deleteRecord(int grade_section_id) {
//        User UserToDelete = new User();
//        UserToDelete.setUser_name(grade_section_id);
//        //UserToDelete.setUser(grade_section_id);
//        userSessionFactory.getCurrentSession().delete(UserToDelete);
    }

    @Override
    @Transactional
    public  User retrieveRecord(int id){
        String hql = "from User where user_id =" + id;
        Query query = userSessionFactory.getCurrentSession().createQuery(hql);

        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) query.list();

        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }

        return null;
    }
//    @Override
    @Transactional
    public User getLoginUser(int id, String password) {
        String hql = "from User where user_id=:id AND password=:password";
        Query query = userSessionFactory.getCurrentSession().createQuery(hql);
        query.setParameter("id",id).setParameter("password", password);

        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) query.list();

        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }

        return null;
    }

    
}
