package edu.school.configuration;

/**
 * Created by ziwuitu on 10/7/16.
 */

import javax.sql.DataSource;

import edu.school.dao.GenericDAO;
import edu.school.daoimpl.*;
import edu.school.models.*;
import org.apache.commons.dbcp.BasicDataSource;
//import org.assertj.core.groups.Properties;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

@Configuration
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = "edu.school.*")
@EnableTransactionManagement
@EnableWebMvc
public class SpringMVCAndHibernateConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/images/");
    }


    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/dynamic/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mydb");
        dataSource.setUsername("root");
        dataSource.setPassword("Alganesh25");

        return dataSource;
    }

    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);

        sessionBuilder.addAnnotatedClasses(Student.class, Teacher.class, Subject.class, GradeSection.class,

                StudentGradeSectionRelation.class, StudentSubjectRelation.class, GradeSectionSubjectRelation.class, User.class,
                TeacherGradeSectionSubjectRelation.class, TeacherGradeSectionRelation.class, TeacherSubjectRelation.class,
                        TeacherGradeSectionRelation.class, TeacherStudentRelation.class);


        return sessionBuilder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(
            SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(
                sessionFactory);

        return transactionManager;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/search").setViewName("search");
//        registry.addViewController("/authorizeLogin").setViewName("login");
    }


//
//    @Autowired
//    @Bean(name = "studentDao")
//    public GenericDAO getStudentDAO(SessionFactory sessionFactory) {
//        return new GenericDaoImpl(sessionFactory);
//    }
//
//    @Autowired
//    @Bean(name = "teacherDao")
//    public GenericDAO getTeacherDAO(SessionFactory sessionFactory) {
//        return new GenericDaoImpl(sessionFactory);
//    }
//
//    @Autowired
//    @Bean(name="subjectDao")
//    public GenericDAO getSubjectDao(SessionFactory sessionFactory){return  new GenericDaoImpl(sessionFactory); }
//
//    @Autowired
//    @Bean(name="gradesectionDao")
//    public GenericDAO getGradesectionDao(SessionFactory sessionFactory){return  new GenericDaoImpl(sessionFactory); }
//
//    @Autowired
//    @Bean(name="studentGradeSectionRelationDao")
//    public GenericDAO getStudentGradeSectionRelationDao(SessionFactory sessionFactory){return  new GenericDaoImpl(sessionFactory); }
//
//    @Autowired
//
//    @Bean(name="studentSubjectRelationDao")
//    public GenericDAO getStudentSubjectRelationDao(SessionFactory sessionFactory){return  new GenericDaoImpl(sessionFactory); }
//
//    @Autowired
//    @Bean(name="gradeSectionSubjectRelationDao")
//    public GenericDAO getGradeSectionSubjectRelationDao(SessionFactory sessionFactory){return  new GenericDaoImpl(sessionFactory); }
//
//    @Autowired
//    @Bean(name="teacherGradeSectionSubjectRelationDao")
//    public GenericDAO getTeacherGradeSectionSubjectRelationDao(SessionFactory sessionFactory){return new GenericDaoImpl(sessionFactory);}

    @Autowired
    @Bean(name="userDao")
    public UserDAOImpl getUserDao(SessionFactory sessionFactory){return  new UserDAOImpl(sessionFactory); }

    @Autowired
    @Bean (name = "GenericDao")

    public GenericDAO getGenericDao(SessionFactory sessionFactory){return new GenericDAOImpl(sessionFactory);}

//    @Autowired
//    @Bean(name="dao")
//    public TempInterface getDao(SessionFactory sessionFactory){
//
//        return  new GenericDAOImpl();
//
//    }

}