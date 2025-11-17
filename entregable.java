import java.util.ArrayList;
import java.util.Scanner;

class Paciente {
    String nombre;
    String dni;
    String fechaNacimiento;
    String telefono;
    String direccion;
    String email;
    String enfermedades_ciruj;
    String alergias;
    String antecedentes_fam;

    public Paciente(String nombre, String dni, String fechaNacimiento, String telefono, String direccion, String email, String enfermedades_ciruj, String alergias, String antecedentes_fam) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.enfermedades_ciruj = enfermedades_ciruj;
        this.alergias = alergias;
        this.antecedentes_fam = antecedentes_fam;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " | Nombre: " + nombre + " | Tel: " + telefono;
    }
}

public class entregable {
    static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN CLÍNICA ---");
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Mostrar paciente por DNI");
            System.out.println("3. Mostrar todos los pacientes");
            System.out.println("4. Salir del sistema");
            System.out.print("Ingrese una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Por favor ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    buscarPacientePorDNI();
                    break;
                case 3:
                    mostrarTodosLosPacientes();
                    break;
                case 4:
                    System.out.println("Cerrando el sistema... Gracias.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
    }

    public static void registrarPaciente() {
        System.out.println("\n--- REGISTRO DE NUEVO PACIENTE ---");

        System.out.print("Ingrese Nombre Completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese DNI: ");
        String dni = scanner.nextLine();

        System.out.print("Ingrese Fecha de Nacimiento (DD/MM/AAAA): ");
        String fecha = scanner.nextLine();

        System.out.print("Ingrese Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese Dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese Email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese Enfermedades o Cirugías Previas: ");
        String enf_ciruj = scanner.nextLine();

        System.out.print("Ingrese Alergias: ");
        String alergias = scanner.nextLine();

        System.out.print("Ingrese Antecedentes Familiares: ");
        String antecedentes = scanner.nextLine();

        Paciente nuevoPaciente = new Paciente(
                nombre, dni, fecha, telefono, direccion, email,
                enf_ciruj, alergias, antecedentes
        );

        listaPacientes.add(nuevoPaciente);

        System.out.println(">> ¡Paciente Registrado Correctamente! <<");
    }

    public static void buscarPacientePorDNI() {
        System.out.print("\nIngrese el DNI a buscar: ");
        String dniBusqueda = scanner.nextLine();
        boolean encontrado = false;

        for (Paciente p : listaPacientes) {
            if (p.dni.equals(dniBusqueda)) {
                System.out.println("\n--- PACIENTE ENCONTRADO ---");
                System.out.println("Nombre: " + p.nombre);
                System.out.println("DNI: " + p.dni);
                System.out.println("Fecha Nac: " + p.fechaNacimiento);
                System.out.println("Teléfono: " + p.telefono);
                System.out.println("Dirección: " + p.direccion);
                System.out.println("Email: " + p.email);
                System.out.println("Enfermedades/Cirugías: " + p.enfermedades_ciruj);
                System.out.println("Alergias: " + p.alergias);
                System.out.println("Antecedentes Familiares: " + p.antecedentes_fam);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún paciente con el DNI: " + dniBusqueda);
        }
    }

    public static void mostrarTodosLosPacientes() {
        System.out.println("\n--- LISTA COMPLETA DE PACIENTES ---");
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados aún.");
        } else {
            for (Paciente p : listaPacientes) {
                System.out.println(p.toString());
            }
        }
    }
}