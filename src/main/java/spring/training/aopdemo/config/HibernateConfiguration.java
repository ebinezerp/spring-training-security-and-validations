package spring.training.aopdemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "spring.training.aopdemo")
@EnableTransactionManagement
public class HibernateConfiguration {

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springtraining");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;

	}

	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(getDataSource());
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("spring.training.aopdemo.model");
		return builder.buildSessionFactory();
	}

	public Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hiberate.format_sql", "true");
		return properties;
	}

	@Bean
	public HibernateTransactionManager getHibernateTransactionManagment(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}

}
