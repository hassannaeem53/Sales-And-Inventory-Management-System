create database sdaproject
use sdaproject

create table LoginInformation(
[cnic] varchar(50),
[Pin] varchar(50),
[type] int,
primary key(cnic,type)
)

create table Customers (
[Name] varchar (25),
CNIC varchar(25) primary key,
Phone_No varchar(15),
[Address] varchar(50),
[Type] int,
);

create table Cashiers(
[Name] varchar (25),
CNIC varchar(25) primary key,
Phone_No varchar(20)
);

create table Promotions(
PromotionID int identity (1,1) primary key,
Promotion_Name varchar(25),
Starting_Date varchar(25),
Ending_Date varchar(25),
Discount float
);

create table Departments(
Name varchar(50) primary key,
PromotionID int  foreign key REFERENCES Promotions(PromotionID)--0 if no promotion
);

create table StoreItems(
Item_SKU varchar(8) primary key,
[Name] varchar (50), 
Price float,
Perishable int,--1 for perishable, 0 for non-perishable
Fragile int, --1 for fragile
Department varchar(50) Foreign key references Departments(Name),
Quantity int, --Quantity currently in store
Expiry varchar(20)
);

create table Vendors (
[Name] varchar(50),
CNIC varchar(25) primary key,
Phone_No varchar(20),
Company_Name varchar(50)
);

create table WarehouseItems(
Item_SKU varchar(8) primary key,
[Name] varchar (50),
VendorCNIC varchar(25) foreign key references Vendors(CNIC), 
Price float,
Perishable int,--1 for perishable, 0 for non-perishable
Fragile int, --1 for fragile
Department varchar(50) foreign key references Departments(Name),
);

create table Batch(
BatchID int identity(1,1) primary key,
Item_SKU varchar(8) foreign key references WarehouseItems(Item_SKU),
Number_of_Boxes int,
Items_Per_Box int,
VendorCnic varchar(25) foreign key references Vendors(CNIC),
Expiry varchar(50)
);

create table Receipts(
ReceiptID int identity(1,1) Primary Key,
CustomerCNIC varchar(25) FOREIGN KEY REFERENCES Customers(CNIC),
CashierCNIC varchar(25) FOREIGN KEY REFERENCES Cashiers(CNIC),
Discount float
);

create table ReceiptItem(
ReceiptID int foreign key references Receipts(ReceiptID),
Item_SKU varchar(8) foreign key references StoreItems(Item_SKU),
Quantity int,
);
--STORED PROCEDURES---
CREATE PROCEDURE UpdateCustomer
@Cnic varchar(25),
@name varchar(25),
@Add varchar(50),
@num varchar(15)
AS
BEGIN
Update Customers set [Name]=@name, Address=@Add,Phone_No=@num where CNIC=@Cnic
END

CREATE PROCEDURE UpdateWarehouseItem
@SKU varchar(25),
@name varchar(25),
@price float,
@dep varchar(15)
AS
BEGIN
Update WarehouseItems set [Name]=@name, Price=@price, Department=@dep where Item_SKU=@SKU
END


CREATE PROCEDURE UpdateDepartmentPromotion
@id int,
@department varchar(25)
AS
BEGIN
Update Departments set PromotionID=@id where Name=@department
END

CREATE PROCEDURE UpdateItemQuantity
@sku varchar(25),
@quantity int
AS
BEGIN
Update StoreItems set Quantity=@quantity where Item_SKU=@sku
END

CREATE PROCEDURE UpdateBatch
@id int,
@vendor varchar(25),
@boxes int,
@itemsPerBox int,
@expiry varchar(50)
AS
BEGIN
Update Batch set VendorCnic=@vendor, Number_of_Boxes=@boxes, Items_Per_Box=@itemsPerBox,  Expiry= @expiry where BatchID=@id
END

