--->>SQL Assignment

--->>Solved Queries

1)	List all the columns of the Salespeople table.

Ans :- mysql> SELECT * FROM SALESPEOPLE ;
+------+---------+-----------+------+
| snum | sname   | city      | comm |
+------+---------+-----------+------+
| 1001 | peel    | london    | 12   |
| 1002 | seeres  | sanjoes   | 13   |
| 1004 | motika  | london    | 11   |
| 1003 | AlexRod | new york  | 10   |
| 1007 | rifkin  | barcelona | 15   |
| 1008 | fran    | london    | 25   |
+------+---------+-----------+------+
6 rows in set (0.00 sec)

2)	List all customers with a rating of 100.
Ans:- mysql> SELECT * FROM costumers WHERE rating = 100 ;
+------+---------+--------+--------+-------+
| cnum | cname   | city   | rating | sname |
+------+---------+--------+--------+-------+
| 2001 | hoffman | london | 100    | 1001  |
| 2006 | clemens | london | 100    | 1001  |
| 2007 | pereira | rome   | 100    | 1004  |
+------+---------+--------+--------+-------+
3 rows in set (0.00 sec)

 
3)	Find the largest order taken by each salesperson on each date.

Ans :- mysql> select salespeople.snum, salespeople.sname, max(amt) as MAX_ORDER from orders inner join salespeople on orders.snum=salespeople.snum group by snum;
+------+---------+-----------+
| snum | sname   | MAX_ORDER |
+------+---------+-----------+
| 1001 | peel    | 9891.88   |
| 1002 | seeres  | 75.75     |
| 1003 | AlexRod | 1713.23   |
| 1004 | motika  | 1900.10   |
| 1007 | rifkin  | 18.69     |
+------+---------+-----------+
5 rows in set (0.00 sec)

4)	Arrange the Order table by descending customer number.
Ans :- mysql> SELECT * FROM orders ORDER BY CNUM  DESC ;
+------+---------+----------+------+------+
| onum | amt     | odate    | cnum | snum |
+------+---------+----------+------+------+
| 3001 | 18.69   | 10/03/90 | 2008 | 1007 |
| 3006 | 1098.16 | 10/03/90 | 2008 | 1007 |
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 |
| 3008 | 4723.00 | 10/05/90 | 2006 | 1001 |
| 3011 | 9891.88 | 10/06/90 | 2006 | 1001 |
| 3007 | 75.75   | 10/04/90 | 2004 | 1002 |
| 3010 | 1309.95 | 10/06/90 | 2004 | 1002 |
| 3005 | 5160.45 | 10/03/90 | 2003 | 1002 |
| 3009 | 1713.23 | 10/04/90 | 2002 | 1003 |
| 3003 | 767.19  | 10/03/90 | 2001 | 1001 |
+------+---------+----------+------+------+
10 rows in set (0.00 sec)

5)	Find which salespeople currently have orders in the order table.

Ans :- mysql> select salespeople.sname from salespeople join orders on (salespeople.snum = orders.snum);
+---------+
| sname   |
+---------+
| rifkin  |
| peel    |
| motika  |
| seeres  |
| rifkin  |
| AlexRod |
| seeres  |
| peel    |
| seeres  |
| peel    |
+---------+
10 rows in set (0.00 sec)


6)	List names of all customers matched with the salespeople serving them.

Ans :- mysql> select salespeople.sname, customers.cname from salespeople join customers on (salespeople.snum = customers.snum);
+---------+----------+
| sname   | cname    |
+---------+----------+
| peel    | hoffman  |
| AlexRod | giovanni |
| seeres  | liu      |
| seeres  | grass    |
| peel    | clemens  |
| rifkin  | cisneros |
| motika  | pereira  |
+---------+----------+
7 rows in set (0.00 sec)

7)	Find the names and numbers of all salespeople who have more than one customer.

Ans :- mysql> select * from (select sp.SNAME,count(*) AS countCustomer  from salespeople As sp right join customers As cust on sp.SNUM=cust.SNUM  group by cust.SNUM) As NoOfCustomersOfSalesPerson where countCustomer>1 ;
+--------+---------------+
| SNAME  | countCustomer |
+--------+---------------+
| peel   |             2 |
| seeres |             2 |
+--------+---------------+
2 rows in set (0.00 sec)


8)	Count the orders of each of the salespeople and output the results in descending order.

Ans :- mysql>  select sp.SNAME, count(*) As NoOfOrders from orders As od Left join salespeople As sp on od.SNUM = sp.SNUM group by od.SNUM order by NoOfOrders desc;

+---------+------------+
| SNAME   | NoOfOrders |
+---------+------------+
| peel    |          3 |
| seeres  |          3 |
| rifkin  |          2 |
| AlexRod |          1 |
| motika  |          1 |
+---------+------------+
5 rows in set (0.00 sec)


9)	List the customer table if and only if one or more of the customers in the Customer table are located in SanJose.

Ans :- mysql> select * from customers where city = 'sanjose';
+------+----------+---------+--------+------+
| cnum | cname    | city    | rating | snum |
+------+----------+---------+--------+------+
| 2003 | liu      | sanjose |    200 | 1002 |
| 2008 | cisneros | sanjose |    300 | 1007 |
+------+----------+---------+--------+------+
2 rows in set (0.00 sec)

10)	Match salespeople to customers according to what city they live in.

Ans :-mysql> select salespeople.sname,customers.city,customers.cname from salespeople join customers on (customers.city = salespeople.city );
+--------+--------+---------+
| sname  | city   | cname   |
+--------+--------+---------+
| peel   | london | hoffman |
| motika | london | hoffman |
| fran   | london | hoffman |
| peel   | london | clemens |
| motika | london | clemens |
| fran   | london | clemens |
+--------+--------+---------+
6 rows in set (0.00 sec)


11)	Find all the customers in SanJose who have a rating above 200.

Ans :- mysql> select cname from costumers where city ='sanjose' and rating > 200;
+----------+
| cname    |
+----------+
| cisneros |
+----------+

12)	List the names and commissions of all salespeople in London.

Ans :- mysql> select sname, comm from salespeople where city ='london' ;
+--------+------+
| sname  | comm |
+--------+------+
| peel   | 12   |
| motika | 11   |
| fran   | 25   |
+--------+------+

13)	List all the orders of Salesperson Motika from the orders table.

Ans :- mysql> select * from salespeople where sname = 'motika';
+------+--------+--------+------+
| snum | sname  | city   | comm |
+------+--------+--------+------+
| 1004 | motika | london | 11   |
+------+--------+--------+------+
1 row in set (0.00 sec)

14)	Find all customers who booked orders on October 3.

Ans:- mysql> select * from orders where odate='10/03/90';
+------+---------+----------+------+------+
| onum | amt     | odate    | cnum | snum |
+------+---------+----------+------+------+
| 3001 | 18.69   | 10/03/90 | 2008 | 1007 |
| 3003 | 767.19  | 10/03/90 | 2001 | 1001 |
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 |
| 3005 | 5160.45 | 10/03/90 | 2003 | 1002 |
| 3006 | 1098.16 | 10/03/90 | 2008 | 1007 |
+------+---------+----------+------+------+
5 rows in set (0.00 sec)
 
