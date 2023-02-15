DROP TABLE IF EXISTS "iot_connx_dev_db_schema"."user_session_tokens";
CREATE TABLE "iot_connx_dev_db_schema"."user_session_tokens" (
  "user_session_token_id" uuid NOT NULL,
  "user_id" uuid NOT NULL,
  "user_session_token" varchar(4000) COLLATE "pg_catalog"."default" NOT NULL,
  "expires_on" timestamptz(6) NOT NULL,
  "expired" bool NOT NULL,
  "created_on" timestamptz(6) NOT NULL,
  "updated_on" timestamptz(6) NOT NULL
)
;
ALTER TABLE "iot_connx_dev_db_schema"."user_session_tokens" OWNER TO "iot_connx_dev_user";
