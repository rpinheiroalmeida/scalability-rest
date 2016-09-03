package br.edu.scalability.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

///**
// * @author Mark Paluch
// */
@Configuration
@EnableAutoConfiguration
class CassandraConfiguration {

    @Configuration
    @EnableCassandraRepositories
    static class CassandraConfig extends AbstractCassandraConfiguration {

        @Override
        public String getKeyspaceName() {
            return "bmfbovespa";
        }

        @Override
        public SchemaAction getSchemaAction() {
            return SchemaAction.RECREATE;
        }
    }
}