15)	Give the sums of the amounts from the Orders table, grouped by date, eliminating all those dates where the SUM was not at least 2000 above the maximum Amount.

Ans :-  mysql> select odate,sum(amt) from orders group by odate having sum(amt)>max(amt)+2000 ;
+----------+----------+
| ODATE    | sum(AMT) |
+----------+----------+
| 10/03/90 |  8944.59 |
+----------+----------+
1 row in set (0.01 sec)

16)	Select all orders that had amounts that were greater than at least one of the orders from October 6.

Ans :- mysql> select * from orders where amt > (select min(amt) from orders where odate='10/06/90');
+------+---------+----------+------+------+
| onum | amt     | odate    | cnum | snum |
+------+---------+----------+------+------+
| 3001 | 18.69   | 10/03/90 | 2008 | 1007 |
| 3003 | 767.19  | 10/03/90 | 2001 | 1001 |
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 |
| 3005 | 5160.45 | 10/03/90 | 2003 | 1002 |
| 3009 | 1713.23 | 10/04/90 | 2002 | 1003 |
| 3007 | 75.75   | 10/04/90 | 2004 | 1002 |
| 3008 | 4723.00 | 10/05/90 | 2006 | 1001 |
| 3011 | 9891.88 | 10/06/90 | 2006 | 1001 |
+------+---------+----------+------+------+
8 rows in set (0.01 sec)


17)	Write a query that uses the EXISTS operator to extract all salespeople who have customers with a rating of 300.

Ans :- mysql> select SNAME from salespeople where EXISTS (select rating from customers where Rating=300 );
+---------+
| SNAME   |
+---------+
| peel    |
| seeres  |
| motika  |
| AlexRod |
| rifkin  |
| fran    |
+---------+
6 rows in set (0.00 sec)

18)	Find all customers whose cnum is 1000 above the snum of Seeres .

Ans :- mysql>  select * from customers where CNUM > (Select snum+1000 from salespeople where sname = 'Seeres');
+------+----------+---------+--------+------+
| cnum | cname    | city    | rating | snum |
+------+----------+---------+--------+------+
| 2003 | liu      | sanjose |    200 | 1002 |
| 2004 | grass    | berlin  |    300 | 1002 |
| 2006 | clemens  | london  |    100 | 1001 |
| 2008 | cisneros | sanjose |    300 | 1007 |
| 2007 | pereira  | rome    |    100 | 1004 |
+------+----------+---------+--------+------+
5 rows in set (0.00 sec)

19)	Give the salespeople’s commissions as percentages instead of decimal numbers.

Ans :-  mysql> select SNAME,COMM,COMM  as Percentage from salespeople;
+---------+------+------------+
| SNAME   | COMM | Percentage |
+---------+------+------------+
| peel    | 12   | 12         |
| seeres  | 13   | 13         |
| motika  | 11   | 11         |
| AlexRod | 10   | 10         |
| rifkin  | 15   | 15         |
| fran    | 25   | 25         |
+---------+------+------------+
6 rows in set (0.00 sec)


20)	Find the largest order taken by each salesperson on each date, eliminating those Maximum orders, which are less than 3000.

Ans :- mysql> select sp.SNAME,od.AMT,od.ODate from salespeople as sp,orders AS od WHERE sp.SNUM = od.SNUM AND od.AMT > 1000 group by ODATE;
+---------+---------+----------+
| SNAME   | AMT     | ODate    |
+---------+---------+----------+
| motika  | 1900.10 | 10/03/90 |
| AlexRod | 1713.23 | 10/04/90 |
| peel    | 4723.00 | 10/05/90 |
| seeres  | 1309.95 | 10/06/90 |
+---------+---------+----------+
4 rows in set (0.01 sec)


21) List all the largest orders for October 3, for each salesperson.

Ans :- mysql> select sp.SNAME,max(od.AMT) As Largest_Order_Amount ,od.ODate from salespeople as sp,orders AS od WHERE sp.SNUM = od.SNUM AND ODATE='10/03/90' group by sp.SNUM;
+--------+----------------------+----------+
| SNAME  | Largest_Order_Amount | ODate    |
+--------+----------------------+----------+
| peel   | 767.19               | 10/03/90 |
| seeres | 5160.45              | 10/03/90 |
| motika | 1900.10              | 10/03/90 |
| rifkin | 18.69                | 10/03/90 |
+--------+----------------------+----------+
4 rows in set (0.01 sec)

22) Find all customers located in cities where Serres has customers.

Ans :- 

23) Select all customers with a rating above 200.

Ans :- mysql>  Select * from customers where Rating >200;
+------+----------+---------+--------+------+
| CNUM | CNAME    | CITY    | RATING | SNUM |
+------+----------+---------+--------+------+
| 2004 | Grass    | Berlin  |    300 | 1002 |
| 2008 | cisneros | sanjose |    300 | 1007 |
+------+----------+---------+--------+------+

24) Count the number of salespeople currently having orders in the orders table.

Ans :- mysql> select count(distinct Snum) as no_of_salespeople from orders ;
+-------------------+
| no_of_salespeople |
+-------------------+
|                 5 |
+-------------------+


25) Write a query that produces all customers serviced by salespeople with a commission above 12%. Output the customer’s name,
salesperson’s name and the salesperson’s rate of commission.

Ans :- 

26) Find salespeople who have multiple customers.

Ans :- mysql>   select sp.sname from salespeople as sp left join customers as cust on sp.snum=cust.snum group by cust.snum having count(cust.snum)>1;
+--------+
| SNAME  |
+--------+
| peel   |
| Serres |
+--------+

27) Find salespeople with customers located in their own cities.

Ans :-mysql>  select sp.SNAME,cust.CNAME,cust.CITY from salespeople as sp Inner join customers as cust on sp.CITY=cust.CITY order by cust.CITY;
+--------+---------+--------+
| SNAME  | CNAME   | CITY   |
+--------+---------+--------+
| motika | hoffman | london |
| peel   | clemens | london |
| fran   | clemens | london |
| peel   | hoffman | london |
| fran   | hoffman | london |
| motika | clemens | london |
+--------+---------+--------+
6 rows in set (0.00 sec)


28) Find all salespeople whose name starts with ‘P’ and fourth character is ‘L’.

Ans :- mysql>  select * from salespeople where SNAME like 'p__l%';
+------+-------+--------+------+
| snum | sname | city   | comm |
+------+-------+--------+------+
| 1001 | peel  | london | 12   |
+------+-------+--------+------+
1 row in set (0.00 sec)

29) Write a query that uses a subquery to obtain all orders for the customer named ‘Cisneros’. Assume you do not know his customer number.

