create table user_details(user_name varchar(15), password varchar(500), enabled boolean, role varchar(10));
insert into user_details values('user', '$2y$12$64IpEXkNZMub/1h4v6Xtu.n76BSMXtsOVbo2x/0CUwAX3VmtuX19.', true, 'user');
insert into user_details values('user1', '$2y$12$FhHfuph2/6dqu9sUve9ZouZLjguOsMQWRBU7jzOyuwTGGuuGPz7l.', true, 'user');
insert into user_details values('admin', '$2y$12$3ouHAGgloGwG/tbHFjAWC.ygNV7iKlJDS3NxqAAb42C6Nr2Oy58Fy', true, 'admin');