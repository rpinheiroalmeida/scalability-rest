Projeto para realizar testes de escabilidade para ambientes de computação em nuvem.

CREATE KEYSPACE scalability WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};


CREATE TABLE BFS (ID TIMEUUID,
                 UF TEXT,
                 CODIGO_MUNICIPIO TEXT,
                 NOME_MUNICIPIO TEXT,
                 NOME_BENEFICIARIO TEXT,
                 VALOR_PAGO FLOAT,
                 MES_ANO TEXT,
                 PRIMARY KEY (ID, NOME_MUNICIPIO));
                 
                 
CREATE TABLE SCALABILITY.BFS (ID TIMEUUID,
                 UF TEXT,
                 CODIGO_MUNICIPIO TEXT,
                 NOME_MUNICIPIO TEXT,
                 NOME_BENEFICIARIO TEXT,
                 VALOR_PAGO FLOAT,
                 MES_ANO TEXT,
                 PRIMARY KEY (ID, VALOR_PAGO));
                 
                 
truncate bf;

truncate bfs;

bin/nodetool cfstats scalability

-Djava.library.path="/home/marco/software/apache-cassandra-3.7/lib/sigar-bin/libsigar-amd64-linux.so"