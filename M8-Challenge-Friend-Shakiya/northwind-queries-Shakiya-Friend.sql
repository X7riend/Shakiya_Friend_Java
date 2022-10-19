-- Write a SQL query to find the total rental amount paid for each film.
-- Your query should return the following columns:
-- film_id
-- total_amount


select f.film_id, sum(amount) as 'total_amount'
from payment p 
join rental r 
on (p.rental_id = r.rental_id )
	join inventory i 
	on (i.inventory_id = r.inventory_id)
	join film f 
	on f.film_id = i.film_id
	group by f.film_id;
	

-- Create a view named total_rental_amount using the query from the previous step
create view total_rental_amount as
select f.film_id, sum(amount) as 'total_amount'
from payment p 
join rental r 
on (p.rental_id = r.rental_id )
	join inventory i 
	on (i.inventory_id = r.inventory_id)
	join film f 
	on f.film_id = i.film_id
	group by f.film_id;

-- Write a SQL query to find the total number of copies in inventory for each film.
-- Your query should return the following columns:
-- film_id
-- total_copies
select film_id, count(inventory_id) as 'total_copies'
from inventory i 
group by film_id;


-- Create a view named total_film_copies using the query from the previous step.
create view total_film_copies as
select film_id, count(inventory_id) as 'total_copies'
from inventory i 
group by film_id;

-- Write a SQL query that combines data from the film table, 
-- the total_rental_amount view, and the total_film_copies view to 
-- find all films with a total rental amount greater than 200.00, and display the following columns: film_id,title,description
-- rental_duration
-- rental_rate
-- replacement_cost
-- rating
-- total_copies
-- total_amount

		
	select f.film_id, title, description, rental_duration, rental_rate, replacement_cost ,rating, tfc.total_copies as 'total_copies', tra.total_amount as 'total_amount' 
	from film f
	join total_film_copies tfc 
	on tfc.film_id = f.film_id 
	join total_rental_amount tra 
	on tra.film_id =tfc.film_id 
	where tra.total_amount > 200;

-- drop the total rental amount view 
-- group by on the total rental amount
-- mdofify last one


	
 



	




