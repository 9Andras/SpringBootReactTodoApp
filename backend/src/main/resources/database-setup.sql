/*TODO:UPDATE for actual DB population*/

insert into user_details (user_name, email_address, password, created_at, updated_at)
values
    ('user1', 'user1@example.com', 'PassWord1', current_timestamp, null),
    ('user2', 'user2@example.com', 'PassWord2', current_timestamp, null),
    ('user3', 'user3@example.com', 'PassWord3', current_timestamp, null),
    ('user4', 'user4@example.com', 'PassWord4', current_timestamp, null),
    ('user5', 'user5@example.com', 'PassWord5', current_timestamp, null),
    ('user6', 'user6@example.com', 'PassWord6', current_timestamp, null),
    ('user7', 'user7@example.com', 'PassWord7', current_timestamp, null),
    ('user8', 'user8@example.com', 'PassWord8', current_timestamp, null),
    ('user9', 'user9@example.com', 'PassWord9', current_timestamp, null),
    ('user10', 'user10@example.com', 'PassWord10', current_timestamp, null),
    ('user11', 'user11@example.com', 'PassWord11', current_timestamp, null),
    ('user12', 'user12@example.com', 'PassWord12', current_timestamp, null),
    ('user13', 'user13@example.com', 'PassWord13', current_timestamp, null),
    ('user14', 'user14@example.com', 'PassWord14', current_timestamp, null),
    ('user15', 'user15@example.com', 'PassWord15', current_timestamp, null),
    ('user16', 'user16@example.com', 'PassWord16', current_timestamp, null),
    ('user17', 'user17@example.com', 'PassWord17', current_timestamp, null),
    ('user18', 'user18@example.com', 'PassWord18', current_timestamp, null),
    ('user19', 'user19@example.com', 'PassWord19', current_timestamp, null),
    ('user20', 'user20@example.com', 'PassWord20', current_timestamp, null);

