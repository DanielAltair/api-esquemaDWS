# API Esquema DWS — Documentación para continuar el proyecto

## 1. Información general del proyecto

Estoy desarrollando una API REST como proyecto de clase de Desarrollo Web en Entorno Servidor (DWS), en DAW, en el centro Altair de Sevilla.

El objetivo es desarrollar una API siguiendo los contenidos y ejemplos del profesor.

**Tecnologías utilizadas:**
- Java 25.
- Spring Boot 4.1.1.
- Maven.
- Spring Data JPA.
- Hibernate.
- PostgreSQL.
- Visual Studio Code.
- Postman para probar los endpoints.
- Git y GitHub para el control de versiones.

**Package principal:**
`com.ApiEsquemaNuevo.api_esquema`

## 2. Instrucciones MUY IMPORTANTES para ayudarme

He compartido los apuntes UT2, UT3, UT4 y UT5 de la asignatura.

Quiero que todas las explicaciones y soluciones sigan esos apuntes y el estilo del profesor.

Hay que respetar estas normas:

1. Explicarme las cosas paso a paso.
2. Darme una sola tarea pequeña cada vez.
3. Esperar a que confirme que la he terminado antes de avanzar.
4. Explicarme qué hace cada anotación, método, clase o línea cuando sea necesario.
5. No darme bloques enormes de código para copiar sin explicaciones.
6. No introducir técnicas avanzadas que no hayamos visto en clase.
7. Utilizar una programación sencilla, propia de un alumno de DAW.
8. Si algo no aparece en los apuntes, indicármelo antes de introducirlo.
9. No dar por terminado algo sin revisar que funciona.

**IMPORTANTE:** No quiero simplemente copiar y pegar código. Quiero entender lo que estoy haciendo para poder explicárselo al profesor.

## 3. Arquitectura de la API

Estamos utilizando una estructura por capas:

- `entities`: clases que representan las entidades y tablas de la base de datos.
- `repositories`: interfaces que permiten consultar, guardar, modificar y eliminar datos de la base de datos.
- `dtos`: objetos que representan los datos que entran y salen de la API.
- `services`: interfaces que definen las operaciones de la API.
- `services.impl`: implementaciones de la lógica de negocio.
- `controllers`: controladores que reciben las peticiones HTTP.
- `exceptions`: excepciones personalizadas y gestión global de errores.

### Funcionamiento general

**Controller → Service → Repository → Base de datos**

El Controller recibe la petición HTTP y llama al Service.

El Service contiene la lógica y utiliza el Repository para acceder a la base de datos.

El Repository se encarga de las operaciones con la base de datos.

El Controller devuelve la respuesta HTTP correspondiente.

### Conceptos que ya hemos trabajado

- `@Entity`: indica que una clase representa una entidad de base de datos.
- `@Table`: permite indicar el nombre de la tabla.
- `@Id`: identifica la clave primaria.
- `@GeneratedValue`: configura la generación del identificador.
- `@Column`: configura las columnas.
- `JpaRepository`: proporciona operaciones CRUD.
- `@Service`: identifica una clase como servicio.
- `@Transactional`: controla las transacciones.
- `@Transactional(readOnly = true)`: indica que una operación es de solo lectura.
- `@Override`: indica que estamos sobrescribiendo un método.
- `@PathVariable`: recoge un valor de la URL.
- `@RequestBody`: recoge los datos del cuerpo de la petición.
- `ResponseEntity`: permite controlar la respuesta HTTP.

## 4. Entidades del proyecto

Tenemos las siguientes entidades:

- Departamento.
- Profesor.
- Modulo.
- RelacionProfesorModulo.

La tabla intermedia `RelacionProfesorModulo` relaciona profesores con módulos mediante claves foráneas.

**Importante:** Según las indicaciones del profesor, las tablas intermedias no necesitan tener un CRUD propio.

Las entidades principales sí deben disponer de operaciones CRUD.

## 5. Estado de Departamento

El CRUD de Departamento está terminado.

También se creó su excepción personalizada:

`DepartamentoNotFoundException`

El `GlobalExceptionHandler` ya tenía implementada la gestión de errores de Departamento.

## 6. Estado de Modulo

El CRUD de Modulo está implementado.

La entidad se llama `Modulo` y su tabla es `modulos`.

