package com.retors.config;
 
import java.sql.SQLException;
import java.util.Properties;
 
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import oracle.jdbc.pool.OracleDataSource;
 
 
@Configuration
/*@EnableJpaRepositories(basePackages = "com.websystique.springboot.repositories",
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef = "transactionManager")*/
@PropertySource("dbconfig.properties")
public class JpaConfiguration {
 
    @Autowired
    private Environment environment;
 
    @Value("${datasource.sampleapp.maxPoolSize:10}")
    private int maxPoolSize;
 
    /*
     * Populate SpringBoot DataSourceProperties object directly from application.yml 
     * based on prefix.Thanks to .yml, Hierachical data is mapped out of the box with matching-name
     * properties of DataSourceProperties object].
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "datasource.sampleapp")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }
 
    /*
     * Configure HikariCP pooled DataSource.
     */
    @Bean
    public DataSource dataSource() {
    	BasicDataSource dataSource = new BasicDataSource();
    /*	dataSource.setUrl(url);
    	dataSource.setUsername(username);
    	dataSource.setPassword(password);
    	dataSource.set*/
    	
      
            return null;
    }
 
    /*
     * Entity Manager Factory setup.
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws NamingException {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan(new String[] { "com.websystique.springboot.model" });
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
        properties.put("hibernate.dialect", environment.getRequiredProperty("datasource.sampleapp.hibernate.dialect"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("datasource.sampleapp.hibernate.hbm2ddl.method"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("datasource.sampleapp.hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("datasource.sampleapp.hibernate.format_sql"));
       /* if(StringUtils.isNotEmpty(environment.getRequiredProperty("datasource.sampleapp.defaultSchema"))){
            properties.put("hibernate.default_schema", environment.getRequiredProperty("datasource.sampleapp.defaultSchema"));
        }*/
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
    public EntityManager setEntityManager(EntityManagerFactory emf){
    	return emf.createEntityManager();
    }
    
 
}