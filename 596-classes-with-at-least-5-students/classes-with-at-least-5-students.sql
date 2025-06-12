# Write your MySQL query statement below
-- SELECT class FROM Courses 
-- WHERE LIMIT 5 ;



 SELECT class 
FROM Courses
GROUP BY class
HAVING count(*) >=5;