Ans :-mysql> select ord.* from orders as ord where CNUM =(select CNUM from customers where CNAME="Cisneros");
+------+---------+----------+------+------+
| onum | amt     | odate    | cnum | snum |
+------+---------+----------+------+------+
| 3001 | 18.69   | 10/03/90 | 2008 | 1007 |
| 3006 | 1098.16 | 10/03/90 | 2008 | 1007 |
+------+---------+----------+------+------+
2 rows in set (0.00 sec)

30) Find the largest orders for Serres and Rifkin.

Ans :- mysql> select * from orders where AMT in (select max(AMT) from orders where SNUM in (select SNUM from salespeople where SNAME="Rifkin" or SNAME="Serres" ) group by SNUM);
+------+-------+----------+------+------+
| onum | amt   | odate    | cnum | snum |
+------+-------+----------+------+------+
| 3001 | 18.69 | 10/03/90 | 2008 | 1007 |
+------+-------+----------+------+------+
1 row in set (0.00 sec)

Ans :- mysql>  select sp.SNAME,max(od.AMT) as LargestOrder  from orders as od inner join  salespeople as sp on sp.SNAME in ('Serres','Rifkin' ) And od.SNUM=sp.SNUM group by sp.SNUM;
+--------+--------------+
| SNAME  | LargestOrder |
+--------+--------------+
| Serres |      5160.45 |
| Rifkin |        10000 |
+--------+--------------+
2 rows in set (0.00 sec)
31) Sort the salespeople table in the following order: snum, sname, commission, city.
 
 Ans :- mysql>    select snum, sname, comm, city from salespeople order by snum,sname,city;
+------+---------+------+-----------+
| snum | sname   | comm | city      |
+------+---------+------+-----------+
| 1001 | peel    |   12 | London    |
| 1002 | Serres  |   13 | SanJose   |
| 1003 | AxelRod |   10 | New York  |
| 1004 | Motika  |   11 | London    |
| 1007 | Rifkin  |   15 | Barcelona |
| 1008 | rohit   |   12 | india     |
+------+---------+------+-----------+
6 rows in set (0.00 sec)

32) Select all customers whose names fall in between ‘A’ and ‘G’ alphabetical range.

Ans :-mysql> select * from customers as cust where  cname >='A' and cname <= 'H';
+------+----------+---------+--------+------+
| cnum | cname    | city    | rating | snum |
+------+----------+---------+--------+------+
| 2002 | giovanni | rome    |    200 | 1003 |
| 2004 | grass    | berlin  |    300 | 1002 |
| 2006 | clemens  | london  |    100 | 1001 |
| 2008 | cisneros | sanjose |    300 | 1007 |
+------+----------+---------+--------+------+
4 rows in set (0.00 sec)

33) Select all the possible combinations of customers you can assign.

Ans:-

34) Select all orders that are greater than the average for October 4.

Ans :-mysql> select * from orders where AMT>(select avg(AMT) from orders where ODATE='10/04/90');
+------+---------+----------+------+------+
| onum | amt     | odate    | cnum | snum |
+------+---------+----------+------+------+
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 |
| 3005 | 5160.45 | 10/03/90 | 2003 | 1002 |
| 3006 | 1098.16 | 10/03/90 | 2008 | 1007 |
| 3009 | 1713.23 | 10/04/90 | 2002 | 1003 |
| 3008 | 4723.00 | 10/05/90 | 2006 | 1001 |
| 3010 | 1309.95 | 10/06/90 | 2004 | 1002 |
| 3011 | 9891.88 | 10/06/90 | 2006 | 1001 |
+------+---------+----------+------+------+
7 rows in set (0.00 sec)

35) Write a select command using correlated subquery that selects the names and numbers of all customers with ratings equal to the maximum
for their city.

Ans :-mysql> select cust.Cname, cust.Cnum,cust.* from customers as cust where cust.Cnum in (select Cnum from (select Cnum,max(Rating) from customers group by city ) as temptable);
+----------+------+------+----------+---------+--------+------+
| Cname    | Cnum | cnum | cname    | city    | rating | snum |
+----------+------+------+----------+---------+--------+------+
| hoffman  | 2001 | 2001 | hoffman  | london  |    100 | 1001 |
| giovanni | 2002 | 2002 | giovanni | rome    |    200 | 1003 |
| liu      | 2003 | 2003 | liu      | sanjose |    200 | 1002 |
| grass    | 2004 | 2004 | grass    | berlin  |    300 | 1002 |
+----------+------+------+----------+---------+--------+------+
4 rows in set (0.00 sec)

Ans :- mysql> SELECT CNAME,CNUM,City,Rating FROM customers WHERE RATING >= Any (SELECT MAX(RATING) FROM customers GROUP BY CITY) ;
+----------+------+---------+--------+
| CNAME    | CNUM | City    | Rating |
+----------+------+---------+--------+
| hoffman  | 2001 | london  |    100 |
| giovanni | 2002 | rome    |    200 |
| liu      | 2003 | sanjose |    200 |
| grass    | 2004 | berlin  |    300 |
| clemens  | 2006 | london  |    100 |
| cisneros | 2008 | sanjose |    300 |
| pereira  | 2007 | rome    |    100 |
+----------+------+---------+--------+
7 rows in set (0.00 sec)

36) Write a query that totals the orders for each day and places the results in descending order.

Ans :-mysql> select SUM(AMT) as AMT, ODATE from orders group by ODATE order by AMT desc;
+----------+----------+
| AMT      | ODATE    |
+----------+----------+
| 11201.83 | 10/06/90 |
|  8944.59 | 10/03/90 |
|     4723 | 10/05/90 |
|  1788.98 | 10/04/90 |
+----------+----------+
4 rows in set (0.00 sec)


37) Write a select command that produces the rating followed by the name of each customer in SanJose.

Ans :- mysql> select Rating,CNAME from customers where CITY='Sanjose';
+--------+----------+
| Rating | CNAME    |
+--------+----------+
|    200 | liu      |
|    300 | cisneros |
+--------+----------+
2 rows in set (0.00 sec)

38) Find all orders with amounts smaller than any amount for a customer in SanJose.

Ans :-mysql> select od.* from orders as od left join customers as cust on cust.city='sanjose' and cust.CNUM=od.CNUM;
+------+---------+----------+------+------+
| onum | amt     | odate    | cnum | snum |
+------+---------+----------+------+------+
| 3001 | 18.69   | 10/03/90 | 2008 | 1007 |
| 3003 | 767.19  | 10/03/90 | 2001 | 1001 |
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 |
| 3005 | 5160.45 | 10/03/90 | 2003 | 1002 |
| 3006 | 1098.16 | 10/03/90 | 2008 | 1007 |
| 3009 | 1713.23 | 10/04/90 | 2002 | 1003 |
| 3007 | 75.75   | 10/04/90 | 2004 | 1002 |
| 3008 | 4723.00 | 10/05/90 | 2006 | 1001 |
| 3010 | 1309.95 | 10/06/90 | 2004 | 1002 |
| 3011 | 9891.88 | 10/06/90 | 2006 | 1001 |
+------+---------+----------+------+------+
10 rows in set (0.00 sec)

