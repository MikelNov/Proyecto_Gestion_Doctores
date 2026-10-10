import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList<Doctor> listaDoctores = new SinglyLinkedList<>();
        int opcion = 0;

        while (opcion != 7) {
            System.out.println("BIENVENIDO AL SISTEMA DE REGISTRO DE DOCTORES");
            System.out.print("Seleccione una opción: ");
            System.out.println("1. Ingresar nuevo doctor");
            System.out.println("2. Mostrar a los doctores");
            System.out.println("3. Buscar doctor por ID");
            System.out.println("4. Eliminar doctor por ID");
            System.out.println("5. Ver total de doctores registrados");
            System.out.println("6. Editar un doctor");
            System.out.println("7. Salir");


                opcion = Integer.parseInt(scanner.nextLine());

            if (opcion < 1 || opcion > 7) {
                System.out.println("Error: Ingresa una opción válida del 1 al 6.");
            } else {
                switch (opcion) {
                    case 1:
                        newDoctor(scanner, listaDoctores);
                        break;
                    case 2:
                        showDoctors(listaDoctores);
                        break;
                    case 3:
                        searchDoctor(scanner, listaDoctores);
                        break;
                    case 4:
                        removeDoctor(scanner, listaDoctores);
                        break;
                    case 5:
                        showTotal(listaDoctores);
                        break;
                    case 6:
                        editDoctor(scanner, listaDoctores);
                        break;
                    case 7:
                        System.out.println("Gracias por ocupar el sistema");
                        break;                }
            }
        }
    }

    private static void newDoctor(Scanner scanner, SinglyLinkedList<Doctor> lista) {
        System.out.println("REGISTRO DE NUEVO DOCTOR ");
        System.out.print("Ingrese ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        if (lista.contains(new Doctor(id))) {
            System.out.println("Aviso: Ya existe un doctor registrado con el ID " + id);
            return;
        }

        System.out.print("Ingrese el nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = Integer.parseInt(scanner.nextLine());

        System.out.print("Ingrese la especialidad: ");
        String especialidad = scanner.nextLine();

        System.out.print("Ingrese el estado (ej. Activo / Inactivo): ");
        String estado = scanner.nextLine();

        Doctor doctor = new Doctor(id, nombre, edad, especialidad, estado);
        lista.insertLast(doctor);
        System.out.println("Doctor registrado exitosamente.");
    }


    private static void showDoctors(SinglyLinkedList<Doctor> lista) {
        System.out.println("LISTA DE DOCTORES REGISTRADOS");
        if (lista.isEmpty()) {
            System.out.println("No hay doctores en el sistema.");
        } else {
            lista.traverse();
        }
    }

    private static void searchDoctor(Scanner scanner, SinglyLinkedList<Doctor> lista) {
        System.out.print("\nIngrese el ID del doctor a buscar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Doctor encontrado = lista.find(new Doctor(id));
        if (encontrado != null) {
            System.out.println("Información encontrada:\n" + encontrado);
        } else {
            System.out.println("No se encontró ningún doctor con el ID " + id);
        }
    }

    private static void removeDoctor(Scanner scanner, SinglyLinkedList<Doctor> lista) {
        System.out.print("\nIngrese el ID del doctor a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());

        boolean eliminado = lista.remove(new Doctor(id));
        if (eliminado) {
            System.out.println("Doctor con ID " + id + " eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar: el ID no existe o la lista está vacía.");
        }
    }
    private static void showTotal(SinglyLinkedList<Doctor> lista) {
        System.out.println("\nTotal de doctores registrados: " + lista.getSize());
    }

    private static void editDoctor(Scanner scanner, SinglyLinkedList<Doctor> lista) {
        System.out.print("\nIngrese el ID del doctor a editar: ");
        int id;
        id = Integer.parseInt(scanner.nextLine());


        Doctor doctor = lista.find(new Doctor(id));
        if (doctor == null) {
            System.out.println("Error: Doctor no encontrado.");
            return;
        }

        System.out.println("\nDoctor actual: " + doctor);
        System.out.println("¿Qué campo desea modificar?");
        System.out.println("1. Nombre");
        System.out.println("2. Edad");
        System.out.println("3. Especialidad");
        System.out.println("4. Estado");
        System.out.println("5. Cancelar");
        System.out.print("Seleccione: ");
        int segOp = 0;
        segOp = Integer.parseInt(scanner.nextLine());

        switch (segOp) {
            case 1:
                System.out.print("Nuevo nombre: ");
                doctor.setNombre(scanner.nextLine());
                System.out.println("Nombre actualizado.");
                break;
            case 2:
                System.out.print("Nueva edad: ");
                doctor.setEdad(Integer.parseInt(scanner.nextLine()));
                System.out.println("Edad actualizada.");
                break;
            case 3:
                System.out.print("Nueva especialidad: ");
                doctor.setEspecialidad(scanner.nextLine());
                System.out.println("Especialidad actualizada.");
                break;
            case 4:
                System.out.print("Nuevo estado: ");
                doctor.setEstado(scanner.nextLine());
                System.out.println("Estado actualizado.");
                break;
            case 5:
                System.out.println("Edición cancelada.");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}