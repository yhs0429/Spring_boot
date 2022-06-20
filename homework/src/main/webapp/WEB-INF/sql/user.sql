use webtest;
create table user(
	id	varchar(8) primary key,
    passwd varchar(8),
    name	varchar(20)
    );
    
insert into user(id, passwd, name)
value('admin', '1234', 'kim');
insert into user(id, passwd, name)
value('user', '1234', 'lee');
insert into user(id, passwd, name)
value('tester', '1234', 'park');

select * from user;

select id , passwd , name
from user
where id