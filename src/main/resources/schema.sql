CREATE TABLE Persons
(
    person_id  IDENTITY PRIMARY KEY,
    last_name  varchar(255),
    first_name varchar(255),
    address    varchar(255),
    city       varchar(255)
);