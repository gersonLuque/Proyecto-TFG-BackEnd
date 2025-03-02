# 📌 Gestión de Tareas Académicas - Backend(En desarrollo)

## 📖 Descripción
Este proyecto es el backend de una plataforma diseñada para gestionar tareas de programación entre profesores y alumnos. Los profesores pueden crear tareas, mientras que los alumnos pueden enviar sus soluciones y, tras la fecha límite, explorar las respuestas de sus compañeros. 

## 🚀 Tecnologías Utilizadas
### 🔹 Backend
- **Spring Boot**: Framework para la creación de la API REST.
- **Spring Data JPA**: Para la gestión de la persistencia con MySQL.
- **Spring Security + JWT**: Autenticación y autorización seguras mediante tokens JWT.
- **AWS S3**: Almacenamiento de archivos.
- **Swagger**: Documentación de la API para facilitar su uso y pruebas.

### 🔹 Base de Datos
- **MySQL**: Base de datos relacional utilizada para almacenar usuarios, tareas y entregas.

## 🎯 Funcionalidades Clave
- **Gestión de usuarios**: Creación y administración de cuentas de profesores y alumnos.
- **Autenticación segura**: Uso de JWT para control de acceso.
- **Gestión de tareas**: Creación, edición y asignación de tareas a alumnos.
- **Subida de soluciones**: Los alumnos pueden enviar sus respuestas en distintos formatos.
- **Evaluación y feedback**: Revisión de soluciones por parte de los profesores, con opción de destacar las mejores respuestas.
