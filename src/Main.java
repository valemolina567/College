import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        College college = new College();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Editar estudiante");
            System.out.println("3. Eliminar estudiante");
            System.out.println("4. Mostrar estudiantes");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    addStudent(college, scanner);
                    break;
                case 2:
                    editStudent(college, scanner);
                    break;
                case 3:
                    deleteStudent(college, scanner);
                    break;
                case 4:
                    displayStudents(college);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);

        scanner.close();
    }

    private static void addStudent(College college, Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String name = scanner.nextLine();
        System.out.print("Ingrese el ID del estudiante: ");
        String studentId = scanner.nextLine();
        Student student = new Student(name, studentId);
        college.addStudent(student);
        System.out.println("Estudiante agregado exitosamente.");
    }

    private static void editStudent(College college, Scanner scanner) {
        displayStudents(college);
        System.out.print("Ingrese el número del estudiante que desea editar: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer

        if (index >= 0 && index < college.getStudentList().size()) {
            System.out.print("Ingrese el nuevo nombre del estudiante: ");
            String name = scanner.nextLine();
            System.out.print("Ingrese el nuevo ID del estudiante: ");
            String studentId = scanner.nextLine();
            Student student = college.getStudent(index);
            student.setName(name);
            student.setStudentId(studentId);
            System.out.println("Estudiante editado exitosamente.");
        } else {
            System.out.println("Número de estudiante inválido.");
        }
    }

    private static void deleteStudent(College college, Scanner scanner) {
        displayStudents(college);
        System.out.print("Ingrese el número del estudiante que desea eliminar: ");
        int index = scanner.nextInt() - 1; // Convertir de 1-based a 0-based index

        if (index >= 0 && index < college.getStudentList().size()) {
            college.deleteStudent(college.getStudent(index));
            System.out.println("Estudiante eliminado exitosamente.");
        } else {
            System.out.println("Número de estudiante inválido.");
        }
    }

    private static void displayStudents(College college) {
        if (college.getStudentList().isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("Lista de estudiantes:");
            for (int i = 0; i < college.getStudentList().size(); i++) {
                Student student = college.getStudent(i);
                System.out.println((i + 1) + ". " + student.getName() + " (ID: " + student.getStudentId() + ")");
            }
        }
    }
}