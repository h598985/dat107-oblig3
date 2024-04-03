
drop schema if exists oblig3;

create schema oblig3;

set search_path to oblig3;


CREATE TABLE ansatt (
    ansatt_id SERIAL PRIMARY KEY,
    brukernavn VARCHAR(10) UNIQUE,
    fornavn VARCHAR(50),
    etternavn VARCHAR(50),
    ansettelsesdato DATE,
    stilling VARCHAR(50),
    maanedslonn DECIMAL(10, 2),
    avdeling_id INT
);



CREATE TABLE avdeling (
    avdeling_id SERIAL PRIMARY KEY,
    navn VARCHAR(50) UNIQUE,
    sjef_id INT UNIQUE REFERENCES ansatt(ansatt_id)
);




ALTER TABLE ansatt
ADD CONSTRAINT fk_avdeling_id
FOREIGN KEY (avdeling_id)
REFERENCES avdeling(avdeling_id);



CREATE TABLE prosjekt (
    prosjekt_id SERIAL PRIMARY KEY,
    navn VARCHAR(100),
    beskrivelse text,
);


CREATE TABLE prosjektdeltagelse (
    prosjektdeltagelse_id SERIAL PRIMARY KEY,
    ansatt_id INT REFERENCES ansatt(ansatt_id),
    prosjekt_id INT REFERENCES prosjekt(prosjekt_id),
    rolle VARCHAR(50),
    antall_timer INT
);