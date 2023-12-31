INSERT INTO CONTRACT_TYPE(NAME) VALUES('FIXED');
INSERT INTO CONTRACT_TYPE(NAME) VALUES('INDEFINITE');

INSERT INTO SERVICE_TYPE(NAME) VALUES('ELECTRICITY_SUPPLY');
INSERT INTO SERVICE_TYPE(NAME) VALUES('WATER_SUPPLY');
INSERT INTO SERVICE_TYPE(NAME) VALUES('GAS_SUPPLY');
INSERT INTO SERVICE_TYPE(NAME) VALUES('INTERNET_SUPPLY');
INSERT INTO SERVICE_TYPE(NAME) VALUES('GARBAGE_COLLECTION');

INSERT INTO OWNER (IME, PREZIME, DATUM_RODENJA, OIB) VALUES('Ivo', 'Ivic', '1990-02-19', '19823245234');
INSERT INTO OWNER (IME, PREZIME, DATUM_RODENJA, OIB) VALUES('Grga', 'Grgic', '1991-05-20', '24523419823');
INSERT INTO OWNER (IME, PREZIME, DATUM_RODENJA, OIB) VALUES('Marko', 'Markic', '1996-06-10', '24523419333');
INSERT INTO OWNER (IME, PREZIME, DATUM_RODENJA, OIB) VALUES('Pero', 'Peric', '1977-06-11', '24523413452');
INSERT INTO OWNER (IME, PREZIME, DATUM_RODENJA, OIB) VALUES('Bobo', 'Bobic', '1987-04-12', '24523466652');
INSERT INTO OWNER (IME, PREZIME, DATUM_RODENJA, OIB) VALUES('Jerry', 'Seinfeld', '1966-06-13', '24337634666');
INSERT INTO OWNER (IME, PREZIME, DATUM_RODENJA, OIB) VALUES('George', 'Constanza', '1965-04-13', '22337634666');

INSERT INTO COUNTRY (NAME) VALUES ('Afghanistan');
INSERT INTO COUNTRY (NAME) VALUES ('Algeria');
INSERT INTO COUNTRY (NAME) VALUES ('American Samoa');
INSERT INTO COUNTRY (NAME) VALUES ('Angola');
INSERT INTO COUNTRY (NAME) VALUES ('Anguilla');
INSERT INTO COUNTRY (NAME) VALUES ('Argentina');
INSERT INTO COUNTRY (NAME) VALUES ('Armenia');
INSERT INTO COUNTRY (NAME) VALUES ('Australia');
INSERT INTO COUNTRY (NAME) VALUES ('Austria');
INSERT INTO COUNTRY (NAME) VALUES ('Azerbaijan');
INSERT INTO COUNTRY (NAME) VALUES ('Bahrain');
INSERT INTO COUNTRY (NAME) VALUES ('Bangladesh');
INSERT INTO COUNTRY (NAME) VALUES ('Belarus');
INSERT INTO COUNTRY (NAME) VALUES ('Bolivia');
INSERT INTO COUNTRY (NAME) VALUES ('Brazil');
INSERT INTO COUNTRY (NAME) VALUES ('Brunei');
INSERT INTO COUNTRY (NAME) VALUES ('Bulgaria');
INSERT INTO COUNTRY (NAME) VALUES ('Cambodia');
INSERT INTO COUNTRY (NAME) VALUES ('Cameroon');
INSERT INTO COUNTRY (NAME) VALUES ('Canada');
INSERT INTO COUNTRY (NAME) VALUES ('Chad');
INSERT INTO COUNTRY (NAME) VALUES ('Chile');
INSERT INTO COUNTRY (NAME) VALUES ('China');
INSERT INTO COUNTRY (NAME) VALUES ('Colombia');
INSERT INTO COUNTRY (NAME) VALUES ('Croatia');
INSERT INTO COUNTRY (NAME) VALUES ('USA');

