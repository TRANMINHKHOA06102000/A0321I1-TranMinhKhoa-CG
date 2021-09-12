use classicmodels;
-- xem có bao nhiêu trạng thái của đơn hàng
select `status` from orders 
group by status;
-- xem có bao nhiêu đơn đặt hàng trong mỗi trạng thái
select status, COUNT(*) as 'So luong status'
from orders
group by `status`;
-- thực hiện tính tổng số tiền của các đơn hàng theo trạng thái đặt hàng
select `status`, sum(quantityOrdered * priceEach) as amount
from orders 
inner join orderdetails on orders.ordernumber = orderdetails.ordernumber
group by `status`;
-- tính tổng tiền của từng đơn hàng
select orderNumber, sum(quantityOrdered * priceEach) as total
from orderdetails
group by orderNumber;
-- tổng doanh thu của những năm lớn hơn năm 2003.
select year(orderDate) as `year`, sum(quantityOrdered * priceEach) as total
from orders 
inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
where `status` = 'shipped'
group by `year`
having `year` > 2003;