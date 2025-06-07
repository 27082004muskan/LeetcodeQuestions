# Write your MySQL query statement below

# avg(timestamp)  , ROUND(3)

-- SELECT machine_id  FROM Activity 
-- WHERE total_time = timestamp.end - timestamp.start 

-- totaltime/ number of processes 

select a1.machine_id, round(avg(a2.timestamp-a1.timestamp), 3) as processing_time 
from Activity a1
join Activity a2 
on a1.machine_id=a2.machine_id and a1.process_id=a2.process_id
and a1.activity_type='start' and a2.activity_type='end'
group by a1.machine_id ;

