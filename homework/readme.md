1. id/pw 입력받은 값을 alert으로 뜨게 해보자
2. 확인 버튼 누른다음 Ajax get형식의 로그인 요청이 처리되어 alert 응답을 하게 해보자
   1. 비동기 get 요청을 fetch를 사용하여 처리한다.
   2. 테이블에 존재하는 회원이름 + 로그인 ok 를 출력 한다.

```mysql
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
```