insert into todos (title, comment, dead_line, done, created_at)
values
    ('Buy groceries', 'Don''t forget the milk!', '2024-03-10 10:00:00',0, current_timestamp),
    ('Finish work project', 'Deadline is approaching.', '2024-06-20 17:00:00',0, current_timestamp),
    ('Go for a run', '5 kilometers today.', '2024-01-15 08:00:00',0, current_timestamp),
    ('Read a book', 'Science fiction novel.', '2024-07-05 20:00:00',0, current_timestamp),
    ('Call mom', 'Check how she''s doing.', '2024-02-12 18:00:00',0, current_timestamp),
    ('Plan weekend trip', 'Explore new hiking trails.', '2024-04-08 09:00:00',0, current_timestamp),
    ('Learn a new recipe', 'Try cooking something exotic.', '2024-09-14 12:00:00',0, current_timestamp),
    ('Practice guitar', 'Master that solo.', '2024-05-21 16:00:00',0, current_timestamp),
    ('Watch a documentary', 'History or science theme.', '2024-11-30 19:00:00',0, current_timestamp),
    ('Organize closet', 'Donate unused clothes.', '2024-08-10 14:00:00',0, current_timestamp),
    ('Write in journal', 'Reflect on the day.', '2024-12-15 21:00:00',0, current_timestamp),
    ('Fix leaky faucet', 'Call plumber if needed.', '2024-03-22 13:00:00',0, current_timestamp),
    ('Volunteer at local shelter', 'Help those in need.', '2024-04-17 15:00:00',0, current_timestamp),
    ('Create a budget', 'Plan expenses for the month.', '2024-01-25 11:00:00',0, current_timestamp),
    ('Practice mindfulness', 'Meditate for 15 minutes.', '2024-05-03 06:00:00',0, current_timestamp),
    ('Visit art gallery', 'Appreciate local artists.', '2024-09-07 17:00:00',0, current_timestamp),
    ('Learn a new language', 'Start with basic phrases.', '2024-06-14 10:00:00',0, current_timestamp),
    ('Plant flowers in the garden', 'Brighten up the backyard.', '2024-07-19 08:00:00',0, current_timestamp),
    ('Take a photography walk', 'Capture interesting scenes.', '2024-10-02 16:00:00',0, current_timestamp),
    ('Go to the dentist', 'Annual check-up.', '2024-03-05 09:00:00',0, current_timestamp),
    ('Clean the garage', 'Organize tools and boxes.', '2024-08-23 13:00:00',0, current_timestamp),
    ('Write a poem', 'Express creativity.', '2024-05-27 18:00:00',0, current_timestamp),
    ('Attend a concert', 'Enjoy live music.', '2024-11-12 20:00:00',0, current_timestamp),
    ('Join a book club', 'Discuss literature.', '2024-02-20 19:00:00',0, current_timestamp),
    ('Bake cookies', 'Try a new recipe.', '2024-04-30 14:00:00',0, current_timestamp),
    ('Update resume', 'Add recent experience.', '2024-06-18 11:00:00',0, current_timestamp),
    ('Go hiking', 'Explore a new trail.', '2024-07-29 07:00:00',0, current_timestamp),
    ('Host a dinner party', 'Invite friends over.', '2024-12-08 18:00:00',0, current_timestamp),
    ('Visit a museum', 'Learn something new.', '2024-10-15 10:00:00',0, current_timestamp),
    ('Paint a picture', 'Get creative with colors.', '2024-09-28 15:00:00',0, current_timestamp),
    ('Attend a workshop', 'Learn a new skill.', '2024-03-12 13:00:00',0, current_timestamp),
    ('Go on a road trip', 'Explore new places.', '2024-06-25 09:00:00',0, current_timestamp),
    ('Write a letter', 'Reconnect with an old friend.', '2024-01-20 18:00:00',0, current_timestamp),
    ('Cook a fancy dinner', 'Experiment with new cuisine.', '2024-07-11 19:00:00',0, current_timestamp),
    ('Visit a farmer''s market', 'Buy fresh produce.', '2024-04-05 09:00:00',0, current_timestamp),
    ('Have a picnic', 'Enjoy the outdoors.', '2024-05-30 12:00:00',0, current_timestamp),
    ('Attend a seminar', 'Gain professional knowledge.', '2024-09-22 15:00:00',0, current_timestamp),
    ('Do a puzzle', 'Challenge your mind.', '2024-10-28 14:00:00',0, current_timestamp),
    ('Try a new sport', 'Stay active and have fun.', '2024-02-15 08:00:00',0, current_timestamp),
    ('Declutter your workspace', 'Improve productivity.', '2024-08-04 11:00:00',0, current_timestamp),
    ('Visit a new restaurant', 'Try different cuisine.', '2024-11-07 19:00:00',0, current_timestamp),
    ('Go to a play', 'Enjoy some live theater.', '2024-12-03 20:00:00',0, current_timestamp),
    ('Have a movie marathon', 'Watch favorite films.', '2024-03-19 18:00:00',0, current_timestamp),
    ('Take a dance class', 'Learn some new moves.', '2024-06-10 17:00:00',0, current_timestamp),
    ('Write a short story', 'Get creative with words.', '2024-01-30 16:00:00',0, current_timestamp),
    ('Go bird watching', 'Enjoy nature.', '2024-07-23 07:00:00',0, current_timestamp),
    ('Organize a game night', 'Have fun with friends.', '2024-05-15 18:00:00',0, current_timestamp),
    ('Visit a botanical garden', 'Appreciate plant life.', '2024-09-18 10:00:00',0, current_timestamp),
    ('Take a bubble bath', 'Relax and unwind.', '2024-04-12 20:00:00',0, current_timestamp),
    ('Join a gym', 'Stay fit and healthy.', '2024-10-20 06:00:00',0, current_timestamp),
    ('Start a blog', 'Share your thoughts.', '2024-08-29 14:00:00',0, current_timestamp),
    ('Go stargazing', 'Look at the night sky.', '2024-12-20 22:00:00',0, current_timestamp),
    ('Take a cooking class', 'Learn from a professional chef.', '2024-11-25 17:00:00',0, current_timestamp),
    ('Try a new coffee shop', 'Enjoy a fresh brew.', '2024-02-25 09:00:00',0, current_timestamp),
    ('Go to a fair', 'Enjoy the attractions.', '2024-06-28 15:00:00',0, current_timestamp),
    ('Build a model kit', 'Assemble and paint.', '2024-03-28 14:00:00',0, current_timestamp),
    ('Attend a networking event', 'Meet new people.', '2024-06-07 18:00:00',0, current_timestamp),
    ('Make a scrapbook', 'Collect memories.', '2024-01-17 10:00:00',0, current_timestamp),
    ('Visit a national park', 'Enjoy natural beauty.', '2024-07-21 09:00:00',0, current_timestamp),
    ('Take a pottery class', 'Create something unique.', '2024-05-09 16:00:00',0, current_timestamp);


---Assign 3 random todos to each user
create TEMPORARY TABLE temp_user_todo (
    user_id INT,
    todo_id INT
);

-- Loop to assign 3 random todos to each user
SET @num_users = (select count(*) from user_details);
SET @num_todos = (select count(*) from todos);

-- Ensure there are enough todos to assign 3 to each user
IF @num_todos < @num_users * 3 THEN
    SIGNAL SQLSTATE '45000'
    SET MESSAGE_TEXT = 'Not enough todos to assign 3 to each user';
END IF;

-- Assign todos to each user
insert into temp_user_todo (user_id, todo_id)
select users.id, todos.id
from user_details as users
join todos as todos
order by users.id, rand()
limit @num_users * 3;

-- Ensure unique todo assignment per user
delete tu1 from temp_user_todo tu1
JOIN temp_user_todo tu2
  ON tu1.user_id = tu2.user_id AND tu1.todo_id = tu2.todo_id
  AND tu1.id > tu2.id;

-- Assign todos to users in the todos table
update todos as t
JOIN (
    select user_id, todo_id,
           ROW_NUMBER() OVER (PARTITION BY user_id ORDER BY user_id) as row_num
    FROM temp_user_todo
) AS tut ON t.id = tut.todo_id AND tut.row_num <= 3
SET t.user_id = tut.user_id;

-- Drop the temporary table as it's no longer needed
DROP TEMPORARY TABLE temp_user_todo;