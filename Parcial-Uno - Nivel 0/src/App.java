import domain.Ahorro;
import domain.Corriente;
import domain.Cuenta;
import java.util.List;
import java.util.Scanner;
import service.ServiceCuenta;

public class App {
    public static void main(String[] args) {
        ServiceCuenta serviceCuenta = new ServiceCuenta();
        List<Cuenta> cuentas = serviceCuenta.obtenerCuentas(); // usar este vector siempre
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMENU PRINCIPAL ");
            System.out.println("1. Listar cuentas Ahorro");
            System.out.println("2. Listar cuentas Corriente");
            System.out.println("3. Crear cuenta Ahorro");
            System.out.println("4. Crear cuenta Corriente");
            System.out.println("5. Obtener informacion de una cuenta por numero de cuenta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Cuentas Ahorro ---");
                    for (Cuenta c : cuentas) {
                        if (c instanceof Ahorro) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- Cuentas Corriente ---");
                    for (Cuenta c : cuentas) {
                        if (c instanceof Corriente) {
                            System.out.println(c);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Ingrese numero de cuenta: ");
                    String numA = sc.nextLine();
                    System.out.print("Ingrese DNI cliente: ");
                    long dniA = sc.nextLong();
                    System.out.print("Ingrese saldo inicial: ");
                    double saldoA = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Ingrese fecha de creacion: ");
                    String fecha = sc.nextLine();
                    serviceCuenta.crearCuenta(new Ahorro(numA, dniA, saldoA, fecha));
                    System.out.println("✅ Cuenta de Ahorro creada.");
                    break;

                case 4:
                    System.out.print("Ingrese numero de cuenta: ");
                    String numC = sc.nextLine();
                    System.out.print("Ingrese DNI cliente: ");
                    long dniC = sc.nextLong();
                    System.out.print("Ingrese saldo inicial: ");
                    double saldoC = sc.nextDouble();
                    System.out.print("Ingrese impuesto: ");
                    double impuesto = sc.nextDouble();
                    sc.nextLine();
                    serviceCuenta.crearCuenta(new Corriente(numC, dniC, saldoC, impuesto));
                    System.out.println("✅ Cuenta Corriente creada.");
                    break;

                case 5:
                    System.out.print("Ingrese el numero de cuenta: ");
                    String buscar = sc.nextLine();
                    Cuenta encontrada = serviceCuenta.obtenernumeroCuenta(buscar);
                    if (encontrada != null) {
                        System.out.println("Cuenta encontrada: " + encontrada);
                    } else {
                        System.out.println(" No existe una cuenta con ese numero.");
                    }
                    break;

                case 0:
                    System.out.println(" Saliendo");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }
}
