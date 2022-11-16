create database ecommerce;
use ecommerce;
create table reg_details(
id int not null auto_increment unique,
email varchar(30),
gender varchar(30),
city varchar(30),
state varchar(30),
zip int,
pasword varchar(40));
insert into reg_details(email,gender,city,state,zip,pasword) values("shubh","male","ftp","up",22,"abc");
select * from reg_details;
alter table reg_details drop column zip;
create table contact_us(
nam varchar(30),
contact varchar(10),
feedback varchar(150)
);
select * from contact_us;