INSERT INTO users (user_id, complete_name, password, username, rol) VALUES (1, 'Gerson Luque', '$2a$12$/P7G1iW1sTCGwu09.u9v3uGBZOFvJ/OUaMkk2MYnkW6vGwCWGMvLS', 'gerson', 'STUDENT');
INSERT INTO users (user_id, complete_name, password, username, rol) VALUES (2, 'Lino Espinosa', '$2a$12$/P7G1iW1sTCGwu09.u9v3uGBZOFvJ/OUaMkk2MYnkW6vGwCWGMvLS', 'lino', 'STUDENT');
INSERT INTO users (user_id, complete_name, password, username, rol) VALUES (3, 'Salvador Sanchez', '$2a$12$Ul/NS43XbR62JkNyCKPSSe7vhTSympX6AO8V03j0LCbhY.bQ20R5q', 'salva', 'TEACHER');
INSERT INTO users (user_id, complete_name, password, username, rol) VALUES (4, 'Jose Sala', '$2a$12$Ul/NS43XbR62JkNyCKPSSe7vhTSympX6AO8V03j0LCbhY.bQ20R5q', 'jose', 'TEACHER');
INSERT INTO users (user_id, complete_name, password, username, rol) VALUES (5, 'Daniel Franco', '$2a$12$/P7G1iW1sTCGwu09.u9v3uGBZOFvJ/OUaMkk2MYnkW6vGwCWGMvLS', 'daniel', 'STUDENT');
INSERT INTO users (user_id, complete_name, password, username, rol) VALUES (6, 'Javier del Cerro', '$2a$12$/P7G1iW1sTCGwu09.u9v3uGBZOFvJ/OUaMkk2MYnkW6vGwCWGMvLS', 'javi', 'STUDENT');
INSERT INTO users (user_id, complete_name, password, username, rol) VALUES (7, 'Sofía García', 'password123', 'sofiagarcia', 'STUDENT');
INSERT INTO users (user_id, complete_name, password, username, rol) VALUES (8, 'Juanita Pérez', 'password123', 'juanitaperez', 'TEACHER');

INSERT INTO courses (course_id, course_name) VALUES (1, 'Mathematics');
INSERT INTO courses (course_id, course_name) VALUES (2, 'History');
INSERT INTO courses (course_id, course_name) VALUES (3, 'Physics');
INSERT INTO courses (course_id, course_name) VALUES (4, 'Chemistry');
INSERT INTO courses (course_id, course_name) VALUES (5, 'Biology');

INSERT INTO users_courses (course_id, user_id) VALUES (1, 1);
INSERT INTO users_courses (course_id, user_id) VALUES (3, 1);
INSERT INTO users_courses (course_id, user_id) VALUES (2, 2);
INSERT INTO users_courses (course_id, user_id) VALUES (1, 3);
INSERT INTO users_courses (course_id, user_id) VALUES (3, 3);
INSERT INTO users_courses (course_id, user_id) VALUES (2, 4);
INSERT INTO users_courses (course_id, user_id) VALUES (4, 5);
INSERT INTO users_courses (course_id, user_id) VALUES (5, 5);
INSERT INTO users_courses (course_id, user_id) VALUES (1, 6);
INSERT INTO users_courses (course_id, user_id) VALUES (2, 6);
INSERT INTO users_courses (course_id, user_id) VALUES (3, 7);
INSERT INTO users_courses (course_id, user_id) VALUES (4, 7);
INSERT INTO users_courses (course_id, user_id) VALUES (5, 8);
INSERT INTO users_courses (course_id, user_id) VALUES (1, 8);

INSERT INTO tasks (task_id, title, start_date, end_date, visible, course_id, teacher_id, description) VALUES (1, 'Math Assignment', '2024-12-01', '2024-12-15', b'1', 1, 3, 'Mathematics Assignment 1');
INSERT INTO tasks (task_id, title, start_date, end_date, visible, course_id, teacher_id, description) VALUES (2, 'History Project', '2024-12-05', '2024-12-20', b'1', 2, 4, 'History Project 1');
INSERT INTO tasks (task_id, title, start_date, end_date, visible, course_id, teacher_id, description) VALUES (3, 'Physics Lab', '2024-12-10', '2024-12-25', b'1', 3, 3, 'Physics Lab 1');
INSERT INTO tasks (task_id, title, start_date, end_date, visible, course_id, teacher_id, description) VALUES (4, 'Chemistry Lab', '2024-12-12', '2024-12-19', b'1', 4, 6, 'Chemistry Lab 1');
INSERT INTO tasks (task_id, title, start_date, end_date, visible, course_id, teacher_id, description) VALUES (5, 'Biology Assignment', '2024-12-15', '2024-12-30', b'1', 5, 6, 'Biology Assignment 1');

INSERT INTO solutions (solution_id, anonymous, star, student_id, task_id) VALUES (1, b'0', b'1', 1, 1);
INSERT INTO solutions (solution_id, anonymous, star, student_id, task_id) VALUES (2, b'1', b'0', 2, 2);
INSERT INTO solutions (solution_id, anonymous, star, student_id, task_id) VALUES (3, b'0', b'1', 1, 3);
INSERT INTO solutions (solution_id, anonymous, star, student_id, task_id) VALUES (4, b'0', b'1', 2, 1);
INSERT INTO solutions (solution_id, anonymous, star, student_id, task_id) VALUES (5, b'0', b'0', 5, 4);
INSERT INTO solutions (solution_id, anonymous, star, student_id, task_id) VALUES (6, b'1', b'0', 7, 5);
