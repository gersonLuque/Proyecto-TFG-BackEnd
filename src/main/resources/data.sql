-- Insertar datos en la tabla "courses"
INSERT INTO courses (course_name) VALUES ('Mathematics');
INSERT INTO courses (course_name) VALUES ('History');
INSERT INTO courses (course_name) VALUES ('Physics');

-- Insertar datos en la tabla "users"
INSERT INTO users (complete_name, password, username, rol) VALUES ('Juan Pérez', 'password123', 'juanperez', 'STUDENT');
INSERT INTO users (complete_name, password, username, rol) VALUES ('María Gómez', 'password123', 'mariagomez', 'STUDENT');
INSERT INTO users (complete_name, password, username, rol) VALUES ('Carlos López', 'password123', 'carloslopez', 'TEACHER');
INSERT INTO users (complete_name, password, username, rol) VALUES ('Ana Sánchez', 'password123', 'anasanchez', 'TEACHER');

-- Insertar datos en la tabla "users_courses" (relación de muchos a muchos)
-- Asociar alumnos con cursos
INSERT INTO users_courses (course_id, user_id) VALUES (1, 1); -- Juan Pérez con Mathematics
INSERT INTO users_courses (course_id, user_id) VALUES (2, 2); -- María Gómez con History
INSERT INTO users_courses (course_id, user_id) VALUES (3, 1); -- Juan Pérez con Physics

-- Asociar profesores con cursos
INSERT INTO users_courses (course_id, user_id) VALUES (1, 3); -- Carlos López con Mathematics
INSERT INTO users_courses (course_id, user_id) VALUES (2, 4); -- Ana Sánchez con History
INSERT INTO users_courses (course_id, user_id) VALUES (3, 3); -- Carlos López con Physics