### Entidad Modulo

Tiene estos atributos:

| Atributo | Tipo |
|---|---|
| idModulo | Long |
| codigo | String |
| diminutivo | String |
| nombre | String |
| descripcion | String |
| horasSemanales | Integer |
| creditos | Integer |

Configuración importante:

- Clave primaria: `id_modulo`.
- `codigo`: obligatorio, único y longitud máxima de 5.
- `diminutivo`: obligatorio, único y longitud máxima de 5.
- `nombre`: obligatorio y longitud máxima de 50.
- `descripcion`: longitud máxima de 250.

### ModuloRepository

Se ha creado una interfaz que extiende de:

`JpaRepository<Modulo, Long>`

Además de los métodos CRUD que proporciona JpaRepository, tenemos:

```java
Optional<Modulo> findByCodigo(String codigo);

Optional<Modulo> findByDiminutivo(String diminutivo);

boolean existsByCodigo(String codigo);

boolean existsByDiminutivo(String diminutivo);

void deleteByCodigo(String codigo);

void deleteByDiminutivo(String diminutivo);
```

Estos métodos permiten trabajar con las claves únicas alternativas de Modulo.

### ModuloRequestDto

Es el DTO que recoge los datos que entran desde el cliente.

Tiene los siguientes campos:

```java
String codigo,
String diminutivo,
String nombre,
String descripcion,
Integer horasSemanales,
Integer creditos
```

### ModuloResponseDto

Es el DTO que representa los datos que devuelve la API.

Tiene los siguientes campos:

```java
Long idModulo,
String codigo,
String diminutivo,
String nombre,
String descripcion,
Integer horasSemanales,
Integer creditos
```

### ModuloService

Se ha creado la interfaz `ModuloService` con las siguientes operaciones:

```java
ModuloResponseDto crear(ModuloRequestDto datos);

List<ModuloResponseDto> listar();

ModuloResponseDto buscarPorId(Long id);

ModuloResponseDto buscarPorCodigo(String codigo);

ModuloResponseDto buscarPorDiminutivo(String diminutivo);

ModuloResponseDto actualizarPorId(Long id, ModuloRequestDto datos);

ModuloResponseDto actualizarPorCodigo(String codigo, ModuloRequestDto datos);

ModuloResponseDto actualizarPorDiminutivo(String diminutivo, ModuloRequestDto datos);

void eliminarPorId(Long id);

void eliminarPorCodigo(String codigo);

void eliminarPorDiminutivo(String diminutivo);
```

### ModuloServiceImpl

La implementación está terminada.

Incluye:
- Crear módulos.
- Listar módulos.
- Buscar por ID.
- Buscar por código.
- Buscar por diminutivo.
- Actualizar por ID.
- Actualizar por código.
- Actualizar por diminutivo.
- Eliminar por ID.
- Eliminar por código.
- Eliminar por diminutivo.

También tiene el método privado:

`mapToResponseDto(Modulo modulo)`

Este método convierte una entidad Modulo en un ModuloResponseDto.

Se utiliza `@Transactional` en las operaciones de modificación y `@Transactional(readOnly = true)` en las consultas.

La importación correcta es:

```java
import org.springframework.transaction.annotation.Transactional;
```

## 7. Controlador de Modulo

La clase `ModuloController` está implementada.

Contiene los endpoints para realizar las operaciones CRUD:

- GET para listar y buscar.
- POST para crear.
- PUT para actualizar.
- DELETE para eliminar.

Se trabaja con las búsquedas por ID, código y diminutivo.

El Controller recibe las peticiones HTTP y utiliza la inyección por constructor para recibir `ModuloService`.

## 8. Gestión de excepciones

Hemos trabajado las excepciones siguiendo el apartado 4.8 de los apuntes UT4.

Se utiliza:
- Excepciones personalizadas que extienden `RuntimeException`.
- `@RestControllerAdvice`.
- `@ExceptionHandler`.
- `ProblemDetail`.

### ModuloNotFoundException

Archivo: `ModuloNotFoundException.java`

```java
public class ModuloNotFoundException extends RuntimeException {

    public ModuloNotFoundException(String mensaje) {
        super(mensaje);
    }
}
```

Se utiliza cuando se intenta buscar, actualizar o eliminar un módulo que no existe.

