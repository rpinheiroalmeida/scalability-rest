package br.edu.scalability.configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

public class CassandraConnection {

	public void query() {
		String ipCluster = "";
		Cluster cluster = Cluster.builder().addContactPoint(ipCluster).build();
		Metadata metadata = cluster.getMetadata();
		Session session = cluster.connect("mobilidade");

		//
		// CassandraOperations cassandraOps = new CassandraTemplate(session);
		// cassandraOps.insert(new SocialProgramBuilder().build("1234567890",
		// "David", 40));

		Select s = QueryBuilder.select().from("person");
		s.where(QueryBuilder.eq("id", "1234567890"));

		// LOG.info(cassandraOps.queryForObject(s, Person.class).getId());

		// cassandraOps.truncate("person");
		//
		String sql = "SELECT * from moborigem";
		ResultSet results = session.execute(sql);
		for (Row row : results) {
			final String data = row.getString("dataOrigem");
			final String setor = row.getString("setor");
			final String municipio = row.getString("municipio");
			System.out.format("%s %s %s\n", data, setor, municipio);
		}
		cluster.close();
	}
}
