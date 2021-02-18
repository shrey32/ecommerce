insert into merchants(name,description) values('Daniel Lee', 'Auto Parts Merchant');
insert into merchants(name,description) values('David Beckham', 'Sports Utilities Merchant');
insert into merchants(name,description) values('James Bond', 'Groceries Merchants');
insert into merchants(name,description) values('Arthur Crow', 'Audio Books Merchant');


insert into offers(merchant_id,status,description,validityInMinutes,currency,price,createDateTime) values (1,'VALID','Car Parts offer',5,'GBP',450.30,CURRENT_TIMESTAMP());
insert into offers(merchant_id,status,description,validityInMinutes,currency,price,createDateTime) values (2,'VALID','Sports Utilities offer',5,'GBP',450.30,CURRENT_TIMESTAMP());
insert into offers(merchant_id,status,description,validityInMinutes,currency,price,createDateTime) values (3,'VALID','Household offers',5,'GBP',450.30,CURRENT_TIMESTAMP());
insert into offers(merchant_id,status,description,validityInMinutes,currency,price,createDateTime) values (4,'VALID','Attractive Offer On Audio',5,'GBP',450.30,CURRENT_TIMESTAMP());