39) Find all orders with above average amounts for their customers.

Ans :- mysql> select * from orders natural join customers where AMT > (select AVG(AMT) from orders);
+------+------+------+---------+----------+---------+---------+--------+
| cnum | snum | onum | amt     | odate    | cname   | city    | rating |
+------+------+------+---------+----------+---------+---------+--------+
| 2003 | 1002 | 3005 | 5160.45 | 10/03/90 | liu     | sanjose |    200 |
| 2006 | 1001 | 3008 | 4723.00 | 10/05/90 | clemens | london  |    100 |
| 2006 | 1001 | 3011 | 9891.88 | 10/06/90 | clemens | london  |    100 |
+------+------+------+---------+----------+---------+---------+--------+
3 rows in set (0.00 sec)


40) Write a query that selects the highest rating in each city.

Ans :- mysql> select cust.City ,max(rating) As maxRatingInCity from customers as cust group by city;
+---------+-----------------+
| City    | maxRatingInCity |
+---------+-----------------+
| berlin  |             300 |
| london  |             100 |
| rome    |             200 |
| sanjose |             300 |
+---------+-----------------+
4 rows in set (0.00 sec)


41) Write a query that calculates the amount of the salesperson’s commission on each order by a customer with a rating above 100.00.
   
Ans :- 

42) Count the customers with ratings above SanJose’s average.

Ans :-mysql> select count(*) from customers where RATING > (select AVG(RATING) from customers where city = 'SanJose');
+----------+
| count(*) |
+----------+
|        2 |
+----------+
1 row in set (0.00 sec)

43) Find all salespeople that are located in either Barcelona or London.

Ans :- mysql> select * from salespeople where CITY in ('Barcelona', 'London');
+------+--------+-----------+------+
| snum | sname  | city      | comm |
+------+--------+-----------+------+
| 1001 | peel   | london    | 12   |
| 1004 | motika | london    | 11   |
| 1007 | rifkin | barcelona | 15   |
| 1008 | fran   | london    | 25   |
+------+--------+-----------+------+
4 rows in set (0.00 sec)

44) Find all salespeople with only one customer.

Ans :- mysql> select sp.*,cust.CNAME as Customer from salespeople as sp Left Join customers as cust on sp.SNUM= cust.SNUM group by cust.SNUM having count(cust.SNUM)=1;
+------+---------+-----------+------+----------+
| snum | sname   | city      | comm | Customer |
+------+---------+-----------+------+----------+
| 1003 | AlexRod | new york  | 10   | giovanni |
| 1004 | motika  | london    | 11   | pereira  |
| 1007 | rifkin  | barcelona | 15   | cisneros |
+------+---------+-----------+------+----------+
3 rows in set (0.00 sec)

45) Write a query that joins the Customer table to itself to find all pairs or customers served by a single salesperson.
Ans :- 

46) Write a query that will give you all orders for more than $1000.00.

Ans :-mysql> select * from orders where AMT>1000.00;
+------+---------+----------+------+------+
| onum | amt     | odate    | cnum | snum |
+------+---------+----------+------+------+
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 |
| 3005 | 5160.45 | 10/03/90 | 2003 | 1002 |
| 3006 | 1098.16 | 10/03/90 | 2008 | 1007 |
| 3009 | 1713.23 | 10/04/90 | 2002 | 1003 |
| 3008 | 4723.00 | 10/05/90 | 2006 | 1001 |
| 3010 | 1309.95 | 10/06/90 | 2004 | 1002 |
| 3011 | 9891.88 | 10/06/90 | 2006 | 1001 |
+------+---------+----------+------+------+
7 rows in set (0.00 sec)

47) Write a query that lists each order number followed by the name of the customer who made that order.

Ans :- mysql> select ord.ONUM,cust.CNAME from orders as ord natural join customers as cust;
+------+----------+
| ONUM | CNAME    |
+------+----------+
| 3001 | cisneros |
| 3003 | hoffman  |
| 3002 | pereira  |
| 3005 | liu      |
| 3006 | cisneros |
| 3009 | giovanni |
| 3007 | grass    |
| 3008 | clemens  |
| 3010 | grass    |
| 3011 | clemens  |
+------+----------+
10 rows in set (0.00 sec)

48) Write a query that selects all the customers whose ratings are equal to or greater than ANY(in the SQL sense) of ‘Serres’.
 
Ans :- mysql>  select cust.* from customers as cust where RATING >= Any (select RATING from customers as cust2 Inner join salespeople as sp on sp.SNAME="serres" and sp.SNUM=cust2.SNUM  );

49) Write two queries that will produce all orders taken on October 3 or October 4.

Ans :- mysql> select * from orders where ODATE = '10,03,90' or odate = '10,04,90' ;
Empty set (0.00 sec)

50) Find only those customers whose ratings are higher than every customer in Rome.

Ans :- mysql> select * from customers where Rating > Any (select max(RATING) from customers where CITY = 'Rome');
+------+----------+---------+--------+------+
| cnum | cname    | city    | rating | snum |
+------+----------+---------+--------+------+
| 2004 | grass    | berlin  |    300 | 1002 |
| 2008 | cisneros | sanjose |    300 | 1007 |
+------+----------+---------+--------+------+
2 rows in set (0.01 sec)

51)	Write a query on the Customers table whose output will exclude all customers with a rating<= 100.00, unless they are located in Rome.
Ans :- mysql> select * from customers where rating<=100 or city = 'rome' ;
+------+----------+--------+--------+------+
| cnum | cname    | city   | rating | snum |
+------+----------+--------+--------+------+
| 2001 | hoffman  | london |    100 | 1001 |
| 2002 | giovanni | rome   |    200 | 1003 |
| 2006 | clemens  | london |    100 | 1001 |
| 2007 | pereira  | rome   |    100 | 1004 |
+------+----------+--------+--------+------+
4 rows in set (0.00 sec)

52)	Find all rows from the customer’s table for which the salesperson number is 1001.

Ans :- mysql> Select * from customers where snum=1001;
+------+---------+--------+--------+------+
| cnum | cname   | city   | rating | snum |
+------+---------+--------+--------+------+
| 2001 | hoffman | london |    100 | 1001 |
| 2006 | clemens | london |    100 | 1001 |
+------+---------+--------+--------+------+
2 rows in set (0.00 sec)

53)	Find the total amount in orders for each salesperson where their total of amounts are greater than the amount of the largest order in the table.

Ans :- mysql> select salespeople.SNAME, sum(orders.AMT) as TotalAmount from salespeople, orders where salespeople.SNUM = orders.SNUM  group by orders.SNUM having max(AMT)<sum(AMT);
+--------+-------------+
| SNAME  | TotalAmount |
+--------+-------------+
| peel   |    15382.07 |
| seeres |     6546.15 |
| rifkin |     1116.85 |
+--------+-------------+
3 rows in set (0.00 sec)

54)	Write a query that selects all orders save those with zeroes or NULL in the amount file.

