-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
--    Rows: 30
select film.title, actor.first_name, actor.last_name from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
where actor.first_name = 'NICK' AND actor.last_name = 'STALLONE'

-- 2. All of the films that Rita Reynolds has appeared in
--    Rows: 20
select film.title, actor.first_name, actor.last_name from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
where actor.first_name = 'RITA' AND actor.last_name = 'REYNOLDS'

-- 3. All of the films that Judy Dean or River Dean have appeared in
--    Rows: 46
select film.title, actor.first_name, actor.last_name from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
where (actor.first_name = 'JUDY' AND actor.last_name = 'DEAN') OR (actor.first_name = 'RIVER' AND actor.last_name = 'DEAN')
-- 4. All of the the ‘Documentary’ films
--    Rows: 68
select film.title, category.name from category
join film_category on category.category_id = film_category.category_id
join film on film_category.film_id = film.film_id
where category.name = 'Documentary'

-- 5. All of the ‘Comedy’ films
--    Rows: 58
select film.title, category.name from category
join film_category on category.category_id = film_category.category_id
join film on film_category.film_id = film.film_id
where category.name = 'Comedy'

-- 6. All of the ‘Children’ films that are rated ‘G’
--    Rows: 10 
select film.title, category.name, film.rating from category
join film_category on category.category_id = film_category.category_id
join film on film_category.film_id = film.film_id
where category.name = 'Children' AND film.rating = 'G'

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
--    Rows: 3
select film.title, category.name, film.rating from category
join film_category on category.category_id = film_category.category_id
join film on film_category.film_id = film.film_id
where category.name = 'Family' AND film.rating = 'G' AND film.length < 120

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
--    Rows: 9
select film.title, actor.first_name, actor.last_name, film.rating from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
where actor.first_name = 'MATTHEW' AND actor.last_name = 'LEIGH' AND film.rating = 'G'

-- 9. All of the ‘Sci-Fi’ films released in 2006
--    Rows: 61
select film.title, category.name, film.release_year from category
join film_category on category.category_id = film_category.category_id
join film on film_category.film_id = film.film_id
where category.name = 'Sci-Fi' and film.release_year = 2006

-- 10. All of the ‘Action’ films starring Nick Stallone
--     Rows: 2
select film.title, category.name, actor.first_name, actor.last_name from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
join film_category on film.film_id = film_category.film_id
join category on film_category.category_id = category.category_id
where actor.first_name = 'NICK' AND actor.last_name = 'STALLONE' AND category.name = 'Action'

-- 11. The address of all stores, including street address, city, district, and country
--     Rows: 2
select store.store_id, address.address, city.city, address.district, country.country from country
join city on country.country_id = city.country_id
join address on city.city_id = address.city_id
join store on address.address_id = store.address_id


-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
--     Rows: 2
select store.store_id, address.address, concat(staff.first_name, ' ', staff.last_name) as store_manager_name from country
join city on country.country_id = city.country_id
join address on city.city_id = address.city_id
join store on address.address_id = store.address_id
join staff on store.store_id = staff.store_id

-- 13. The first and last name of the top ten customers ranked by number of rentals 
--     Hint: #1 should be “ELEANOR HUNT” with 46 rentals, #10 should have 39 rentals
select count(*) as num_of_rentals, customer.customer_id, customer.first_name, customer.last_name from customer
join rental on customer.customer_id = rental.customer_id
group by customer.customer_id
order by num_of_rentals desc limit 10


-- 14. The first and last name of the top ten customers ranked by dollars spent 
--     Hint: #1 should be “KARL SEAL” with 221.55 spent, #10 should be “ANA BRADLEY” with 174.66 spent
select sum(amount) as dollars_spent, customer.customer_id, customer.first_name, customer.last_name from customer
join payment on customer.customer_id = payment.customer_id
group by customer.customer_id
order by dollars_spent desc limit 10

-- count(rental) as total_rentals, sum(amount)
-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store 
--     Hint: Store 1 has 7928 total rentals and Store 2 has 8121 total rentals
select store.store_id, address.address, count(rental) as total_rentals, sum(amount) as total_amount_of_sales, (sum(amount) / count(rental)) as avg_sales from store
join address on store.address_id = address.address_id
join inventory on store.store_id = inventory.store_id
join rental on inventory.inventory_id = rental.inventory_id
join payment on rental.rental_id = payment.rental_id
group by store.store_id, address.address


-- 16. The top ten film titles by number of rentals 
--     Hint: #1 should be “BUCKET BROTHERHOOD” with 34 rentals and #10 should have 31 rentals
select film.title, count(*) as num_of_rentals from film
join inventory on film.film_id = inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id
group by film.title
order by num_of_rentals desc limit 10

-- 17. The top five film categories by number of rentals 
--     Hint: #1 should be “Sports” with 1179 rentals and #5 should be “Family” with 1096 rentals
select category.name, count(*) as num_of_rentals from category
join film_category on category.category_id = film_category.category_id
join film on film_category.film_id = film.film_id
join inventory on film.film_id = inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id
group by category.name
order by num_of_rentals desc limit 5

-- 18. The top five Action film titles by number of rentals 
--     Hint: #1 should have 30 rentals and #5 should have 28 rentals
select film.title, category.name, count(*) as num_of_rentals from category
join film_category on category.category_id = film_category.category_id
join film on film_category.film_id = film.film_id
join inventory on film.film_id = inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id
where category.name = 'Action'
group by film.title, category.name
order by num_of_rentals desc limit 5

-- 19. The top 10 actors ranked by number of rentals of films starring that actor 
--     Hint: #1 should be “GINA DEGENERES” with 753 rentals and #10 should be “SEAN GUINESS” with 599 rentals
select actor.first_name, actor.last_name, count(*) as num_of_rentals from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
join inventory on film.film_id = inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id
group by actor.first_name, actor.last_name
order by num_of_rentals desc limit 10

-- 20. The top 5 “Comedy” actors ranked by number of rentals of films in the “Comedy” category starring that actor 
--     Hint: #1 should have 87 rentals and #5 should have 72 rentals
select actor.first_name, actor.last_name, category.name, count(*) as num_of_rentals from actor
join film_actor on actor.actor_id = film_actor.actor_id
join film on film_actor.film_id = film.film_id
join film_category on film.film_id = film_category.film_id
join category on film_category.category_id = category.category_id
join inventory on film.film_id = inventory.film_id
join rental on inventory.inventory_id = rental.inventory_id
where category.name = 'Comedy'
group by actor.first_name, actor.last_name, category.name
order by num_of_rentals desc limit 5