CREATE PROCEDURE RemoveExpiredItem
@SKU varchar(8)
AS
BEGIN
Update [StoreItems] set quantity=0 where Item_SKU=@SKU 
END

CREATE PROCEDURE RemoveBatch
@id int
AS
BEGIN
Delete from [Batch] where BatchID=@id
END

--INSERT DATA----
insert into LoginInformation
values ('35202-1234567-8','tired',1),
('35202-1234567-9','tired',2),
('35202-1234567-0','tired',3)

insert into Customers
Values ('Hassan','35202-2345678-0','03211322432','#21,Block A1, Lahore',0),
('Ahmed','35202-2345678-1','03218648527','#23,Block G1, Karachi',1),
('Nabeel','35202-2345678-2','03213547810','#22,Block G3, Islamabad',0)

insert into Cashiers
values ('Salman','35202-1234567-8','03005689365')

insert into Promotions
values ('Black Friday','30-12-2021','15-01-2022',5),
('Christmas Sale','20-12-2021','31-12-2021',10)

insert into Departments
values ('Grocery', 1),('Pharmacy', 1),('Electronics', 2),('Clothing', 1),('Bakery', 2),('Sports', 1),('Crockery', 2)

insert into StoreItems
values ('531','Egg',20, 1, 1,'Grocery', 100, '12-01-2022'),
('532','Ketchup',200, 1, 0,'Grocery', 100, '12-02-2022'),
('123','Cake', 1500, 1, 0,'Bakery', 100, '02-01-2022'),
('143','Sweater', 2000, 0, 0,'Clothing', 100, ''),
('444','Panadol', 20, 1, 0,'Pharmacy', 100, '15-02-2021'),
('343','Plate', 200, 0, 1,'Crockery', 50, ''),
('173','Juicer', 10000, 0, 1,'Electronics', 50, ''),
('653','Shoes', 10000, 0, 0,'Sports', 20, '')

insert into Vendors
values ('Usama','35202-54314785-5','03456729854','Pepsi'),
('Shakeel','35202-12765785-4','03234543464','Dalda'),
('Ijaz','35202-34576145-5','03019872346','Lays')

insert into WarehouseItems
values ('531','Egg','35202-54314785-5',20, 1, 1,'Grocery'),
('532','Ketchup','35202-54314785-5',200, 1, 0,'Grocery'),
('123','Cake', '35202-54314785-5',1500 ,1, 0,'Bakery'),
('143','Sweater','35202-54314785-5', 2000, 0, 0,'Clothing'),
('444','Panadol','35202-54314785-5', 20, 1, 0,'Pharmacy'),
('343','Plate','35202-54314785-5', 200, 0, 1,'Crockery'),
('173','Juicer','35202-54314785-5', 10000, 0, 1,'Electronics'),
('653','Shoes','35202-54314785-5', 10000, 0, 0,'Sports')

insert into Batch 
values
('111', 10, 50,'35202-34576145-5', ''),
('532', 10, 50,'35202-34576145-5', '12-02-2022'),
('343', 5, 5,'35202-34576145-5', ''),
('343', 20, 5,'35202-34576145-5', ''),
('444', 20, 50,'35202-34576145-5', '')

insert into Receipts
values ('35202-2345678-2', '35202-1234567-8',0),('35202-2345678-0', '35202-1234567-8',0),('35202-2345678-2', '35202-1234567-8',0),('35202-2345678-2', '35202-1234567-8',0)

insert into ReceiptItem
values (1,'123',12), (2,'343',2),(3,'653',1), (4,'143',11), (2,'173',15),(2,'444',15)

insert into WarehouseItems values
('111','Football','35202-54314785-5', 2000, 0, 0,'Sports')

select * from LoginInformation

select * from ReceiptItem
select * from Vendors
select * from Batch
select * from WarehouseItems
select * from StoreItems
select * from Cashiers
select * from Customers
select * from Receipts
select * from Departments
select * from Promotions