Ans :- mysql> select * from orders where amt = null or amt=0;
Empty set (0.00 sec)

55)	Produce all combinations of salespeople and customer names such that the former precedes the latter alphabetically, and the latter has a rating of less than 200.

Ans :- mysql> SELECT Customers.cname, salespeople.sname , customers.rating FROM Customers CROSS JOIN salespeople WHERE customers.rating<200 order by Customers.cname, salespeople.sname;
+---------+---------+--------+
| cname   | sname   | rating |
+---------+---------+--------+
| clemens | AlexRod |    100 |
| clemens | fran    |    100 |
| clemens | motika  |    100 |
| clemens | peel    |    100 |
| clemens | rifkin  |    100 |
| clemens | seeres  |    100 |
| hoffman | AlexRod |    100 |
| hoffman | fran    |    100 |
| hoffman | motika  |    100 |
| hoffman | peel    |    100 |
| hoffman | rifkin  |    100 |
| hoffman | seeres  |    100 |
| pereira | AlexRod |    100 |
| pereira | fran    |    100 |
| pereira | motika  |    100 |
| pereira | peel    |    100 |
| pereira | rifkin  |    100 |
| pereira | seeres  |    100 |
+---------+---------+--------+
18 rows in set (0.00 sec)

56)	Find all salespeople name and commission.

Ans :- mysql> select sname , comm from salespeople order by comm;
+---------+------+
| sname   | comm |
+---------+------+
| AlexRod | 10   |
| motika  | 11   |
| peel    | 12   |
| seeres  | 13   |
| rifkin  | 15   |
| fran    | 25   |
+---------+------+
6 rows in set (0.00 sec)

57)	Write a query that produces the names and cities of all customers with the same rating as Hoffman. Write the query using Hoffman’s cnum rather than his rating, so that it would still be usable if his rating is changed.

Ans :- mysql> select cname , city, rating from customers where rating = (select rating from customers where cname = 'hoffman');
+---------+--------+--------+
| cname   | city   | rating |
+---------+--------+--------+
| hoffman | london |    100 |
| clemens | london |    100 |
| pereira | rome   |    100 |
+---------+--------+--------+
3 rows in set (0.00 sec)

58)	Find all salespeople for whom there are customers that follow them in alphabetical order.

Ans :- mysql> SELECT s.sname,c.cname FROM customers c, salespeople s WHERE s.snum=c.snum GROUP BY s.sname,c.cname HAVING c.cname >= s.sname;
+---------+----------+
| sname   | cname    |
+---------+----------+
| AlexRod | giovanni |
| motika  | pereira  |
+---------+----------+
2 rows in set (0.00 sec)

59)	Write a query that produces the names and ratings of all customers who have average orders.

 Ans :-mysql> SELECT CNAME,RATING  FROM customers  INNER JOIN orders ON customers.cnum=orders.cnum WHERE AMT>(SELECT AVG(AMT) FROM orders )GROUP BY CNAME;
+---------+--------+
| CNAME   | RATING |
+---------+--------+
| clemens |    100 |
| liu     |    200 |
+---------+--------+
2 rows in set (0.00 sec)

60)	Find the SUM of all Amounts from the orders table.

Ans :- mysql> select sum(amt) as total_sum from orders;
+-----------+
| total_sum |
+-----------+
|   26658.4 |
+-----------+
1 row in set (0.00 sec)

61)	Write a SELECT command that produces the order number, amount, and the date from rows in the order table.

Ans :- mysql> select onum , amt , odate from orders;
+------+---------+----------+
| onum | amt     | odate    |
+------+---------+----------+
| 3001 | 18.69   | 10/03/90 |
| 3003 | 767.19  | 10/03/90 |
| 3002 | 1900.10 | 10/03/90 |
| 3005 | 5160.45 | 10/03/90 |
| 3006 | 1098.16 | 10/03/90 |
| 3009 | 1713.23 | 10/04/90 |
| 3007 | 75.75   | 10/04/90 |
| 3008 | 4723.00 | 10/05/90 |
| 3010 | 1309.95 | 10/06/90 |
| 3011 | 9891.88 | 10/06/90 |
+------+---------+----------+
10 rows in set (0.00 sec)


62)	Count the number of non NULL rating fields in the Customers table (including repeats).

Ans:- mysql> select count(rating) from customers where rating is not  null;
+---------------+
| count(rating) |
+---------------+
|             7 |
+---------------+
1 row in set (0.01 sec)

63)	Write a query that gives the names of both the salesperson and the customer for each order after the order number.

Ans :-  mysql> select ord.ONUM ,sp.SNAME,cust.CName from salespeople as sp Inner join orders as ord on sp.SNUM=ord.SNUM Inner join customers as cust  on ord.CNUM= cust.CNUM;
+------+---------+----------+
| ONUM | SNAME   | CName    |
+------+---------+----------+
| 3001 | rifkin  | cisneros |
| 3003 | peel    | hoffman  |
| 3002 | motika  | pereira  |
| 3005 | seeres  | liu      |
| 3006 | rifkin  | cisneros |
| 3009 | AlexRod | giovanni |
| 3007 | seeres  | grass    |
| 3008 | peel    | clemens  |
| 3010 | seeres  | grass    |
| 3011 | peel    | clemens  |
+------+---------+----------+
10 rows in set (0.00 sec)

64)	List the commissions of all salespeople servicing customers in London.

Ans :- mysql> select salespeople.comm,salespeople.sname , customers.cname, customers.city from salespeople inner join customers where customers.city = 'london';
+------+---------+---------+--------+
| comm | sname   | cname   | city   |
+------+---------+---------+--------+
| 12   | peel    | hoffman | london |
| 13   | seeres  | hoffman | london |
| 11   | motika  | hoffman | london |
| 10   | AlexRod | hoffman | london |
| 15   | rifkin  | hoffman | london |
| 25   | fran    | hoffman | london |
| 12   | peel    | clemens | london |
| 13   | seeres  | clemens | london |
| 11   | motika  | clemens | london |
| 10   | AlexRod | clemens | london |
| 15   | rifkin  | clemens | london |
| 25   | fran    | clemens | london |
+------+---------+---------+--------+
12 rows in set (0.00 sec)

65)	Write a query using ANY or ALL that will find all salespeople who have no customers located in their city.

Ans :- mysql> select sp.sname, sp.city, cust.cname, cust.city as cus_city from salespeople sp,customers cust where sp.snum=cust.snum and sp.city != cust.city;
+---------+-----------+----------+----------+
| sname   | city      | cname    | cus_city |
+---------+-----------+----------+----------+
| AlexRod | new york  | giovanni | rome     |
| seeres  | sanjoes   | liu      | sanjose  |
| seeres  | sanjoes   | grass    | berlin   |
| rifkin  | barcelona | cisneros | sanjose  |
| motika  | london    | pereira  | rome     |
+---------+-----------+----------+----------+
5 rows in set (0.01 sec)


66)	Write a query using the EXISTS operator that selects all salespeople with customers located in their cities who are not assigned to them.

