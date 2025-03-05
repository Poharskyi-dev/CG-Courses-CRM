--liquibase formatted sql
--changeset andrii.poharskyi:2
--default data
INSERT INTO users (user_id, role, first_name, second_name, email, password) VALUES
    (gen_random_uuid(), 'admin', 'Иван', 'Пантєлеев', 'ivan@example.com', 'hashed_password_1'),
    (gen_random_uuid(), 'kurator', 'Анна', '', 'anna@example.com', 'hashed_password_2'),
    (gen_random_uuid(), 'owner', 'Павел', 'Калініченко', 'pavel@example.com', 'hashed_password_3');