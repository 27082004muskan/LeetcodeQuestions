

-- SELECT customer_id
-- FROM Customer
-- GROUP BY customer_id
-- HAVING COUNT(DISTINCT product_key) = (SELECT COUNT(*) FROM Product);

# Write your MySQL query statement below

SELECT customer_id  FROM Customer as c
LEFT JOIN Product AS p
ON c.product_key = p.product_key
group by c.customer_id
HAVING count(distinct c.product_key) = (select count(*) from Product);


