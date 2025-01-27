--liquibase formatted sql
--changeset andrii.poharskyi:1
-- Таблиця робітників курсів
CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       role VARCHAR(50),
                       first_name VARCHAR(50) NOT NULL,
                       second_name VARCHAR(50),
                       email VARCHAR(50) UNIQUE NOT NULL,
                       password VARCHAR(50) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблиця студентів
CREATE TABLE students (
                          student_id SERIAL PRIMARY KEY,
                          first_name VARCHAR(50) NOT NULL,
                          second_name VARCHAR(50) NOT NULL,
                          lead_status VARCHAR(50) DEFAULT 'INTEREST' CHECK (lead_status IN ('WEBSITE_REGISTERED', 'INTEREST', 'INTENT', 'STUDENT', 'FINISHED', 'LEFT_DISSATISFIED', 'BLACKLIST')),
                          phone_number VARCHAR(20),
                          email VARCHAR(50) UNIQUE,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          description VARCHAR(255),
                          added_by INT REFERENCES users(user_id) ON DELETE SET NULL,
                          already_studied BOOLEAN DEFAULT FALSE,
                          city VARCHAR(50),
                          street VARCHAR(50),
                          house_number INT,
                          add_address VARCHAR(50),
                          zip_code INT,
                          messenger VARCHAR(50) DEFAULT 'TELEGRAM' CHECK (messenger IN ('TELEGRAM', 'FACEBOOK', 'WHATSAPP', 'INSTAGRAM')),
                          messenger_nickname VARCHAR(50)
);

-- Таблиця курсів
CREATE TABLE courses (
                         course_id SERIAL PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         description VARCHAR(255),
                         start_date DATE,
                         end_date DATE CHECK (start_date < end_date),
                         price INT NOT NULL,
                         price_discount INT CHECK (price_discount IS NULL OR price_discount <= price),
                         hours INT
);

-- Таблиця оплат
CREATE TABLE payments (
                          payment_id SERIAL PRIMARY KEY,
                          student_id INT REFERENCES students(student_id) ON DELETE CASCADE,
                          status VARCHAR(50) DEFAULT 'WAITING' CHECK (status IN ('WAITING', 'PARTIALPAYMENT', 'COMPLETED', 'FAILED')),
                          value NUMERIC(10, 2) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Таблиця складених угод
CREATE TABLE enrollments (
                             enrollment_id SERIAL PRIMARY KEY,
                             student_id INT REFERENCES students(student_id) ON DELETE CASCADE,
                             course_id INT REFERENCES courses(course_id) ON DELETE CASCADE,
                             enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                             payment_id INT REFERENCES payments(payment_id) ON DELETE CASCADE,
                             is_discount BOOLEAN
);

-- Таблиця встигаємості студентів
CREATE TABLE results (
                         result_id SERIAL PRIMARY KEY,
                         student_id INT REFERENCES students(student_id) ON DELETE CASCADE,
                         average_grade INT CHECK (average_grade BETWEEN 0 AND 100),
                         portfolio_link VARCHAR(255),
                         description VARCHAR(255),
                         is_outstanding BOOLEAN DEFAULT FALSE
);

-- Таблиця івентів
CREATE TABLE events (
                        event_id SERIAL PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        description VARCHAR(255),
                        start_date DATE,
                        end_date DATE,
                        price INT,
                        price_discount INT CHECK (price_discount IS NULL OR price_discount <= price),
                        hours INT,
                        student_id INT,
                        FOREIGN KEY (student_id) REFERENCES students(student_id) ON DELETE CASCADE
);