select count(*) as count
from ecoli_data e
where (e.genotype & 0b0010) = 0 and (e.genotype & (0b0100|0b0001)) != 0;