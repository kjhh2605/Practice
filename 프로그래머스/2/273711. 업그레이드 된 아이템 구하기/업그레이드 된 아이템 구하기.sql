select i.item_id, i.item_name, i.rarity
from item_info i
where i.item_id in 
(select t.item_id
    from item_info i join item_tree t on i.item_id = t.item_id 
    where t.parent_item_id in (select i.item_id from item_info i where i.rarity = 'RARE'))
order by i.item_id desc
