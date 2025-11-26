# 📌 Gestión de Tareas Académicas - Backend

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

### 🔹 Infraestructura y Desarrollo
- **Docker + Docker Compose**: Facilita la configuración y despliegue del entorno de desarrollo mediante contenedores.

## 🎯 Características Destacadas
- **Manejo de roles**: Diferenciación clara entre profesores y alumnos con permisos específicos para cada uno.
- **Autenticación segura**: Implementación de JWT para garantizar sesiones seguras.
- **Gestión de tareas**: Creación, modificación y administración de asignaciones por parte de los profesores.
- **Entrega de soluciones**: Subida de archivos y código fuente en formatos admitidos por la plataforma.
- **Revisión y evaluación**: Herramientas para que los profesores puedan visualizar, calificar y resaltar soluciones destacadas.
- **Infraestructura escalable**: Uso de contenedores para simplificar el despliegue y mejorar la colaboración en el desarrollo.
