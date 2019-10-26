insert into ANIMAL_FAMILY values(1,'Acanthuridae','Acanthuridae is a small to medium sized fish that is found in the warmer coastal waters of the tropics.');
insert into ANIMAL_FAMILY values(2,'Canis Aureus','This is a medium sized member of the dog family, originally found in Africa, Asia and southeast Europe.');
insert into ANIMAL_FAMILY values(3,'Canis latrans','They are native to North and Central America although they are believed to have split off from the European grey wolf.');
insert into ANIMAL_FAMILY values(4,'Canis Lupus Dingo','The dingo is medium-sized canine natively found on the Australian continent and even into South-East Asia.');
insert into ANIMAL_FAMILY values(5,'Mesobatrachia','There are two main types of spadefoot toad, those that live only in North America and those that live in Europe, Northern Africa and Western Asia.');


select * from animal_family;

insert into animal values(1,'brown','This animal is usually seen around caulfield','image','Dingo','https://www.wikipedia.com','3160','Victoria','32','12','caulfield');
insert into animal values(2,'white','saw this in malvern','image','cat','https://www.wikipedia.com','3145','Victoria','32','12','caulfield');


-- SHA-256 hash value for 'admin' password
insert into USERS values(
NEXT VALUE FOR USERS_SEQ,
'admin',
'8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918',
'admin'
); 