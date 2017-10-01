package br.edu.scalability;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created by rodrigopinheiro on 8/27/16.
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class Application {

	private static Logger logger = Logger.getLogger(Application.class);
	private Session session;
	private Cluster cluster;
	private String contactPoints = System.getProperty("servidor.cassandra");
	private String user = System.getProperty("usuario.cassandra");
	private String pwd = System.getProperty("senha.cassandra");
	private int port = 9042;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean(destroyMethod = "close")
	public Session session() throws Exception {
		if (session == null) {
			session = cluster().connect();
			logger.info("Session connect");
		}
		return session;
	}

	@Bean(destroyMethod = "close")
	public Cluster cluster() throws Exception {
		if (cluster == null) {
			logger.info("Servidor Cassandra: " + contactPoints);
			cluster = Cluster.builder().addContactPoints(contactPoints).withPort(port).withCredentials(user, pwd)
					.build();
			logger.info("Build cluster");
		}
		return cluster;
	}

	// protected SpringApplicationBuilder configure(SpringApplicationBuilder
	// application) {
	// Application obj = new Application();
	// @SuppressWarnings("resource")
	// ConfigurableApplicationContext applicationContext = new
	// ClassPathXmlApplicationContext(
	// "META-INF/spring/applicationContext.xml");
	// applicationContext.registerShutdownHook();
	// applicationContext.getBeanFactory().autowireBeanProperties(obj,
	// AutowireCapableBeanFactory.AUTOWIRE_NO, false);
	// return application.sources(Application.class);
	// }
}
