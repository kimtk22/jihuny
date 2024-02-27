insert into job_tb (title,content,career,edu,position,address,dead_line,created_at,company_name) values ('웹케시 모집공고', '모집합니다.','인턴','대졸','프론트','부산','2024-03-31', '2024-02-26', '웹케시')
insert into job_tb (title,content,career,edu,position,address,dead_line,created_at,company_name) values ('비즈플레이 모집공고', '모집합니다.','신입','대졸','백엔드','부산','2024-03-31', '2024-02-26', '비즈플레이')
insert into job_tb (title,content,career,edu,position,address,dead_line,created_at,company_name) values ('쿠콘 모집공고', '모집합니다.','시니어','대졸','DevOps','부산','2024-03-31', '2024-02-26', '쿠콘')

insert into skill_tb(name, color) values ('javascript', 'yellow')
insert into skill_tb(name, color) values ('java', 'red')
insert into skill_tb(name, color) values ('html/css', 'blue')

insert into job_skill_tb(job_id, skill_id) values (1, 1)
insert into job_skill_tb(job_id, skill_id) values (1, 2)
insert into job_skill_tb(job_id, skill_id) values (1, 3)
insert into job_skill_tb(job_id, skill_id) values (2, 2)
insert into job_skill_tb(job_id, skill_id) values (3, 1)
insert into job_skill_tb(job_id, skill_id) values (3, 3)


insert into user_tb (name, email, password, address) values ('김태관', 'vodjaos@gmail.com', '1234', '권씨빌라')
insert into user_tb (name, email, password, address) values ('김지훈', 'huny@gmail.com', '4685', '강남')

