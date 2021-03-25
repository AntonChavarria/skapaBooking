CREATE DATABASE test;
CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY 'root';
GRANT ALL ON test.* TO 'root'@'localhost';