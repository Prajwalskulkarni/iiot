-- Database: iot_connx_dev_db

-- DROP DATABASE IF EXISTS iot_connx_dev_db;

CREATE DATABASE iot_connx_dev_db
    WITH
    OWNER = iot_connx_dev_user
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;