
DROP SCHEMA IF EXISTS mydb CASCADE;
CREATE SCHEMA bancodedadosprojetoa3;
SET search_path TO mydb;

SET search_path TO public;

CREATE TABLE tb_phone (
  idtb_phone SERIAL PRIMARY KEY,
  ddd CHAR(2) NOT NULL,
  phone_number VARCHAR(45) NOT NULL,
  category VARCHAR(45) NOT NULL
);

CREATE TABLE tb_login (
  id_login SERIAL PRIMARY KEY,
  name VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  created_at TIMESTAMP NOT NULL,
  tb_phone_idtb_phone INT NOT NULL REFERENCES tb_phone(idtb_phone)
);

CREATE TABLE tb_role (
  id_role SERIAL PRIMARY KEY,
  name VARCHAR(45) NOT NULL
);

CREATE TABLE tb_login_has_tb_role (
  tb_login_id_login INT NOT NULL REFERENCES tb_login(id_login),
  tb_role_id_role INT NOT NULL REFERENCES tb_role(id_role),
  PRIMARY KEY (tb_login_id_login, tb_role_id_role)
);

CREATE TABLE report (
  id_report SERIAL PRIMARY KEY,
  phone VARCHAR(45) NOT NULL,
  date_report TIMESTAMP NOT NULL,
  company VARCHAR(45),
  description TEXT NOT NULL,
  tb_login_id_login INT NOT NULL REFERENCES tb_login(id_login),
  tb_phone_idtb_phone INT NOT NULL REFERENCES tb_phone(idtb_phone)
); 