Ans :- mysql> SELECT s.SNAME ,s.CITY , c.CNAME,c.CITY FROM SalesPeople s, Customers c WHERE EXISTS (SELECT CNUM FROM Customers WHERE s.SNUM <> c.SNUM AND s.CITY = c.CITY);
+--------+--------+---------+--------+
| SNAME  | CITY   | CNAME   | CITY   |
+--------+--------+---------+--------+
| motika | london | hoffman | london |
| fran   | london | hoffman | london |
| motika | london | clemens | london |
| fran   | london | clemens | london |
+--------+--------+---------+--------+
4 rows in set (0.00 sec)

67)	Write a query that selects all customers serviced by Peel or Motika. (Hint: The snum field relates the 2 tables to one another.)

Ans :-mysql> select customers.cname, salespeople.sname from customers inner join salespeople on salespeople.sname='motika' or salespeople.sname='peel' order by salespeople.sname ;
+----------+--------+
| cname    | sname  |
+----------+--------+
| pereira  | motika |
| grass    | motika |
| hoffman  | motika |
| cisneros | motika |
| liu      | motika |
| clemens  | motika |
| giovanni | motika |
| cisneros | peel   |
| liu      | peel   |
| clemens  | peel   |
| giovanni | peel   |
| pereira  | peel   |
| grass    | peel   |
| hoffman  | peel   |
+----------+--------+
14 rows in set (0.00 sec)

68)	Count the number of salespeople registering orders for each day. (If a salesperson has more than one order on a given day, he or she should be counted only once.)

Ans :- mysql> select count(onum) as Order_no , odate , snum from orders group by odate;
+----------+----------+------+
| Order_no | odate    | snum |
+----------+----------+------+
|        5 | 10/03/90 | 1007 |
|        2 | 10/04/90 | 1003 |
|        1 | 10/05/90 | 1001 |
|        2 | 10/06/90 | 1002 |
+----------+----------+------+
4 rows in set (0.00 sec)

69)	Find all orders attributed to salespeople who live in London.

Ans :- mysql> select * from orders inner join customers on orders.cnum=customers.cnum  inner join salespeople on orders.snum = salespeople.snum where salespeople.city='london';
+------+---------+----------+------+------+------+---------+--------+--------+------+------+--------+--------+------+
| onum | amt     | odate    | cnum | snum | cnum | cname   | city   | rating | snum | snum | sname  | city   | comm |
+------+---------+----------+------+------+------+---------+--------+--------+------+------+--------+--------+------+
| 3003 | 767.19  | 10/03/90 | 2001 | 1001 | 2001 | hoffman | london |    100 | 1001 | 1001 | peel   | london | 12   |
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 | 2007 | pereira | rome   |    100 | 1004 | 1004 | motika | london | 11   |
| 3008 | 4723.00 | 10/05/90 | 2006 | 1001 | 2006 | clemens | london |    100 | 1001 | 1001 | peel   | london | 12   |
| 3011 | 9891.88 | 10/06/90 | 2006 | 1001 | 2006 | clemens | london |    100 | 1001 | 1001 | peel   | london | 12   |
+------+---------+----------+------+------+------+---------+--------+--------+------+------+--------+--------+------+
4 rows in set (0.00 sec)


70)	Find all orders by customers not located in the same cities as their salespeople.

Ans :- mysql> select orders.onum,salespeople.sname,orders.amt,orders.odate,salespeople.city,customers.city from orders inner join salespeople on orders.snum = salespeople.snum inner join customers on customers.cnum = orders.cnum where salespeople.city != customers.city;
+------+---------+---------+----------+-----------+---------+
| onum | sname   | amt     | odate    | city      | city    |
+------+---------+---------+----------+-----------+---------+
| 3001 | rifkin  | 18.69   | 10/03/90 | barcelona | sanjose |
| 3002 | motika  | 1900.10 | 10/03/90 | london    | rome    |
| 3005 | seeres  | 5160.45 | 10/03/90 | sanjoes   | sanjose |
| 3006 | rifkin  | 1098.16 | 10/03/90 | barcelona | sanjose |
| 3009 | AlexRod | 1713.23 | 10/04/90 | new york  | rome    |
| 3007 | seeres  | 75.75   | 10/04/90 | sanjoes   | berlin  |
| 3010 | seeres  | 1309.95 | 10/06/90 | sanjoes   | berlin  |
+------+---------+---------+----------+-----------+---------+
7 rows in set (0.00 sec)

71)	Find all salespeople who have customers with more than one current order.

Ans :- mysql> select sp.sname,count(cust.cnum) from salespeople sp  Inner join customers cust on sp.snum=cust.cnum group by cust.snum having count(cust.snum)>1;
+--------+------------------+
| sname  | count(cust.cname)|
+--------+------------------+
| peel   |                2 |
| seeres |                2 |
+--------+------------------+
2 rows in set (0.00 sec)

72)	Write a query that extracts from the customer’s table every customer assigned to a salesperson, who is currently having at least one another customer(besides the customer being selected) with orders in the Orders Table.

Ans:- mysql> select (select sname from salespeople where snum=cust.snum ) as salespeoplesHavingmoreCustomers from customers as cust  group by snum having count(snum)>1;
+---------------------------------+
| salespeoplesHavingmoreCustomers |
+---------------------------------+
| peel                            |
| seeres                          |
+---------------------------------+
2 rows in set (0.01 sec)

73)	Write a query on the customer’s table that will find the highest rating in each city. Put the output in this form: for the city (city), the highest rating is (rating).

Ans :- mysql> select  city as "city", max(rating) as 'rating' from customers group by city;
+---------+--------+
| city    | rating |
+---------+--------+
| berlin  |    300 |
| london  |    100 |
| rome    |    200 |
| sanjose |    300 |
+---------+--------+
4 rows in set (0.00 sec)
 

74)	Write a query that will produce the snum values of all salespeople with orders, having amt greater than 1000 in the Orders Table(without repeats).

Ans:-mysql> select Snum,ONUM from orders where amt >1000 group by Snum order by Snum ;
+------+------+
| Snum | ONUM |
+------+------+
| 1001 | 3008 |
| 1002 | 3005 |
| 1003 | 3009 |
| 1004 | 3002 |
| 1007 | 3006 |
+------+------+
5 rows in set (0.00 sec)

75)	Write a query that lists customers in a descending order of rating. Output the rating field first, followed by the customer’s names and numbers.

Ans :-mysql> select RATING,CNAME,Cnum from customers order by Rating desc;
+--------+----------+------+
| RATING | CNAME    | Cnum |
+--------+----------+------+
|    300 | grass    | 2004 |
|    300 | cisneros | 2008 |
|    200 | giovanni | 2002 |
|    200 | liu      | 2003 |
|    100 | hoffman  | 2001 |
|    100 | clemens  | 2006 |
|    100 | pereira  | 2007 |
+--------+----------+------+
7 rows in set (0.00 sec)

76)	Find the average commission for salespeople in London.

