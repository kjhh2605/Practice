with recursive e_generation as(
    select id, parent_id, 1 as generation
    from ecoli_data 
    where parent_id is null
    
    union all
    
    select c.id, c.parent_id, eg.generation+1
    from ecoli_data c join e_generation eg on c.parent_id = eg.id
)

select count(*) as count , generation
from e_generation
where id not in(
    select distinct parent_id from ecoli_data where parent_id is not null)
group by generation
order by generation asc;
