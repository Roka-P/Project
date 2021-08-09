Create table athletes (
    id                  number(3)           not null,
    name                varchar2(128),
    birth_date          date                not null,
    age                 number(3),
    gender              varchar2(128),
    sports              varchar2(128),
    gold_solo           number(3),
    silver_solo         number(3),
    bronze_solo         number(3),
    gold_team           number(3),
    silver_team         number(3),
    bronze_team         number(3),
    prize               number(30),
    constraint athletes_id_pk    primary key (id)
);