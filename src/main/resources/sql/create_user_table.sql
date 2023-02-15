-- Table: iot_connx_dev_db_schema.users

-- DROP TABLE IF EXISTS iot_connx_dev_db_schema.users;

CREATE TABLE IF NOT EXISTS iot_connx_dev_db_schema.users
(
    user_id uuid NOT NULL,
    user_email character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_first_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    user_last_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    created_on timestamp(6) with time zone NOT NULL,
    updated_on timestamp(6) with time zone,
    user_deleted_flag boolean NOT NULL DEFAULT false,
    password character varying COLLATE pg_catalog."default",
    uid character varying COLLATE pg_catalog."default" NOT NULL,
    user_role_id uuid
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS iot_connx_dev_db_schema.users
    OWNER to iot_connx_dev_user;