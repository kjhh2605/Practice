select c2.id
from ecoli_data e 
join ecoli_data c on e.id = c.parent_id
join ecoli_data c2 on c.id = c2.parent_id
where e.parent_id is null
order by c2.id
 