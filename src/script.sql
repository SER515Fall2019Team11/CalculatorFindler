use mydb;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS teacher;

Drop database if exists mydb;
create schema mydb;
use mydb;
create table student(
	student_id int(10) not null AUTO_INCREMENT,
    username varchar(20) not null,
    password varchar(30) not null,
    CONSTRAINT student_pk PRIMARY KEY (student_id)
);

insert into student(username, password) values('Jhon','Jhon001');
insert into student(username, password) values('Smith','Smith001');

create table teacher(
	teacher_id int(10) not null AUTO_INCREMENT,
    username varchar(20) not null,
    password varchar(30) not null,
    CONSTRAINT teacher_pk PRIMARY KEY (teacher_id)
);

insert into teacher(username, password) values('Gary','Gary');
insert into teacher(username, password) values('Linquist','Linquist2');

create table question(
	id varchar(10) not null primary key,
    question varchar(40) not null,
    answer varchar(30) not null,
    grades varchar(10) not null
);

insert into question values('1', 'compute 5 + 6', '11', '0');
insert into question values('2', '7 + 6?', '13', '0');
insert into question values('3', 'add two numbers that sum upto 11', '11', '0');
insert into question values('4', 'compute 5 + 6 - 3 + 9', '17', '0');
insert into question values('5', 'compute 5 * 6', '30', '1');
insert into question values('6', '18 / 6?', '3', '1');
insert into question values('7', 'multiply two numbers with a result of 16', '16', '1');
insert into question values('8', 'compute 5 * 6 - 9 / 3', '27', '1');
