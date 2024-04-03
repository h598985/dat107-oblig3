
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
    sjef_id INT UNIQUE REFERENCES ansatt(ansatt_id) ON DELETE SET NULL
);





ALTER TABLE ansatt
ADD CONSTRAINT fk_avdeling_id
FOREIGN KEY (avdeling_id)
REFERENCES avdeling(avdeling_id)
ON DELETE SET NULL;



CREATE TABLE prosjekt (
    prosjekt_id SERIAL PRIMARY KEY,
    navn VARCHAR(100),
    beskrivelse text
);



CREATE TABLE prosjektdeltagelse (
    prosjektdeltagelse_id SERIAL PRIMARY KEY,
    ansatt_id INT REFERENCES ansatt(ansatt_id) ON DELETE SET NULL,
    prosjekt_id INT REFERENCES prosjekt(prosjekt_id) ON DELETE SET NULL,
    rolle VARCHAR(50),
    antall_timer INT
);



INSERT INTO ansatt (brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn, avdeling_id)
values
	('user0', 'Ole', 'Olav', '2023-01-15', 'Software Engineer', 10000.00, null),
    ('user1', 'John', 'Doe', '2023-01-15', 'Software Engineer', 5000.00, null),
    ('user2', 'Jane', 'Smith', '2023-02-20', 'Data Analyst', 4500.00, null),
    ('user3', 'Michael', 'Johnson', '2023-03-10', 'Project Manager', 6000.00, null),
    ('user4', 'Emily', 'Brown', '2023-04-05', 'Marketing Specialist', 4800.00, null),
    ('user5', 'David', 'Wilson', '2023-05-12', 'HR Manager', 5500.00, null),
    ('user6', 'Sarah', 'Taylor', '2023-06-22', 'Accountant', 5200.00, null),
    ('user7', 'Matthew', 'Martinez', '2023-07-18', 'Sales Representative', 4700.00, null),
    ('user8', 'Olivia', 'Anderson', '2023-08-30', 'Customer Service', 4900.00, null),
    ('user9', 'Daniel', 'Thomas', '2023-09-14', 'Operations Manager', 5800.00, null),
    ('user10', 'Sophia', 'Moore', '2023-10-25', 'UX Designer', 5300.00, null);
  


INSERT INTO avdeling (navn, sjef_id)
VALUES
    ('Engineering', 52),
    ('Marketing', 55),
    ('Finance', 56),
    ('Human Resources', 60),
    ('Sales', 61),
    ('IT', 54);
   
   
   update ansatt
   set avdeling_id = 1
   where ansatt_id = 52;
  
   update ansatt
   set avdeling_id = 2
   where ansatt_id = 55;
  
    update ansatt
   set avdeling_id = 3
   where ansatt_id = 56;
  
    update ansatt
   set avdeling_id = 4
   where ansatt_id = 60;
  
    update ansatt
   set avdeling_id = 5
   where ansatt_id = 61;
  
    update ansatt
   set avdeling_id = 6
   where ansatt_id = 54;
  
  
UPDATE ansatt
SET avdeling_id = 3
WHERE ansatt_id IN (53, 57, 58, 62,59);
            

  
  
INSERT INTO prosjekt (navn, beskrivelse)
VALUES
    ('Project A', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),
    ('Project B', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
    ('Project C', 'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.'),
    ('Project D', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.'),
    ('Project E', 'Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.'),
    ('Project F', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.'),
    ('Project G', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.'),
    ('Project H', 'Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.'),
    ('Project I', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.'),
    ('Project J', 'Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.');
   

INSERT INTO prosjektdeltagelse (ansatt_id, prosjekt_id, rolle, antall_timer)
VALUES
    (52, 1, 'Developer', 40),
    (53, 2, 'Analyst', 35),
    (54, 3, 'Manager', 45),
    (55, 4, 'Specialist', 38),
    (56, 5, 'Manager', 42),
    (60, 6, 'Accountant', 37);
   
   
   

SELECT * from ansatt;

select * from avdeling;

select * from prosjekt;

select * from prosjektdeltagelse;
