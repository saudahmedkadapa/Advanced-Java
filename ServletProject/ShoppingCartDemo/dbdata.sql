create table category(
cid int primary key,
cname varchar(20),
cdesc varchar(20));

insert into category values(1,'bags','tourist bags')
insert into category values(2,'shoes','tourist bags')
insert into category values(3,'etables','tourist bags')

create table prodcat(
pid int primary key,
pname varchar(20),
qty int,
price float(10,2),
catid int,
constraint fk_cid1 foreign key(catid) references category(cid));


insert into Prodcat values(10,'sack',34,1234,1);
insert into Prodcat values(11,'cabin luggage',34,1234,1);
insert into Prodcat values(12,'trolley bags',34,7000,1);
insert into Prodcat values(13,'gym bag',45,3000,1);

insert into Prodcat values(14,'walking shoes',34,6000,2);
insert into Prodcat values(15,'sports shoes',34,4000,2);
insert into Prodcat values(16,'school shoes',34,2000,2);
insert into Prodcat values(17,'formal shoes',45,9000,2);

insert into Prodcat values(18,'cakes',34,100,3);
insert into Prodcat values(19,'Lays',56,40,3);
insert into Prodcat values(20,'Maggi',56,100,3);
insert into Prodcat values(21,'Nachos',67,120,3);