Ans:-mysql> select avg(COMM) from salespeople where city="london";
+-----------+
| avg(COMM) |
+-----------+
|        16 |
+-----------+
1 row in set (0.01 sec)

77)	Find all orders credited to the same salesperson who services Hoffman.(cnum 2001).

Ans:-

78)	Find all salespeople whose commission is in between 0.10 and 0.12(both inclusive).

Ans:-mysql> select * from salespeople where COMM between 10 AND 12;
+------+---------+----------+------+
| snum | sname   | city     | comm |
+------+---------+----------+------+
| 1001 | peel    | london   | 12   |
| 1004 | motika  | london   | 11   |
| 1003 | AlexRod | new york | 10   |
+------+---------+----------+------+
3 rows in set (0.01 sec)

79)	Write a query that will give you the names and cities of all salespeople in London with a commission above 0.10.

Ans:-mysql> select SName,CITY from salespeople as sp where city="london" and COMM >10;
+--------+--------+
| SName  | CITY   |
+--------+--------+
| peel   | london |
| motika | london |
| fran   | london |
+--------+--------+
3 rows in set (0.00 sec)

80)	 Write a query that selects each customer’s smallest order.

Ans:-mysql> select ord.*,min(ord.AMT) as SmallestOrderOfCustommer from customers as cust natural join orders as ord  group by cust.CName ;
+------+---------+----------+------+------+--------------------------+
| onum | amt     | odate    | cnum | snum | SmallestOrderOfCustommer |
+------+---------+----------+------+------+--------------------------+
| 3001 | 18.69   | 10/03/90 | 2008 | 1007 | 1098.16                  |
| 3008 | 4723.00 | 10/05/90 | 2006 | 1001 | 4723.00                  |
| 3009 | 1713.23 | 10/04/90 | 2002 | 1003 | 1713.23                  |
| 3007 | 75.75   | 10/04/90 | 2004 | 1002 | 1309.95                  |
| 3003 | 767.19  | 10/03/90 | 2001 | 1001 | 767.19                   |
| 3005 | 5160.45 | 10/03/90 | 2003 | 1002 | 5160.45                  |
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 | 1900.10                  |
+------+---------+----------+------+------+--------------------------+
7 rows in set (0.00 sec)

81) Write a query that selects the first customer in alphabetical order whose name begins with ‘G’.

 
 Ans :- mysql> select * from customers where CNAME like 'G%' order by cname asc limit 1;
+------+----------+------+--------+------+
| cnum | cname    | city | rating | snum |
+------+----------+------+--------+------+
| 2002 | giovanni | rome |    200 | 1003 |
+------+----------+------+--------+------+
1 row in set (0.00 sec)


82) Write a query that counts the number of different non NULL city values in the customers table.
  
 Ans :- mysql> select count(CITY) from customers where city is not null;
+-------------+
| count(CITY) |
+-------------+
|           7 |
+-------------+
1 row in set (0.00 sec)

83) Find the average amount from the Orders Table.

 Ans :-mysql> Select avg(AMT) from orders;
+----------+
| avg(AMT) |
+----------+
|  2665.84 |
+----------+
1 row in set (0.00 sec)

84) Find all customers who are not located in SanJose and whose rating is above 200.

 Ans :-mysql> Select * from customers Where City != 'SanJose' AND rating > 200;
+------+-------+--------+--------+------+
| cnum | cname | city   | rating | snum |
+------+-------+--------+--------+------+
| 2004 | grass | berlin |    300 | 1002 |
+------+-------+--------+--------+------+
1 row in set (0.00 sec)

85) Give a simpler way to write this query.SELECT snum, sname, city, comm FROM salespeople WHERE (comm > + 0.12 OR comm < 0.14);

 Ans :-mysql> select * from salespeople where (comm>12 or comm<14);
+------+---------+-----------+------+
| snum | sname   | city      | comm |
+------+---------+-----------+------+
| 1001 | peel    | london    | 12   |
| 1002 | seeres  | sanjoes   | 13   |
| 1004 | motika  | london    | 11   |
| 1003 | AlexRod | new york  | 10   |
| 1007 | rifkin  | barcelona | 15   |
| 1008 | fran    | london    | 25   |
+------+---------+-----------+------+
6 rows in set (0.00 sec)


86) Which salespersons attend to customers not in the city they have been assigned to?

 Ans :-mysql>  select sp.SNAME from salespeople as sp Inner Join  customers as cust on  sp.SNUM=cust.SNUM and sp.city!=cust.city group by cust.SNUM;
+---------+
| SNAME   |
+---------+
| seeres  |
| AlexRod |
| motika  |
| rifkin  |
+---------+
4 rows in set (0.00 sec)

87) Which salespeople get commission greater than 0.11 are serving customers rated less than 250?
 
Ans :-mysql> select * from salespeople, customers where salespeople.SNUM = customers.SNUM And salespeople.COMM > 10 AND customers.RATING < 250;
+------+--------+---------+------+------+---------+---------+--------+------+
| snum | sname  | city    | comm | cnum | cname   | city    | rating | snum |
+------+--------+---------+------+------+---------+---------+--------+------+
| 1001 | peel   | london  | 12   | 2001 | hoffman | london  |    100 | 1001 |
| 1002 | seeres | sanjoes | 13   | 2003 | liu     | sanjose |    200 | 1002 |
| 1001 | peel   | london  | 12   | 2006 | clemens | london  |    100 | 1001 |
| 1004 | motika | london  | 11   | 2007 | pereira | rome    |    100 | 1004 |
+------+--------+---------+------+------+---------+---------+--------+------+
4 rows in set (0.00 sec)

88) Which salespeople have been assigned to the same city but get different commission percentages?

 Ans :-

89) Which salesperson has earned the maximum commission?
 
Ans :-mysql> Select SNAME,COMM from salespeople where COMM = (select MAX(COMM) from salespeople);
+-------+------+
| SNAME | COMM |
+-------+------+
| fran  | 25   |
+-------+------+
1 row in set (0.00 sec)

90) Does the customer who has placed the maximum number of orders have the maximum rating?

 Ans :-

91) List all customers in descending order of customer rating. 

 Ans :- mysql> select * from customers order by Rating desc;
+------+----------+---------+--------+------+
| cnum | cname    | city    | rating | snum |
+------+----------+---------+--------+------+
| 2004 | grass    | berlin  |    300 | 1002 |
| 2008 | cisneros | sanjose |    300 | 1007 |
| 2002 | giovanni | rome    |    200 | 1003 |
| 2003 | liu      | sanjose |    200 | 1002 |
| 2001 | hoffman  | london  |    100 | 1001 |
| 2006 | clemens  | london  |    100 | 1001 |
| 2007 | pereira  | rome    |    100 | 1004 |
+------+----------+---------+--------+------+
7 rows in set (0.00 sec)

92) On which days has Hoffman placed orders? 

 Ans :-mysql> select ord.ODate,cust.Cname,ord.Onum from customers as cust Inner join orders as ord on cust.CNAME='Hoffman' and cust.Cnum=ord.Cnum;
