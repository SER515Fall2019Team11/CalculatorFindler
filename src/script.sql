create schema mydb;
use mydb;
create table student(
	student_id varchar(10) not null primary key,
    username varchar(20) not null,
    password varchar(30) not null
);

insert into student values('0001','Jhon','Jhon001');
insert into student values('0002','Smith','Smith001');

create table teacher(
	teacher_id varchar(10) not null primary key,
    username varchar(20) not null,
    password varchar(30) not null
);

insert into teacher values('1','Gary','Gary');
insert into teacher values('2','Linquist','Linquist2');

create table question(
	id varchar(10) not null primary key,
    question varchar(40) not null,
    answer varchar(30) not null
);

insert into question values('1', 'compute 5 + 6', '11');
insert into question values('2', '7 + 6?', '13');
insert into question values('3', 'add two numbers with a result of 11', '11');
insert into question values('4', 'compute 5 + 6 - 3 + 9', '17');