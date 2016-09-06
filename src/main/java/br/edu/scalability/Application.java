package br.edu.scalability;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

/**
 * Created by rodrigopinheiro on 8/27/16.
 */
@EnableAutoConfiguration
@SpringBootApplication
public class Application {

	private static Logger logger = Logger.getLogger(Application.class);
	private Session session;
	private Cluster cluster;
	private String contactPoints = System.getProperty("servidor.cassandra");
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
			cluster = Cluster.builder().addContactPoints(contactPoints).withPort(port).build();
			logger.info("Build cluster");
		}
		return cluster;
	}

}
