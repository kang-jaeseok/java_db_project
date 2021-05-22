drop table rent_member;
create table rent_member(
    userid  varchar2(10),
    passwd  varchar2(20) not null,
    phone   varchar2(20) not null,
    birthyear number(4) not null,
    rate char(1) not null,
    regdate date default sysdate,
    constraint pk_retnmember_userid primary key (userid)
);    
    --constraint pk_guest_seq primary key (seq)
    drop table rent_car;
create table rent_car(
    cnum number(5),
    model varchar2(10) not null,
    sort varchar2(10) not null,
    fee number(5) not null,
    rental char(1) not null,
    constraint pk_rentcar_cnum primary key (cnum)
);

create table rent_info(
    seq number(5),
    userid  varchar2(10),
    cnum number(5),
    rentday char(10) not null,
    returnday char(10) not null,
    totalfee number(8) not null,
    isreturn char(1) not null,
    constraint pk_rentinfo_seq primary key (seq),
    constraint fk_rentinfo_userid foreign key (userid) references rent_member (userid),
    constraint fk_rentinfo_cnum foreign key (cnum) references rent_car (cnum)
);
create sequence rentinfo_seq;
drop table rent_info;
delete from rent_member;
insert into rent_member (userid, passwd, phone, birthyear, rate) 
values('bbbb', '3333', '010-7153-1395', 1990,'N');
insert into rent_member (userid, passwd, phone, birthyear, rate) 
values('admin', '1111', '010-9999-1123', 1990,'A');
insert into rent_car (cnum, model, sort, fee, rental) values (9386, 'Sonata', 'Sedan', 10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (4578, 'Santafe', 'SVU',  20000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (1248, 'Starrex', 'Ban', 15000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (7840, 'K7', 'Sedan',  10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (1234, 'K9', 'Sedan',  10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (4444, 'SM5', 'Sedan',  10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (5678, 'K5', 'Midsize',  8000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (4561, 'Granduer', 'Sedan', 10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (7541, 'Tusson', 'SUV', 15000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (1265, 'Sonata', 'Sedan', 10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (4758, 'Morning', 'Compact', 5000, 0);

insert into rent_car (cnum, model, sort, fee, rental) values (9381, 'Sonata', 'Sedan', 10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (4573, 'Santafe', 'SVU',  20000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (3144, 'Starrex', 'Ban',  15000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (9345, 'K7', 'Sedan',  10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (8436, 'K9', 'Sedan',  10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (7343, 'SM5', 'Sedan', 10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (6572, 'K5', 'Midsize',  8000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (5368, 'Granduer', 'Sedan', 10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (4349, 'Tusson', 'SUV',  15000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (3566, 'Sonata', 'Sedan', 10000, 0);
insert into rent_car (cnum, model, sort, fee, rental) values (1355, 'Morning', 'Compact', 5000, '0');


--차량별 대여기간
select c.cnum, c.model, c.sort, i.rentday, i.returnday, i.totalfee 
from rent_car c 
join rent_info i on (c.cnum = i.cnum);

--회원별 대여정보
select m.userid, m.phone, c.model, c.sort, i.totalfee 
from rent_member m
join rent_info i on (m.userid = i.userid)
join rent_car c on (i.cnum = c.cnum);

update rent_car set rental = 1 where cnum = 1855;

insert into rent_info (userid, cnum, rentday, returnday, totalfee) values ();
delete from rent_car where cnum = 1355;
select * from rent_member;
select * from rent_member where userid = 'admin';
select * from rent_car;

update rent_car set 
		model = 'Morning',
		sort = 'Compact',
        fee = 5000,
		rental = '1' 
		where cnum = 1355;

update rent_member set 
passwd = '3333',
phone = '010-9989-2345',
birthyear = 1991
where userid = 'aaaa';

select * from rent_info;
insert into rent_info (seq, userid, cnum, rentday, returnday, totalfee, isreturn) 
values (rentinfo_seq.nextval, 'aaaa', 9386, '2021-05-11', '2021-05-13', 30000, '1');
update rent_info set 
userid = 'aaaa',
cnum = 9386,
rentday = '2021-05-11',
returnday = '2021-05-14',
totalfee = 30000
where seq = 1;

select * from rent_car where cnum = 1234;

rollback;
commit;