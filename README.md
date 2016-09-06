Projeto para realizar testes de escabilidade para ambientes de computação em nuvem.

CREATE KEYSPACE scalability WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};


CREATE TABLE SCALABILITY.BFS (ID TIMEUUID,
                 UF TEXT,
                 CODIGO_MUNICIPIO TEXT,
                 NOME_MUNICIPIO TEXT,
                 NIS_BENEFICIARIO TEXT,
                 NOME_BENEFICIARIO TEXT,
                 VALOR_PAGO FLOAT,
                 MES_ANO TEXT,
                 PRIMARY KEY (ID, NIS_BENEFICIARIO));
                 
                 
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

http://localhost:8080/socialprogram/small/number/00010659939255

## Bolsa família
4 CPUs i5 4g ram - 3m - 13980491
4 CPUs i5 8g ram - 2m40s - 13980491


1 mês (12/2015) 800MB

## Table loader

1m30s

bin/sstableloader -d kenobi ~/temp/scalability/bfsnis/

