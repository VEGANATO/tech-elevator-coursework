-- Write queries to return the following:
-- The following changes are applied to the "pagila" database.**

-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
insert into actor (first_name, last_name) values ('HAMPTON', 'AVENUE');
insert into actor (first_name, last_name) values ('LISA', 'BYWAY');

select * from actor where first_name = 'HAMPTON' AND last_name = 'AVENUE';
select * from actor where first_name = 'LISA' AND last_name = 'BYWAY';

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in 
-- ancient Greece", to the film table. The movie was released in 2008 in English. 
-- Since its an epic, the run length is 3hrs and 18mins. There are no special 
-- features, the film speaks for itself, and doesn't need any gimmicks.
--INSERT INTO film (film_id, title, description, release_year, language_id, original_language_id, rental_duration, rental_rate, length, replacement_cost, rating) VALUES (141, 'CHICAGO NORTH', 'A Fateful Yarn of a Mad Cow And a Waitress who must Battle a Student in California', 2006, 1, NULL, 6, 4.99, 185, 11.99, 'PG-13');


insert into film (title, description, release_year, language_id, length)
values ('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198);

select * from film where title = 'Euclidean PI';

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly 
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
insert into film_actor (film_id, actor_id)
values (1001, 201);

insert into film_actor (film_id, actor_id)
values (1001, 202);

select * from film_actor where film_id = 1001;

-- 4. Add Mathmagical to the category table.

insert into category (name)
values ('Mathmagical');

select * from category where name = 'Mathmagical';

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI", 
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"

insert into film_category (film_id, category_id)
values (1001, 17);

update film_category
set category_id = 17
where film_id in
 (select film_id from film where title in ('Euclidean PI', 'EGG IGBY', 'KARATE MOON', 'RANDOM GO', 'YOUNG LANGUAGE'));
 
 select * from film
 join film_category on film.film_id = film_category.film_id
 join category on film_category.category_id = category.category_id
 where category.name = 'Mathmagical';

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films 
-- accordingly.
-- (5 rows affected)

update film
set rating = 'G'
where film_id in
 (select film_id from film_category where film_category.category_id = 17);
 
 select * from film
 join film_category on film.film_id = film_category.film_id
 join category on film_category.category_id = category.category_id
 where category.name = 'Mathmagical';

-- 7. Add a copy of "Euclidean PI" to all the stores.
INSERT INTO inventory (film_id, store_id) VALUES (1001, 1);
INSERT INTO inventory (film_id, store_id) VALUES (1001, 2);

select * from inventory where film_id = 1001;

-- 8. The Feds have stepped in and have impounded all copies of the pirated film, 
-- "Euclidean PI". The film has been seized from all stores, and needs to be 
-- deleted from the film table. Delete "Euclidean PI" from the film table. 
-- (Did it succeed? Why?)

delete from film
where film_id = 1001 and title='Euclidean PI';
-- did not succeed, delete "violates foreign key constraint "film_actor_film_id_fkey" on table "film_actor""

-- 9. Delete Mathmagical from the category table. 
-- (Did it succeed? Why?)

delete from category
where name = 'Mathmagical';
--ERROR: update or delete on table "category" violates foreign key constraint "film_category_category_id_fkey" on table "film_category"
-- Detail: Key (category_id)=(17) is still referenced from table "film_category".

-- 10. Delete all links to Mathmagical in the film_category tale. 
-- (Did it succeed? Why?)

delete from film_category
where category_id in
 (select category.category_id from category where category.name = 'Mathmagical');

 select * from film
 join film_category on film.film_id = film_category.film_id
 join category on film_category.category_id = category.category_id
 where category.name = 'Mathmagical';
 
 select * from film where title = 'Euclidean PI';
 -- It did succeed, I think because nothing is referenced from the film_category table

-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI". 
-- (Did either deletes succeed? Why?)

delete from category
where category.name = 'Mathmagical';

delete from film
where title = 'Euclidean PI';

select * from category;
select * from film where title = 'Euclidean PI';
-- The delete did not succeed, the film_id is still referenced by film_actor table.

-- 12. Check database metadata to determine all constraints of the film id, and 
-- describe any remaining adjustments needed before the film "Euclidean PI" can 
-- be removed from the film table.

-- We would have to delete the two film_actor insertions we made early in the exercises.
-- I believe we would also have to delete the two inventory insertions we made which reference the film_id