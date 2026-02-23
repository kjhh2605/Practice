select id,
case 
    when type <= 0.25 then 'LOW'
    when type <= 0.5 then 'MEDIUM'
    when type <= 0.75 then 'HIGH'
    else 'CRITICAL'
end as colony_name
from (
    select id, percent_rank() over (order by size_of_colony asc) as type from ecoli_data
) as t
order by id asc;