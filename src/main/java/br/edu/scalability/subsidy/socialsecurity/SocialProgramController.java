package br.edu.scalability.subsidy.socialsecurity;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

/**
 * 
 * @author marco Aug 30, 2016 Usar a doc:
 *         https://github.com/spring-projects/spring-data-cassandra<br />
 *         - Pesquisa por nome do beneficiário;<br />
 *         - Pesquisa por cidade;<br />
 *         - Maior valor pago;<br />
 *         - Menor valor pago;<br />
 *         - Média dos valores pagos.<br />
 */
@RestController
@RequestMapping("/socialprogram")
public class SocialProgramController {

	// @Autowired
	// private CqlOperations template;

	@RequestMapping(value = "/small/name/{name}")
	public List<SocialProgram> findByName(@PathVariable String name) {

		String ipCluster = "127.0.0.1";
		Cluster cluster = Cluster.builder().addContactPoint(ipCluster).build();
		Session session = cluster.connect("scalability");
		//
		String cql = "select * from SocialProgramSmall where name like '" + name + "'";
		ResultSet results = session.execute(cql);
		for (Row row : results) {
			final String data = row.getString("dataOrigem");
			final String setor = row.getString("setor");
			final String municipio = row.getString("municipio");
			System.out.format("%s %s %s\n", data, setor, municipio);
		}
		cluster.close();
		return null;
		// return template.queryForList(cql, SocialProgram.class);
	}

	@RequestMapping("/small/city/{city}")
	public List<SocialProgram> findByCity(@PathVariable String city) {
		String cql = "select * from SocialProgram where city = '" + city + "'";
		return null;
	}

	@RequestMapping("/small/biggervalue/{city}")
	public List<SocialProgram> findBiggerByCity(@PathVariable String city) {
		String cql = "select max(value) from SocialProgram where city = '" + city + "'";
		return null;
	}

	@RequestMapping("/small/smallervalue/{city}")
	public List<SocialProgram> findSmallerByCity(@PathVariable String city) {
		String cql = "select min(value) from SocialProgram where city = '" + city + "'";
		return null;
	}

	@RequestMapping("/small/averagevalue/{city}")
	public List<SocialProgram> findAverageByCity(@PathVariable String city) {
		String cql = "select avg(value) from SocialProgram where city = '" + city + "'";
		return null;
	}

}
