create database PracticaFinalGsda;
use PracticaFinalGsda;
create table Car(
	id_car int primary key auto_increment,
    brand varchar(11),
    model varchar(11),
    plate varchar(7) unique,
    year int CHECK (year >= 1 AND year <= 9999)
);

create table User(
	id_user int primary key auto_increment,
    name varchar(20) unique,
    password varchar(200),
    uuid varchar(37)
);

create table Owner(
	car_plate varchar(7),
    user_name varchar(20),
    primary key(car_plate, user_name),
    foreign key (car_plate) references Car (plate),
    foreign key (user_name) references User (name)
);

create table Expense(
	expense_id int primary key auto_increment,
    car_plate varchar(7),
    type enum('Revision', 'Gasolina', 'ITV', 'Aceite', 'Otros'),
    mileage int,
    date date,
    amount double,
    description varchar(55),
    foreign key (car_plate) references Car (plate)
);