+----------+---------+------+
| ODate    | Cname   | Onum |
+----------+---------+------+
| 10/03/90 | hoffman | 3003 |
+----------+---------+------+
1 row in set (0.00 sec)

93) Which salesmen have no orders between 10/03/1990 and 10/05/1990? 

 Ans :-mysql> select sp.SName from salespeople as sp Inner join orders as ord on not ord.Odate between 2019-8-02 and 2019-10-02 and sp.Snum=ord.Snum group by ord.Snum;
+---------+
| SName   |
+---------+
| peel    |
| seeres  |
| AlexRod |
| motika  |
| rifkin  |
+---------+
5 rows in set (0.00 sec)

94) How many salespersons have succeeded in getting orders? 

 Ans :-mysql> select count(distinct(sp.snum)) from salespeople as sp natural join orders as ord ;
+--------------------------+
| count(distinct(sp.snum)) |
+--------------------------+
|                        5 |
+--------------------------+
1 row in set (0.00 sec)

95) How many customers have placed orders? 

 Ans :- mysql> select count(distinct(CNUM)) from orders;
+-----------------------+
| count(distinct(CNUM)) |
+-----------------------+
|                     7 |
+-----------------------+
1 row in set (0.00 sec)

96) On which date has each salesman booked an order of maximum value? 

 Ans :-mysql> select odd.SNUM,(select SNAME from salespeople where Snum=odd.Snum) as SalesPersom, max(Amt) MaxAmount,odd.Onum from (select * from orders as ord group by Odate) as odd group by odd.Snum;
+------+-------------+-----------+------+
| SNUM | SalesPersom | MaxAmount | Onum |
+------+-------------+-----------+------+
| 1001 | peel        | 4723.00   | 3008 |
| 1002 | seeres      | 1309.95   | 3010 |
| 1003 | AlexRod     | 1713.23   | 3009 |
| 1007 | rifkin      | 18.69     | 3001 |
+------+-------------+-----------+------+
4 rows in set (0.00 sec)

97) Who is the most successful salesperson? 
 Ans :-
98) Which customers have the same rating? 

 Ans :-mysql> select cust1.Cname,cust2.Cname,cust1.Rating,cust2.rating from customers as cust1 Inner Join customers as cust2 on cust1.Cnum!=cust2.Cnum and cust1.rating=cust2.rating;
+----------+----------+--------+--------+
| Cname    | Cname    | Rating | rating |
+----------+----------+--------+--------+
| clemens  | hoffman  |    100 |    100 |
| pereira  | hoffman  |    100 |    100 |
| liu      | giovanni |    200 |    200 |
| giovanni | liu      |    200 |    200 |
| cisneros | grass    |    300 |    300 |
| hoffman  | clemens  |    100 |    100 |
| pereira  | clemens  |    100 |    100 |
| grass    | cisneros |    300 |    300 |
| hoffman  | pereira  |    100 |    100 |
| clemens  | pereira  |    100 |    100 |
+----------+----------+--------+--------+
10 rows in set (0.00 sec)

99) Find all orders greater than the average for October 4th. 

 Ans :-mysql> SELECT * FROM Orders WHERE AMT >(SELECT  avg(AMT) FROM Orders WHERE ODATE = '10/04/90');
+------+---------+----------+------+------+
| onum | amt     | odate    | cnum | snum |
+------+---------+----------+------+------+
| 3002 | 1900.10 | 10/03/90 | 2007 | 1004 |
| 3005 | 5160.45 | 10/03/90 | 2003 | 1002 |
| 3006 | 1098.16 | 10/03/90 | 2008 | 1007 |
| 3009 | 1713.23 | 10/04/90 | 2002 | 1003 |
| 3008 | 4723.00 | 10/05/90 | 2006 | 1001 |
| 3010 | 1309.95 | 10/06/90 | 2004 | 1002 |
| 3011 | 9891.88 | 10/06/90 | 2006 | 1001 |
+------+---------+----------+------+------+
7 rows in set (0.00 sec)


100) List all customers with ratings above Grass’s average. 

 Ans :- mysql> select * from customers where rating >= (select rating from customers where cname = 'Grass');
+------+----------+---------+--------+------+
| cnum | cname    | city    | rating | snum |
+------+----------+---------+--------+------+
| 2004 | grass    | berlin  |    300 | 1002 |
| 2008 | cisneros | sanjose |    300 | 1007 |
+------+----------+---------+--------+------+
2 rows in set (0.00 sec)


101) Which customers have above average orders? 

 Ans :-

102) Select the total amount in orders for each salesperson for which the total is greater than the amount of the largest order in the table. 103) Give names and numbers of all salespersons that have more than one customer? 
 
 Ans :-mysql> SELECT o.ONUM, s.SNUM, s.SNAME, sum(AMT) FROM Salespeople s, Orders o WHERE s.SNUM = o.SNUM GROUP BY o.SNUM HAVING sum(AMT) > (SELECT max(AMT) FROM Orders);
+------+------+-------+----------+
| ONUM | SNUM | SNAME | sum(AMT) |
+------+------+-------+----------+
| 3003 | 1001 | peel  | 15382.07 |
+------+------+-------+----------+
1 row in set (0.00 sec)


104) Select all salespeople by name and number who have customers in their city whom they don’t service. 

 Ans :- mysql> select sname, snum from salespeople where snum in ( select snum from customers group by snum having count(snum)>1);
+--------+------+
| sname  | snum |
+--------+------+
| peel   | 1001 |
| seeres | 1002 |
+--------+------+
2 rows in set (0.01 sec)

105) Does the total amount in orders by customer in Rome and London, exceed the commission paid to salesperson in London, and New York by more than 5 times? 

 Ans :-

106) Which are the date, order number, amt and city for each salesperson (by name) for themaximum order he has obtained?  

 Ans :-  mysql>  select odate, onum, amt, city,sp.SName from orders , salespeople as sp where amt=(select max(amt)from orders);
+----------+------+---------+-----------+---------+
| odate    | onum | amt     | city      | SName   |
+----------+------+---------+-----------+---------+
| 10/06/90 | 3011 | 9891.88 | london    | peel    |
| 10/06/90 | 3011 | 9891.88 | sanjoes   | seeres  |
| 10/06/90 | 3011 | 9891.88 | london    | motika  |
| 10/06/90 | 3011 | 9891.88 | new york  | AlexRod |
| 10/06/90 | 3011 | 9891.88 | barcelona | rifkin  |
| 10/06/90 | 3011 | 9891.88 | london    | fran    |
+----------+------+---------+-----------+---------+
6 rows in set (0.00 sec)

107) Which salesperson is having lowest commission?

 Ans :- mysql> select * from salespeople where COMM = (select MIN(COMM) from salespeople);
+------+---------+----------+------+
| snum | sname   | city     | comm |
+------+---------+----------+------+
| 1003 | AlexRod | new york | 10   |
+------+---------+----------+------+
1 row in set (0.00 sec)

