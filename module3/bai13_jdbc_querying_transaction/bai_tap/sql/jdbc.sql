create database demo_jdbc;
use demo_jdbc;
create table users (
 id  int AUTO_INCREMENT not null,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(`name`,email,country) values
('Minh','minh@codegym.vn','Viet Nam'),
('Kante','kante@che.uk','Kenia');

create table permision(
id int primary key auto_increment,
`name` varchar(50)
);

insert into Permision(`name`) values
('add'),
('edit'),
('delete'),
('view');

create table User_Permision(
permision_id int,
user_id int,
primary key(permision_id,user_id),
foreign key(permision_id) references permision(id),
foreign key(user_id) references users(id)
);

DELIMITER $$
CREATE PROCEDURE get_user_by_id(IN user_id INT)
BEGIN
    SELECT users.`name`, users.email, users.country
    FROM users
    where users.id = user_id;
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE insert_user(IN user_name varchar(50),IN user_email varchar(50),IN user_country varchar(50))
BEGIN
    INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
    END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE show_all_users () 
 BEGIN
  SELECT * FROM users;
END $$
DELIMITER ;

call show_all_users ();

DELIMITER $$
CREATE PROCEDURE edit_user (in `name_edit` varchar(120), in email_edit varchar(120),in country_edit varchar(120),in id_edit int(3))
 BEGIN
	update users 
	set `name`=name_edit,  email=email_edit,  country=country_edit
	where id=id_edit;
END $$
DELIMITER ;

call edit_user("temo","temo@gmail.com","Viet Nam",2);


DELIMITER $$
CREATE PROCEDURE delete_user (in id_edit int(3))
 BEGIN
	delete from users 
	where id=id_edit;
END $$
DELIMITER ;

call delete_user(7);



