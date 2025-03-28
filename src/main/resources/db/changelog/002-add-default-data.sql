--liquibase formatted sql
--changeset andrii.poharskyi:2
--default data
INSERT INTO users (user_id, role, first_name, second_name, email, password) VALUES
    ('77663953-df75-4e22-be44-50599698e1d7', 'admin', 'Иван', 'Пантєлеев', 'ivan@example.com', 'hashed_password_1'),
    ('bf37950a-4457-4610-9b87-4261de1fcc8d', 'kurator', 'Анна', '', 'anna@example.com', 'hashed_password_2'),
    ('26247567-b564-44b1-a580-b016408afbd7', 'owner', 'Павел', 'Калініченко', 'pavel@example.com', 'hashed_password_3');