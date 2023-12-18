insert into user_details(id,birth_date,name)
values(100001, current_date(), 'user1');

insert into user_details(id,birth_date,name)
values(100002, current_date(), 'user2');

insert into user_details(id,birth_date,name)
values(100003, current_date(), 'user3');

insert into user_details(id,birth_date,name)
values(100004, current_date(), 'user4');

insert into user_details(id,birth_date,name)
values(100005, current_date(), 'user5');

insert into users_posts(id,description,user_id)
values(20001,'comm1',100001);

insert into users_posts(id,description,user_id)
values(20002,'comm2',100002);

insert into users_posts(id,description,user_id)
values(20003,'comm3',100003);

insert into users_posts(id,description,user_id)
values(20004,'comm4',100004);

insert into users_posts(id,description,user_id)
values(20005,'comm5',100005);

insert into users_posts(id,description,user_id)
values(20006,'comm2user1',100001);

insert into users_posts(id,description,user_id)
values(20007,'comm3user1',100001);
