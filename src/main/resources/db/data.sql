insert into user_tb(username, password, email, created_at) values('ssar', '1234', 'ssar@nate.com', now());
insert into user_tb(username, password, email, created_at) values('cos', '1234', 'cos@nate.com', now());


insert into board_tb(title, user_id, created_at) values('aaaaaaaa', 1, now());

commit;
