package prestamo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SistemaPrestamos sistema = new SistemaPrestamos();
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar aprendiz");
            System.out.println("2. Registrar equipo");
            System.out.println("3. Listar equipos");
            System.out.println("4. Prestar equipo");
            System.out.println("5. Listar prestamos activos");
            System.out.println("6. Devolver equipo");
            System.out.println("7. Salir");

            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {

                    case 1:
                        System.out.print("Documento: ");
                        String doc = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nom = sc.nextLine();

                        System.out.print("Ficha: ");
                        String ficha = sc.nextLine();

                        System.out.print("Teléfono: ");
                        String tel = sc.nextLine();

                        sistema.registrarAprendiz(new Aprendiz(doc, nom, ficha, tel));
                        break;

                    case 2:
                        System.out.print("Código: ");
                        String cod = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Categoría: ");
                        String cat = sc.nextLine();

                        sistema.registrarEquipo(new Equipo(cod, nombre, cat));
                        break;

                    case 3:
                        sistema.listarEquipos();
                        break;

                    case 4:
                        System.out.print("Documento aprendiz: ");
                        String d = sc.nextLine();

                        System.out.print("Código equipo: ");
                        String c = sc.nextLine();

                        sistema.prestarEquipo(d, c);
                        break;

                    case 5:
                        sistema.listarPrestamosActivos();
                        break;

                    case 6:
                        System.out.print("ID préstamo: ");
                        int id = sc.nextInt();
                        sistema.devolverEquipo(id);
                        break;

                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }

        } while (opcion != 7);

        sc.close();
    }
}