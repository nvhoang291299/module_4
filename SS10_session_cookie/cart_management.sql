create database cart_management;
use cart_management;

create table food (
	id_food bigint primary key auto_increment not null,
	type_food varchar(50), 
    name_food varchar(50),
    new_price int,
    image varchar(255)
);
create table cart(
	id_cart bigint primary key auto_increment not null,
    total varchar(255)
);
create table index_cart(
	id_index_cart bigint primary key not null auto_increment,
    amount int,
    id_cart bigint,
    id_food bigint,
    foreign key (id_cart) references cart(id_cart),
    foreign key (id_food) references food(id_food)
);

insert into food(id_food,type_food, name_food, new_price, image)
values
(1, 'fried chicken',"mala chicken",40000,"https://ik.imagekit.io/nguyenhoang/lotteria_images/chicken/chicken_mala_3-9.png")
,(2, 'fried chicken',"cheese family",217000,"https://ik.imagekit.io/nguyenhoang/lotteria_images/chicken/534x374px_cheese-chicken.png")
,(3, 'fried chicken',"fried chicken",35000,"https://ik.imagekit.io/nguyenhoang/lotteria_images/chicken/chicken-534x374px_fried-1_1.png")
,(4, 'fried chicken',"HS chicken",40000,"https://ik.imagekit.io/nguyenhoang/lotteria_images/chicken/534x374px_hs-1.png")
,(5, 'fried chicken',"HS Family(3Ps)",12000,"https://ik.imagekit.io/nguyenhoang/lotteria_images/chicken/chicken-534x374px_hs-chicken_3.png")
,(6, 'fried chicken',"Soy Bean Chicken",40000,"https://ik.imagekit.io/nguyenhoang/lotteria_images/chicken/534x374px_soybean-1.png")
,(7, 'fried chicken',"cheese chicken",40000,"https://ik.imagekit.io/nguyenhoang/lotteria_images/chicken/534x374px_cheese-1.png")
,(8, 'fried chicken',"buffalo chicken",40000,"https://ik.imagekit.io/nguyenhoang/lotteria_images/chicken/chicken-534x374px_buffalo-chicken-1.png");

insert into cart values (1, 40000), (2, 217000);
insert into index_cart values (1, 1, 1, 1);