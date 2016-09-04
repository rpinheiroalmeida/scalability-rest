package br.edu.scalability.utilitario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import org.apache.cassandra.config.Config;
import org.apache.cassandra.dht.Murmur3Partitioner;
import org.apache.cassandra.io.sstable.CQLSSTableWriter;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import com.datastax.driver.core.utils.UUIDs;

public class InsertBulkBolsaFamilia {
	private static Logger logger = Logger.getLogger(InsertBulkBolsaFamilia.class);

	public static void main(String[] args) throws IOException {
		String arquivo = "/home/marco/dados/bolsa-familia/entrada/201505_BolsaFamiliaFolhaPagamento.csv";
		String saida = "/home/marco/temp/scalability/bfs";
		File fSaida = new File(saida);
		FileUtils.deleteDirectory(fSaida);
		fSaida.mkdirs();
		new InsertBulkBolsaFamilia().inserir(arquivo, saida);
	}

	public void inserir(String filename, String outputDir) throws IOException {
		Config.setClientMode(true);
		CQLSSTableWriter.Builder builder = CQLSSTableWriter.builder();
		String INSERT_STMT = "INSERT INTO scalability.bfs (ID," + "UF," + "CODIGO_MUNICIPIO," + "NOME_MUNICIPIO,"
				+ "NOME_BENEFICIARIO," + "VALOR_PAGO," + "MES_ANO)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		String CREATE_TABLE = "CREATE TABLE SCALABILITY.BFS (ID UUID, UF TEXT, CODIGO_MUNICIPIO TEXT, NOME_MUNICIPIO TEXT, NOME_BENEFICIARIO TEXT, VALOR_PAGO FLOAT, MES_ANO TEXT, PRIMARY KEY (ID, NOME_MUNICIPIO));";
		builder.inDirectory(outputDir).forTable(CREATE_TABLE).using(INSERT_STMT)
				.withPartitioner(new Murmur3Partitioner());
		CQLSSTableWriter writer = builder.build();

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(filename), Charset.forName("ISO-8859-1")))) {

			reader.readLine(); // IGNORA O HEADER
			String line;
			int i = 0;
			while ((line = reader.readLine()) != null) {
				List<String> colunas = Arrays.asList(line.split("\t"));

				if (i % 1000000 == 0 && i > 0) {
					logger.info("Parcial: " + i);
				}
				float valor = Float.parseFloat(colunas.get(10).replaceAll(",", "").replaceAll("\\.00", ""));
				writer.addRow(UUIDs.random(), colunas.get(0), colunas.get(1), colunas.get(2), colunas.get(8), valor,
						colunas.get(11));
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Acabou");
		writer.close();
	}
}
