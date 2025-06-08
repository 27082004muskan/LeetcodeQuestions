# Write your MySQL query statement below

SELECT s.student_id  , s.student_name , sub.subject_name ,
COUNT(e.subject_name) as attended_exams
FROM Students as s
CROSS JOIN Subjects as sub
LEFT JOIN Examinations as e 
ON s.student_id  = e.student_id  AND sub.subject_name  = e.subject_name 
GROUP BY s.student_id  , s.student_name , sub.subject_name
ORDER BY s.student_id , sub.subject_name  ;