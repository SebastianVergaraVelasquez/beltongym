# Sistema de Gestión Belton Gym 🏋️‍♂️  (Versión 0.1)
 
Este proyecto es una aplicación desarrollada con **Spring Boot**, diseñada para gestionar las operaciones de un gimnasio local, **Belton Gym**, ubicado en Floridablanca, Santander.

## 🧰 Tecnologías utilizadas

- Java 17
- Spring Boot 3.3.3
  - Spring Web
  - Spring Data JPA
  - Spring Web Services
  - Spring Boot Actuator
- MySQL
- Maven como gestor de dependencias

## 🗂️ Estructura del Proyecto

### Paquetes principales

- `com.sebastianvv.beltongym.domain.services`: Lógica de negocio para cada módulo (usuario, proveedor, compras, ventas, etc.).
- `com.sebastianvv.beltongym.persistence.entities`: Entidades JPA que representan las tablas de la base de datos.
- `com.sebastianvv.beltongym.web.controllers`: Controladores para manejar peticiones HTTP (API REST).

### Entidades traducidas

| Entity               | Entidad                    |
|----------------------|-------------------------------|
| `Attendance`         | Asistencia                    |
| `Membership`         | Membresía                     |
| `MembershipType`     | Tipo de membresía             |
| `Product`            | Producto                      |
| `PurchaseDetail`     | Detalle de compra             |
| `SaleDetail`         | Detalle de venta              |
| `Sales`              | Venta                         |
| `Supplier`           | Proveedor                     |
| `SupplierPurchase`   | Compra al proveedor           |
| `User`               | Usuario                       |
| `UserType`           | Tipo de usuario               |

## ⚙️ CRUD

Cada entidad cuenta con su propio servicio y controlador para manejar operaciones básicas:

### 1. Crear o actualizar
- El controlador recibe una petición POST o PUT con los datos.
- El servicio llama al repositorio (`JpaRepository.save()`).
- Si el ID ya existe, actualiza el registro; si no, lo crea.

### 2. Listar
- Se usa un método `GET` en el controlador.
- El servicio consulta con `findAll()` o filtros personalizados.

### 3. Eliminar
- El controlador recibe una petición `DELETE`.
- El servicio invoca `deleteById(id)` del repositorio correspondiente.


## Cómo ejecutar el proyecto

1. Clona este repositorio. git clone https://github.com/SebastianVergaraVelasquez/beltongym

2. Asegúrate de tener instalado Java 17 y MySQL.

3. Crea en MySQL una base de datos llamada belton_gym

4. Configura application.properties con tus credenciales de base de datos.
    
    spring.datasource.url=jdbc:mysql://localhost:3306/belton_gym
    spring.datasource.username=******
    spring.datasource.password=******

5. Antes de ejecutar el proyecto, dentro del archivo scriptdb.md se encuentra un script con los comandos de la creación de la base de datos,
usar la base de datos e inserciones a la base de datos. Agrega estos INSERT para obtener respuesta de la aplicación cuando se le hagan peticiones, por ejemplo desde postman. De lo contrario esta no devolvera ningún dato.

6. Ejecuta el proyecto con el siguiente comando 

    ./mvnw spring-boot:run  
    Si estás en Windows, usa mvnw.cmd spring-boot:run.