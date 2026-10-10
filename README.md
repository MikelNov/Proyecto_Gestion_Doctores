# Sistema de Gestión de Doctores

Sistema de consola desarrollado en Java que administra el registro de personal médico mediante una implementación propia de una LinkedList

## Descripción
El proyecto permite registrar y administrar doctores de manera sencilla mediante un menú interactivo en la consola.

Su propósito principal es aplicar los conceptos de programación orientada a objetos y estructuras de datos, utilizando una lista simplemente enlazada para almacenar y gestionar los registros sin depender de las colecciones predefinidas de Java.

## Tecnologías Utilizadas

Java: lenguaje de programación.
IntelliJ IDEA: entorno de desarrollo integrado (IDE)
Paradigma: Programación Orientada a Objetos (POO)
---

## Requisitos Previos

Java JDK instalado.
IntelliJ IDEA u otro editor compatible con Java.
Git instalado (opcional, para clonar el repositorio).

## Instalación y Ejecución

1.Clona el repositorio:

git clone https://github.com/tu-usuario/registro-doctores.git

2. Abre el proyecto en IntelliJ IDEA.

3.Verifica que Java JDK esté configurado correctamente.

4.Ejecuta la clase Main.java.

## Guía de Uso del Menú

Al iniciar el sistema se desplegará el menú interactivo con las siguientes opciones:

1. Ingresar nuevo doctor: Solicita de forma interactiva el ID, nombre completo, edad, especialidad y estado operativo. Valida previamente que el ID no se encuentre duplicado en la lista.
2. Mostrar a los doctores: Recorre secuencialmente todos los nodos desde `head` hasta `null`, mostrando en pantalla la ficha técnica completa de cada médico registrado.
3. Buscar doctor por ID: Solicita un número de identificación y localiza el objeto en tiempo lineal O(n), imprimiendo los datos si existe o notificando si no fue encontrado.
4. Eliminar doctor por ID: Localiza el nodo correspondiente, reconecta las referencias del nodo anterior con el nodo siguiente en la cadena para omitirlo, reduce el tamaño y libera la memoria.
5. Ver total de doctores registrados:** Consulta y muestra en tiempo constante O(1) la cantidad exacta de registros activos.
6. Editar un doctor (Funcionalidad extra):** Solicita el ID del doctor a modificar y despliega un submenú que permite actualizar selectivamente el nombre, la edad, la especialidad o el estado sin romper la estructura de la lista ligada.
7. Salir: Termina la ejecución del ciclo principal y despide la sesión de consola.

---

## Características

- **Sin dependencias de librerías de colecciones:** La lista y los nodos se programaron desde cero con enlace manual de memoria.
- **Uso de Genéricos (`<T>`):** La clase de lista y nodo están desacopladas del modelo médico, lo que permite reutilizar la misma estructura con cualquier otro tipo de objeto.
- **Encapsulamiento estricto:** Todos los campos de las clases son privados y se accede a ellos exclusivamente por métodos autorizados.
- **Manejo robusto de entradas:** Uso de `Integer.parseInt(scanner.nextLine())` respaldado por bloques `try-catch (NumberFormatException)` para evitar que la aplicación se cierre abruptamente ante entradas de texto erróneas.

---

## Autor

-Luis Mikel Novas Perez
-Email: junior77mikel@gmail.com