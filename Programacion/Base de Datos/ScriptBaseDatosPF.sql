create table Car(
	id_car int primary key auto_increment,
    brand varchar(50),
    model varchar(20),
    plate varchar(7),
    year int CHECK (year >= 1 AND year <= 9999)
);

create table User(
	id_user int primary key auto_increment,
    name varchar(20) unique,
    password varchar(200),
    uuid varchar(37)
);

create table Owner(
	id_user int,
    id_car int,
    primary key(id_car, id_user),
    foreign key (id_car) references Car (id_car),
    foreign key (id_user) references User (id_user)
);

create table Expense(
	expense_id int primary key auto_increment,
    id_car int,
    type enum('Revision', 'Gasolina', 'ITV', 'Aceite', 'Otros'),
    mileage int,
    date date,
    amount double,
    description varchar(400),
    foreign key Car (id_car) references Car (id_car)
);

drop table Expense;
drop table User;
drop table Owner;
drop table Car;

SELECT * FROM Expense;
SELECT * FROM User;
SELECT * FROM Owner;
SELECT * FROM Car;

SELECT c.id_car FROM Car c INNER JOIN Owner o ON c.id_car = o.id_car INNER JOIN User u ON o.id_user = u.id_user WHERE c.brand LIKE 'A' and c.model LIKE 'AS'and c.plate LIKE '1234QWE' and c.year = 1000 and u.name = 'A';