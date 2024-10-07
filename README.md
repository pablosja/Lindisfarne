# UltimaSalida-Back

Este repositorio contiene el back-end de Lindisfarne, una aplicación web interactiva de misterio y aventura. Utiliza **Spring Boot** para la gestión del servidor y la lógica de negocio, junto con **JPA** para la interacción con la base de datos.

## Características del Back-end

- **Gestión de Usuarios**: Implementa el registro y autenticación de usuarios con encriptación de contraseñas.
- **Seguridad**: Utiliza **Spring Security** para asegurar las rutas de la API y manejar la autenticación básica.
- **API RESTful**: Exposición de endpoints para el manejo de usuarios y la autenticación.
- **Interacción con Base de Datos**: Conexión a **H2** para desarrollo y pruebas, y soporte para **MySQL** en producción.

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para el desarrollo del back-end.
- **Spring Security**: Gestión de autenticación y autorización de usuarios.
- **JPA (Java Persistence API)**: Mapeo objeto-relacional para acceder a la base de datos.
- **H2 Database**: Base de datos en memoria para desarrollo y pruebas.
- **JUnit y Mockito**: Herramientas para pruebas unitarias y de integración.

## Estructura del Proyecto

- `src/main/java/pablosja/lindisfarne`
  - **config**: 
    - Configuraciones de seguridad y CORS
  - **controllers**: 
    - Controladores para manejar las solicitudes HTTP
  - **dtos**: 
    - Objetos de transferencia de datos (DTOs)
  - **models**: 
    - Modelos de datos
  - **repositories**: 
    - Interfaces de repositorio para acceso a datos
  - **services**: 
    - Lógica de negocio y servicios

## Instalación

### Requisitos Previos

- Java 11 o superior
- Maven

### Pasos de Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/tu_usuario/lindisfarne.git
   cd lindisfarne
