create database FPTULibraryManagement

use FPTULibraryManagement
go

create table BOOK(
	documentCodeB varchar(20) not null primary key,
	documentNameB varchar(20) not null,
	issueNumberB int not null,
	authorName nvarchar(30),
	numberofPage int
)
create table MAGAZINE(
	documentCodeM varchar(20) not null primary key,
	documentNameM varchar(20) not null,
	issueNumber int not null,
	magazineName nvarchar(30),
	monthPub int
)

create table ARTICLE(
	documentCodeA varchar(20) not null primary key,
	documentNameA varchar(20) not null,
	issueNumberA int not null,
	contentArticle varchar(5),
	publicDate varchar(10)
)

insert into BOOK values('db01','book1',2009,N'giang',200);
insert into BOOK values('db02','book2',2007,N'hồng ngọc',200);
select * from BOOK
select * from BOOK ORDER BY issueNumber DESC
insert into MAGAZINE values('mgz01','Document1',2010,N'tuổi trẻ',10);
insert into MAGAZINE values('mgz02','Document2',2011,N'tuổi trẻ',10);
select * from MAGAZINE
select * from MAGAZINE ORDER BY monthPub DESC
insert into ARTICLE values('mb03','FPT 1',2003,'FPT article','4/12/2002');
insert into ARTICLE values('mb04','FPT 2',2004,'FPT article3','6/12/2002');
select * from ARTICLE
select * from ARTICLE ORDER BY publicDate DESC