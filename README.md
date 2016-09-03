Projeto para realizar testes de escabilidade para ambientes de computação em nuvem.

CREATE KEYSPACE scalability WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};


CREATE TABLE BF (ID TIMEUUID,
                 UF TEXT,
                 CODIGO_MUNICIPIO TEXT,
                 NOME_MUNICIPIO TEXT,
                 NOME_BENEFICIARIO TEXT,
                 VALOR_PAGO FLOAT,
                 MES_ANO TEXT,
                 PRIMARY KEY (ID, VALOR_PAGO));
                 
                 
CREATE TABLE BFS (ID TIMEUUID,
                 UF TEXT,
                 CODIGO_MUNICIPIO TEXT,
                 NOME_MUNICIPIO TEXT,
                 NOME_BENEFICIARIO TEXT,
                 VALOR_PAGO FLOAT,
                 MES_ANO TEXT,
                 PRIMARY KEY (ID, VALOR_PAGO));