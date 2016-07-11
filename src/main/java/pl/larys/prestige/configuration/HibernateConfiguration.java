package pl.larys.prestige.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by piotr on 01.07.16.
 */
@Configuration
@EnableJpaRepositories("pl.larys.prestige.repository")
@EnableTransactionManagement
@ComponentScan({ "pl.larys.prestige.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

    @Autowired
    private Environment environment;

//    @Bean
//    public LocalSessionFactoryBean sessionFactoryBean() {
//        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
//        sessionFactoryBean.setDataSource(dataSource());
//        sessionFactoryBean.setPackagesToScan(new String[] {"pl.larys.prestige.model"});
//        sessionFactoryBean.setHibernateProperties(hibernateProperties());
//        return sessionFactoryBean;
//    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("pl.larys.prestige.model");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(hibernateProperties());
        factory.afterPropertiesSet();

        return factory.getObject();
    }

    @Bean
    public DataSource dataSource() {

        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase dataSource = builder.setType(EmbeddedDatabaseType.HSQL).build();

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
//        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
//        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        //properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        //properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        //properties.put("hibernate.connection.CharSet", environment.getRequiredProperty("hibernate.connection.CharSet"));
        //properties.put("hibernate.connection.characterEncoding", environment.getRequiredProperty("hibernate.connection.characterEncoding"));
        //properties.put("hibernate.connection.useUnicode", environment.getRequiredProperty("hibernate.connection.useUnicode"));

        return properties;
    }

//    @Bean
//    @Autowired
//    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager txManager = new HibernateTransactionManager();
//        txManager.setSessionFactory(sessionFactory);
//        return txManager;
//    }

    @Bean
    public PlatformTransactionManager transactionManager() {

        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

//    @Bean
//    public URI dbUrl() throws URISyntaxException {
//        URI dbUrl = new URI("#{systemEnvironment['DATABASE_URL']}");
//        return dbUrl;
//    }

}
