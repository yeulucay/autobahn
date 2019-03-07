INSERT INTO end_point_type (id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES(1,'2018-12-16 12:00:00',0,NULL,NULL,'KAFKA','Kafka Instance');
INSERT INTO end_point_type (id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES(2,'2018-12-16 12:00:00',0,NULL,NULL,'BUFFER','Address and Port');

INSERT INTO project(id,created_at,deleted,deleted_at,last_updated_at,description,name) VALUES(1,'2018-12-16 12:00:00',0,NULL,NULL,'First Project','Project 1');

INSERT INTO data_type(id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES (1,'2018-12-16 12:00:00', 0, NULL, NULL, 'JSON','JSON Content');
INSERT INTO data_type(id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES (2,'2018-12-16 12:00:00', 0, NULL, NULL, 'XML','XML Content');
INSERT INTO data_type(id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES (3,'2018-12-16 12:00:00', 0, NULL, NULL, 'BYTE_ARRAY','Byte Array Content');

INSERT INTO end_point (id,created_at,deleted,deleted_at,last_updated_at,address,name,port,end_point_type_id,project_id) VALUES (1,'2018-12-16 12:00:00',0,NULL,NULL,'127.0.0.1','TEST','1234',1,1);

INSERT INTO enrichment_source_type (id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES (1,'2018-12-16 12:00:00',0,null,null,'MYSQL','MySql Database');
INSERT INTO enrichment_source_type (id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES (2,'2018-12-16 12:00:00',0,null,null,'POSTGRESQL','PostgreSql Database');

INSERT INTO final_storage_type (id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES (1,'2018-12-16 12:00:00',0,null,null,'CASSANDRA','Apache Cassandra');
INSERT INTO final_storage_type (id,created_at,deleted,deleted_at,last_updated_at,code,description) VALUES (2,'2018-12-16 12:00:00',0,null,null,'ELASTIC_SEARCH','Elastic Search');

INSERT INTO final_storage (id,created_at,deleted,deleted_at,last_updated_at,address,description,name,password,port,schema_name,username,final_storage_type_id,project_id) VALUES (1,'2018-12-16 12:00:00',0,NULL,NULL,'127.0.0.1','Test Desc','Test','123456','1234','test','user1',1,1);

INSERT INTO enrichment_source (id,created_at,deleted,deleted_at,last_updated_at,address,database_name,description,name,password,port,username,project_id,type_id, schema_name) VALUES (1,'2018-12-16 12:00:00',0,null,null,'localhost','autobahn','description 1','name 1','Admin12345!','3306','root',1,1, 'public');
INSERT INTO enrichment_source (id,created_at,deleted,deleted_at,last_updated_at,address,database_name,description,name,password,port,username,project_id,type_id, schema_name) VALUES (2,'2018-12-16 12:00:00',0,null,null,'localhost','deneme','description 1','name 1','','5432','postgres',1,2, 'public');

INSERT INTO enrichment (id,name,created_at,deleted,deleted_at,last_updated_at,enrichment_rules,end_point_id,enrichment_source_id,final_storage_id,project_id) VALUES (1,'Enrichment 1','2018-12-16 12:00:00',0,NULL,NULL,'{"id":1}',1,1,1,1);

