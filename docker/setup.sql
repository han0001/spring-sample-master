-- create the users for each database
CREATE DATABASE IF NOT EXISTS sample_mysql;
CREATE USER 'sample_user'@'%' IDENTIFIED BY 'sample_userpw';
GRANT CREATE, ALTER, INDEX, LOCK TABLES, REFERENCES, UPDATE, DELETE, DROP, SELECT, INSERT ON `sample_mysql`.* TO 'sample_user'@'%';

create table tb_sample(
	sample_id bigint(20) AUTO_INCREMENT,
	name varchar(20),
	primary key (sample_id)
);
