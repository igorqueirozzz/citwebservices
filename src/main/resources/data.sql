CREATE TABLE citwebservices.users (
	id BIGSERIAL PRIMARY KEY,
	employer_id BIGINT NOT NULL UNIQUE,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	user_name VARCHAR NOT NULL,
	gender VARCHAR NOT NULL,
	email VARCHAR NOT NULL UNIQUE,
	user_password VARCHAR NOT NULL,
	occupation VARCHAR NOT NULL,
	local_office VARCHAR NOT NULL,
	sector VARCHAR NOT NULL,
	access_level VARCHAR NOT NULL,
	photo_profile VARCHAR
);

CREATE TABLE citwebservices.admin (
	id BIGSERIAL PRIMARY KEY,
	employer_id BIGINT NOT NULL UNIQUE,
	cpf VARCHAR(11) NOT NULL UNIQUE,
	user_name VARCHAR NOT NULL,
	gender VARCHAR NOT NULL,
	email VARCHAR NOT NULL UNIQUE,
	user_password VARCHAR NOT NULL,
	occupation VARCHAR NOT NULL,
	local_office VARCHAR NOT NULL,
	sector VARCHAR NOT NULL,
	access_level VARCHAR NOT NULL,
	photo_profile VARCHAR
);

CREATE TABLE citwebservices.point_register (
	id BIGSERIAL PRIMARY KEY,
	register_date DATE NOT NULL,
	register_time DATE NOT NULL,
	local_register VARCHAR NOT NULL,
	user_id BIGINT REFERENCES citwebservices.users(id)
);

CREATE TABLE citwebservices.point_register_update (
	id BIGSERIAL PRIMARY KEY,
	justification VARCHAR NOT NULL,
	register_update_response VARCHAR,
	register_update_status VARCHAR NOT NULL,
	point_register_id BIGINT REFERENCES citwebservices.point_register(id)
);