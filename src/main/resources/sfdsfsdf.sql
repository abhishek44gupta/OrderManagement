insert into purchaseorder(order_id,customer_name,order_date,shipping_address,total) values(1,'John Wick','2020-12-12 14:02:30','London Street, UK',200.0);
insert into purchaseorder(order_id,customer_name,order_date,shipping_address,total) values(2,'Abhishek Gupta','2020-10-12 14:02:30','Singapore, SG',2000.0);
insert into purchaseorder(order_id,customer_name,order_date,shipping_address,total) values(3,'Ramesh Kumar','2020-09-12 14:02:30','Delhi, IN',100.0);

insert into orderitem (order_item_id,price,product_code,product_name,quantity, order_id) values(1,50,'PROD01','Pan Drive',1,1);
insert into orderitem (order_item_id,price,product_code,product_name,quantity, order_id) values(2,50,'PROD02','Tooth Brush',2,1);
insert into orderitem (order_item_id,price,product_code,product_name,quantity, order_id) values(3,75,'PROD03','Speaker',1,1);
insert into orderitem (order_item_id,price,product_code,product_name,quantity, order_id) values(4,25,'PROD04','Pen',2,1);

insert into orderitem (order_item_id,price,product_code,product_name,quantity, order_id) values(5,100,'PROD05','Tennis Kit',2,2);
insert into orderitem (order_item_id,price,product_code,product_name,quantity, order_id) values(6,1900,'PROD06','Bicycle',2,2);


insert into orderitem (order_item_id,price,product_code,product_name,quantity, order_id) values(7,50,'PROD07','Pan',1,3);
insert into orderitem (order_item_id,price,product_code,product_name,quantity, order_id) values(8,50,'PROD08','Tea',1,3);
