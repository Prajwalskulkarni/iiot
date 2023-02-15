-- Role: iot_connx_dev_user
-- DROP ROLE IF EXISTS iot_connx_dev_user;

CREATE ROLE iot_connx_dev_user WITH
  LOGIN
  SUPERUSER
  INHERIT
  CREATEDB
  CREATEROLE
  NOREPLICATION
  ENCRYPTED PASSWORD 'md5c1e8d5b381de8ac1c0cfd4120b8de079';