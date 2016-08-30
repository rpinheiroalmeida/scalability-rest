package br.edu.scalability.utilitario;


/**
 * Utility to retrieve the Cassandra release version.
 *
 * @author Mark Paluch
 */
//@UtilityClass
//public class CassandraVersion {
//
//    /**
//     * Retrieve the Cassandra release version.
//     *
//     * @param session must not be {@literal null}.
//     * @return the release {@link Version}.
//     */
//    public static ClassFile.Version getReleaseVersion(Session session) {
//
//        Assert.notNull(session, "Session must not be null");
//
//        ResultSet resultSet = session.execute("SELECT release_version FROM system.local;");
//        Row row = resultSet.one();
//
//        return Version.parse(row.getString(0));
//    }
//}