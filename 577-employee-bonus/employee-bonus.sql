# Write your MySQL query statement below

SELECT ei.name , b.bonus FROM Employee as ei
LEFT JOIN Bonus as b
ON ei.empId = b.empId
WHERE bonus<1000 OR bonus is NULL;