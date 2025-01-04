# Sistema de Gestión de Tareas

Este proyecto es un sistema de gestión de tareas que se ejecuta por consola. Permite realizar operaciones como agregar, editar, eliminar, listar y buscar tareas, aplicando principios de diseño orientado a objetos y la arquitectura SOLID.



## Requisitos Previos

- **Java Development Kit (JDK)**: Versión 21.
- **Apache Maven**: Para la gestión de dependencias y construcción del proyecto.
- **Git**: Para clonar el repositorio.
- **Eclipse**: Para importar proyecto Maven y correr proyecto.



## Instalación

1. **Clonar el repositorio:**
   
```bash
git clone https://github.com/CamiNefilim/java_modulo2_calvaradoa.git
cd java_modulo2_calvaradoa
```

2. **Compilar el proyecto con Maven:**

 ```bash
mvn clean compile
```

5. **Generar el archivo JAR ejecutable:**

```bash
mvn package
```




## Ejecución

Se puede ejecutar la aplicación desde el archivo JAR, ingresando por consola a la raiz del proyecto:

```bash
cd target/
java -jar calvaradoa-0.0.1-SNAPSHOT.jar
```

También se puede ejecutar la aplicación desde eclipse y correr el proyecto en IDE.

**Interacción con el menú:** Una vez iniciada la aplicación, aparecerá un menú en la consola con las siguientes opciones:

**Menú Principal**

```bash
=== Menú ===
1) Agregar tarea
2) Editar tarea
3) Eliminar tarea
4) Listar tareas
5) Buscar tarea
6) Salir
```

Ingresa el número correspondiente a la acción que deseas realizar y sigue las instrucciones en consola.

**Uso del Menú**

1) Agregar tarea: 

Se solicitarán los siguientes datos:

- **Título (obligatorio)**: El nombre de la tarea.
- **Descripción (obligatoria)**: Detalle de la tarea.
- **Prioridad (obligatoria)**: Selecciona entre ALTA, MEDIA o BAJA.
- **Estado (obligatorio)**: Selecciona entre PENDIENTE, EN_PROGRESO o COMPLETADA.

Ejemplo:

```bash
Ingresa un Título: Preparar presentación
Ingresa una Descripción: Crear diapositivas para la reunión
Ingresa una Prioridad (ALTA, MEDIA, BAJA): ALTA
Ingresa un Estado (PENDIENTE, EN_PROGRESO, COMPLETADA): PENDIENTE
```

2) Editar tarea: 

Se solicitará el ID de la tarea que deseas editar. Podrás modificar uno o más campos:
- **Título**: Opcional
- **Descripción**: Opcional.
- **Prioridad**: Opcional (ALTA, MEDIA, BAJA).
- **Estado**: Opcional (PENDIENTE, EN_PROGRESO, COMPLETADA).

Ejemplo:

```bash
Ingresa el ID de la tarea a editar: 1
Nuevo título (opcional): Preparar presentación final
Nueva descripción (opcional): Agregar resumen de resultados
Nueva prioridad (ALTA, MEDIA, BAJA) (opcional): MEDIA
Nuevo estado (PENDIENTE, EN_PROGRESO, COMPLETADA) (opcional): EN_PROGRESO
```

3) Eliminar tarea: 

Ingresa el ID de la tarea que deseas eliminar. La tarea será eliminada si existe en la lista.

Ejemplo:

```bash
Ingresa el ID de la tarea a eliminar: 1
```

4) Listar tareas: 

Muestra todas las tareas ordenadas por prioridad (ALTA > MEDIA > BAJA). Si no hay tareas, se mostrará un mensaje.

6) Buscar tarea: 

Ingresa un término de búsqueda que puede coincidir con el título o descripción de una tarea. Las coincidencias se mostrarán en la consola.

Ejemplo:

```bash
Ingresa el Término de búsqueda: presentación
```

6) Salir: Cierra la aplicación.

## Pruebas Unitarias
El proyecto incluye pruebas unitarias para las funcionalidades principales:

- Agregar tareas.
- Editar tareas.
- Eliminar tareas.

Para ejecutar las pruebas:

```bash
mvn test
```

Los resultados pueden ser exportados a un archivo con:

```bash
mvn test > resultados-pruebas.txt
```



## Autor

Creado por Camila Alvarado como parte de un ejercicio práctico para Curso Java Backend - Talento Futuro