INSERT INTO CITY (CITY_ZIP, CITY_NAME, COUNTRY_ID) VALUES ('10000','Zagreb', 25);
INSERT INTO CITY (CITY_ZIP, CITY_NAME, COUNTRY_ID) VALUES ('51000','Rijeka', 25);
INSERT INTO CITY (CITY_ZIP, CITY_NAME, COUNTRY_ID) VALUES ('47000','Karlovac', 25);
INSERT INTO CITY (CITY_ZIP, CITY_NAME, COUNTRY_ID) VALUES ('31000','Osijek', 25);
INSERT INTO CITY (CITY_ZIP, CITY_NAME, COUNTRY_ID) VALUES ('35000','Slavonski Brod', 25);
INSERT INTO CITY (CITY_ZIP, CITY_NAME, COUNTRY_ID) VALUES ('52100','Pula', 25);
INSERT INTO CITY (CITY_ZIP, CITY_NAME, COUNTRY_ID) VALUES ('10001','New York', 26);
INSERT INTO CITY (CITY_ZIP, CITY_NAME, COUNTRY_ID) VALUES ('21201','Baltimore', 26);

INSERT INTO ADDRESS (ADDRESS, CITY_ID) VALUES ('Horvaćanska 22', 1);
INSERT INTO ADDRESS (ADDRESS, CITY_ID) VALUES ('Vukovarska 2', 2);
INSERT INTO ADDRESS (ADDRESS, CITY_ID) VALUES ('Vodnikova 33', 1);
INSERT INTO ADDRESS (ADDRESS, CITY_ID) VALUES ('Jarun bb', 1);
INSERT INTO ADDRESS (ADDRESS, CITY_ID) VALUES ('Radnička 45', 1);
INSERT INTO ADDRESS (ADDRESS, CITY_ID) VALUES ('Centar 11', 2);
INSERT INTO ADDRESS (ADDRESS, CITY_ID) VALUES ('Pulska 18', 3);
INSERT INTO ADDRESS (ADDRESS, CITY_ID) VALUES ('456 Park Avenue 18', 7);

INSERT INTO SERVICE_PROVIDER (NAME, ADDRESS_ID) VALUES ('Jugoplastika', 1);
INSERT INTO SERVICE_PROVIDER (NAME, ADDRESS_ID) VALUES ('MetalGrad', 2);
INSERT INTO SERVICE_PROVIDER (NAME, ADDRESS_ID) VALUES ('Titokeramika', 3);
INSERT INTO SERVICE_PROVIDER (NAME, ADDRESS_ID) VALUES ('New York Gas', 8);

INSERT INTO HOUSEHOLD (ADDRESS) VALUES ('Velebitska 33');
INSERT INTO HOUSEHOLD (ADDRESS) VALUES ('Ninska 11');
INSERT INTO HOUSEHOLD (ADDRESS) VALUES ('Savska 101');
INSERT INTO HOUSEHOLD (ADDRESS) VALUES ('Knezija 13');
INSERT INTO HOUSEHOLD (ADDRESS) VALUES ('Lila 27');
INSERT INTO HOUSEHOLD (ADDRESS) VALUES ('Nova adresa 27');
INSERT INTO HOUSEHOLD (ADDRESS) VALUES ('454 Park Avenue');

INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (1,1,333.45);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (1,2,233);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (1,3,1411.45);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (1,4,326.00);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (1,5,133);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (2,1,233.45);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (2,2,213);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (2,3,1211.45);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (2,4,366.00);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (2,5,93);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (3,1,935);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (3,2,2333);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (3,3,1211.45);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (3,4,126.00);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (3,5,1333.45);
INSERT INTO SERVICE (SERVICE_PROVIDER_ID, SERVICE_TYPE_ID, PRICE) VALUES (4,1,100.66);

