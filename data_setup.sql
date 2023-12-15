## create the user

create user countings with password 'countings' CREATEDB;

create database countings;

## as the countings user create the schema


create table countings (
id int,
count int,
comment varchar(40)
);

create sequence countings_seq as int start 1;

grant usage, select on sequence countings_seq too countings;

grant all on countings to countings;