Devuelve HTTP 404.

### ModuloAlreadyExistsException

Archivo: `ModuloAlreadyExistsException.java`

```java
public class ModuloAlreadyExistsException extends RuntimeException {

    public ModuloAlreadyExistsException(String mensaje) {
        super(mensaje);
    }
}
```

Se utiliza cuando se intenta crear o actualizar un módulo utilizando un código o diminutivo que ya existe.

Devuelve HTTP 409.

### GlobalExceptionHandler

Ya existía un `GlobalExceptionHandler` para Departamento.

Hemos reutilizado esa misma clase para añadir las excepciones de Modulo. No hay que crear otro handler global.

Para Modulo tenemos:

- `@ExceptionHandler(ModuloNotFoundException.class)` → HTTP 404.
- `@ExceptionHandler(ModuloAlreadyExistsException.class)` → HTTP 409.

Las respuestas se construyen con `ProblemDetail.forStatusAndDetail(...)`.

También se añade:
- `title`: título del error.
- `timestamp`: fecha y hora del error.

## 9. Pruebas realizadas en Postman

Hemos instalado Postman y configurado el Desktop Agent para poder realizar peticiones a `localhost`.

La API se ejecuta en el puerto 8080.

### Prueba de creación

Se creó correctamente un módulo con estos datos:

```json
{
    "codigo": "0485",
    "diminutivo": "DWS",
    "nombre": "Desarrollo Web en Entorno Servidor",
    "descripcion": "Desarrollo de aplicaciones web en el servidor",
    "horasSemanales": 6,
    "creditos": 10
}
```

La petición POST funcionó correctamente.

### Prueba de código duplicado

Se volvió a enviar el mismo JSON.

Inicialmente apareció un error 500 porque se estaba ejecutando una versión anterior del código que todavía lanzaba `RuntimeException`.

Se reinició la aplicación y se comprobó que el problema estaba solucionado.

Respuesta obtenida:

```json
{
    "detail": "Ya existe un módulo con el código: 0485",
    "instance": "/api/modulos",
    "status": 409,
    "title": "Conflicto de datos",
    "timestamp": "2026-11-05T19:13:12.121888700Z"
}
```

**Resultado: correcto.**

### Prueba de módulo inexistente

Se realizó una petición GET a:

```text
http://localhost:8080/api/modulos/999
```

La respuesta fue HTTP 404.

**Resultado: correcto.**

Por tanto, las dos excepciones personalizadas de Modulo están funcionando.

## 10. Estado actual del proyecto

| Parte | Estado |
|---|---|
| Configuración de Spring Boot | Completada |
| Conexión con PostgreSQL | Configurada |
| Departamento | CRUD completado |
| Modulo Entity | Completado |
| ModuloRepository | Completado |
| ModuloRequestDto | Completado |
| ModuloResponseDto | Completado |
| ModuloService | Completado |
| ModuloServiceImpl | Completado |
| ModuloController | Completado |
| ModuloNotFoundException | Completada |
| ModuloAlreadyExistsException | Completada |
| GlobalExceptionHandler | Actualizado |
| Prueba POST de creación | Correcta |
| Prueba de duplicados 409 | Correcta |
| Prueba de inexistente 404 | Correcta |

## 11. ¿Dónde debemos continuar?

La parte de Modulo está implementada y las pruebas básicas de excepciones han funcionado.

El siguiente paso debe ser continuar con el proyecto general, revisar lo que queda de Profesor y RelacionProfesorModulo y comprobar que todo sigue las indicaciones del profesor.

Antes de añadir nuevas funcionalidades, hay que revisar los archivos y el estado real del proyecto.

No hay que rehacer lo que ya está terminado.

## 12. Instrucción final para el siguiente chat

Quiero que continúes este proyecto como si fueras el mismo asistente que me ha estado ayudando.

Ten en cuenta los apuntes UT2, UT3, UT4 y UT5 que ya compartí. Si no están disponibles en el nuevo chat, pídeme que los vuelva a adjuntar antes de introducir contenido que dependa de ellos.

No avances varios pasos de golpe. Dame una única instrucción, espera a que la complete y después seguimos.

Quiero aprender y entender el proyecto, no limitarme a copiar código.

**El estado de partida es el descrito en este README, con Departamento terminado y Modulo implementado y probado.**