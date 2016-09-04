package br.edu.scalability.subsidy.socialsecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
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

	@Autowired
	private Session session;
	// private Cluster cluster;
	// private CqlOperations template;

	@RequestMapping(value = "/small/name/{name}")
	public List<SocialProgram> findByName(@PathVariable String name) {
		String cql = "select * from scalability.bfs where nome_beneficiario = ?";
		PreparedStatement pstmt = session.prepare(cql);
		BoundStatement bstmt = pstmt.bind(name);
		ResultSet results = session.execute(bstmt);
		for (Row row : results) {
			final String data = row.getString(0);
			final String setor = row.getString(1);
			final String municipio = row.getString(2);
			System.out.format("%s %s %s\n", data, setor, municipio);
		}
		return null;
	}

	@RequestMapping("/small/city/{city}")
	public List<SocialProgram> findByCity(@PathVariable String city) {
		String cql = "select * from scalability.bfs where nome_municipio = ?";
		PreparedStatement pstmt = session.prepare(cql);
		BoundStatement bstmt = pstmt.bind(city);
		ResultSet results = session.execute(bstmt);
		for (Row row : results) {
			final String data = row.getString(0);
			final String setor = row.getString(1);
			final String municipio = row.getString(2);
			System.out.format("%s %s %s\n", data, setor, municipio);
		}
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
