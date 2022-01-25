SET MODE PostgreSQL;
CREATE TABLE IF NOT EXISTS news (
 serialNo int PRIMARY KEY auto_increment,
 title VARCHAR,
 category VARCHAR,
 date VARCHAR,
 body VARCHAR,
 reporter VARCHAR);

 CREATE TABLE IF NOT EXISTS users (
 username VARCHAR PRIMARY KEY,
 fullname VARCHAR,
 password VARCHAR
 );