INSERT INTO CONTRACT (CONTRACT_TYPE_ID, HOUSEHOLD_ID,SERVICE_ID, START_DATE, END_DATE, STATUS)
VALUES (1,1,1, '2011-05-11', '2012-02-11', 'INACTIVE');
INSERT INTO CONTRACT (CONTRACT_TYPE_ID, HOUSEHOLD_ID,SERVICE_ID, START_DATE, END_DATE, STATUS)
VALUES (2,2,2, '2013-05-11', NULL, 'ACTIVE');
INSERT INTO CONTRACT (CONTRACT_TYPE_ID, HOUSEHOLD_ID,SERVICE_ID, START_DATE, END_DATE, STATUS)
VALUES (1,3,3, '2011-05-12', '2012-05-12', 'INACTIVE');
INSERT INTO CONTRACT (CONTRACT_TYPE_ID, HOUSEHOLD_ID,SERVICE_ID, START_DATE, END_DATE, STATUS)
VALUES (2,4,4, '2022-03-11', NULL, 'ACTIVE');
INSERT INTO CONTRACT (CONTRACT_TYPE_ID, HOUSEHOLD_ID,SERVICE_ID, START_DATE, END_DATE, STATUS)
VALUES (1,5,2, '2000-02-12', '2001-05-12', 'INACTIVE');
INSERT INTO CONTRACT (CONTRACT_TYPE_ID, HOUSEHOLD_ID,SERVICE_ID, START_DATE, END_DATE, STATUS)
VALUES (1,7,16, '2000-02-12', '2001-05-12','INACTIVE');

INSERT INTO HOUSEHOLD_OWNER (OWNER_ID, HOUSEHOLD_ID) VALUES (1,2);
INSERT INTO HOUSEHOLD_OWNER (OWNER_ID, HOUSEHOLD_ID) VALUES (2,1);
INSERT INTO HOUSEHOLD_OWNER (OWNER_ID, HOUSEHOLD_ID) VALUES (3,4);
INSERT INTO HOUSEHOLD_OWNER (OWNER_ID, HOUSEHOLD_ID) VALUES (4,3);
INSERT INTO HOUSEHOLD_OWNER (OWNER_ID, HOUSEHOLD_ID) VALUES (5,6);
INSERT INTO HOUSEHOLD_OWNER (OWNER_ID, HOUSEHOLD_ID) VALUES (6,7);

-- INSERT INTO USER(USERNAME, PASSWORD) VALUES ('admin', '$2a$10$KGFSC6gdo1NGxueEz6fIfu9FWv7kckwWdT5AN2.GWzdB2JTQFH7xi');
-- INSERT INTO USER(USERNAME, PASSWORD) VALUES ('grga', '$2y$10$VBFiHxpsu94SNmWHT1Q/xukejOvkFnZNc6Lmrliro1MDhhVOVAL2y');
-- INSERT INTO USER(USERNAME, PASSWORD) VALUES ('ivo', '$2y$10$VBFiHxpsu94SNmWHT1Q/xukejOvkFnZNc6Lmrliro1MDhhVOVAL2y');
-- INSERT INTO USER(USERNAME, PASSWORD) VALUES ('mrva', '$2y$10$VBFiHxpsu94SNmWHT1Q/xukejOvkFnZNc6Lmrliro1MDhhVOVAL2y');

INSERT INTO USER_TABLE(USERNAME, PASSWORD) VALUES ('admin', '$2a$10$KGFSC6gdo1NGxueEz6fIfu9FWv7kckwWdT5AN2.GWzdB2JTQFH7xi');
INSERT INTO USER_TABLE(USERNAME, PASSWORD) VALUES ('grga', '$2y$10$VBFiHxpsu94SNmWHT1Q/xukejOvkFnZNc6Lmrliro1MDhhVOVAL2y');
INSERT INTO USER_TABLE(USERNAME, PASSWORD) VALUES ('ivo', '$2y$10$VBFiHxpsu94SNmWHT1Q/xukejOvkFnZNc6Lmrliro1MDhhVOVAL2y');
INSERT INTO USER_TABLE(USERNAME, PASSWORD) VALUES ('mrva', '$2y$10$VBFiHxpsu94SNmWHT1Q/xukejOvkFnZNc6Lmrliro1MDhhVOVAL2y');

INSERT INTO ROLE(ROLE_NAME) VALUES ('ROLE_USER');
INSERT INTO ROLE(ROLE_NAME) VALUES ('ADMIN');
INSERT INTO ROLE(ROLE_NAME) VALUES ('EDITOR');
INSERT INTO ROLE(ROLE_NAME) VALUES ('MANAGER');
INSERT INTO ROLE(ROLE_NAME) VALUES ('SUPERUSER');

INSERT INTO USER_ROLE VALUES (1,2);
INSERT INTO USER_ROLE VALUES (2,1);
INSERT INTO USER_ROLE VALUES (3,3);
INSERT INTO USER_ROLE VALUES (4,5);