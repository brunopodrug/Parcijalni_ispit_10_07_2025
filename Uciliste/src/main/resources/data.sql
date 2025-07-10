insert into POLAZNIK (ime, prezime, program_naziv)
VALUES('Ante', 'Antic', 'backend java');
insert into POLAZNIK (ime, prezime, program_naziv)
VALUES('Ivo', 'Ivic', 'frontend');
insert into POLAZNIK (ime, prezime, program_naziv)
VALUES('Pero', 'Peric', 'c++');
insert into POLAZNIK (ime, prezime, program_naziv)
VALUES('Sime', 'Simic', 'c++');

insert into PROGRAM_OBRAZOVANJA(naziv, csvet)
VALUES('backend java', 60);
insert into PROGRAM_OBRAZOVANJA(naziv, csvet)
VALUES('frontend', 50);
insert into PROGRAM_OBRAZOVANJA(naziv, csvet)
VALUES('c++', 70);

insert into Upis(IDPOLAZNIK, IDPROGRAM_OBRAZOVANJA)
VALUES (1, 1);
insert into Upis(IDPOLAZNIK, IDPROGRAM_OBRAZOVANJA)
VALUES (2, 2);
insert into Upis(IDPOLAZNIK, IDPROGRAM_OBRAZOVANJA)
VALUES (3, 3);
insert into Upis(IDPOLAZNIK, IDPROGRAM_OBRAZOVANJA)
VALUES (4, 3);

insert into USERS(id, username, password)
values
    (1, 'user', '$2a$12$h0HcS2QDb/7zPASbLa2GoOTSRP6CWK0oX7pCK.dPjkM6L5N4pNovi'), -- password = user
    (2, 'admin', '$2a$12$INo0nbj40sQrTB7b28KJput/bNltGmFyCfRsUhvy73qcXo5/XdsTG'); -- password = admin

insert into AUTHORITY (id, authority_name)
values
    (1, 'ROLE_ADMIN'),
    (2, 'ROLE_USER');

insert into USERS_AUTHORITY (user_id, authority_id)
values
    (1, 2),
    (2, 1);