package com.retors.config;
 
import java.util.Properties;
 
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.SharedEntityManagerBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
 
 
@Configuration
/*@EnableJpaRepositories(basePackages = "com.websystique.springboot.repositories",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")*/
@PropertySource("dbconfig.properties")
public class HibernateJpaConfig {
    @Value("${datasource.url}")
    private String dbUrl;
    
    @Value("${datasource.driverClass}")
    private String driverClass;
    
    @Value("${datasource.username}")
    private String username;
    
    @Value("${datasource.password}")
    private String password;
    
    @Value("${datasource.intialSize}")
    private int intialSize;
    
    @Value("${datasource.maxActive}")
    private int maxActive;
    
    @Value("${datasource.hibernateDailect}")
    private String hibernateDailect;
    
    @Value("${datasource.hbm2ddl}")
    private String hbm2ddl;
    
    @Value("${datasource.showSql}")
    private String showSql;
    
    @Value("${datasource.batch_size}")
    private int batch_size;
 
    
 
    /*
     * Configure  pooled DataSource.
     */
    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    	dataSource.setUrl(dbUrl);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	dataSource.setDriverClassName(driverClass);
    	dataSource.setInitialSize(intialSize);
    	dataSource.setMaxActive(maxActive);
    	dataSource.setRemoveAbandoned(true);
        return dataSource;
    }
 
    /*
     * Entity Manager Factory setup.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[] { "com.retors.model" });
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(jpaProperties());
        return factoryBean;
    }
 
    /*
     * Provider specific adapter.
     */
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        return hibernateJpaVendorAdapter;
    }
 
    /*
     * Here you can specify any provider specific properties.
     */
    private Properties jpaProperties() {
    	Properties properties = new Properties();
    	properties.put("hibernate.dialect", hibernateDailect);
    	properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
    	properties.put("hibernate.show_sql", showSql);
    	properties.put("hibernate.jdbc.batch_size", batch_size);
    	return properties;
    }
 
    @Bean
    @Autowired
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf);
        return txManager;
    }
    @Bean
    public SharedEntityManagerBean setEntityManager(EntityManagerFactory emf){
    	SharedEntityManagerBean entityManagerBean = new SharedEntityManagerBean(); 
    	entityManagerBean.setEntityManagerFactory(emf);
    	return entityManagerBean;
    }
    
 
}