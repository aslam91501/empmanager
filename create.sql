create table department (creation_date date, department_head_id uuid unique, id uuid not null, name varchar(255), primary key (id));
create table employee (bonus_percentage float4 not null, dob date, is_company_head boolean not null, join_date date, salary float4 not null, department_id uuid, id uuid not null, manager_id uuid, city varchar(255), name varchar(255), state varchar(255), street varchar(255), title varchar(255), zip_code varchar(255), primary key (id));
alter table if exists department add constraint FKrfh61ugk9mpwmie0yu6ou0oxq foreign key (department_head_id) references employee;
alter table if exists employee add constraint FKbejtwvg9bxus2mffsm3swj3u9 foreign key (department_id) references department;
alter table if exists employee add constraint FKou6wbxug1d0qf9mabut3xqblo foreign key (manager_id) references employee;
