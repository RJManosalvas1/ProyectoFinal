import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el valor del vehículo: ");
        double valorVehiculo = scanner.nextDouble();
        Vehiculo miVehiculo = new Vehiculo(valorVehiculo);

        List<Descuento> descuentos = new ArrayList<>();
        System.out.println("¿Desea aplicar algún descuento? (si/no): ");
        String respuesta = scanner.next();

        while (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Seleccione el tipo de descuento a aplicar:");
            System.out.println("1. Pronto Pago");
            System.out.println("2. Servicio Público");
            System.out.println("3. Traslado de Cuenta");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el porcentaje de descuento por pronto pago: ");
                    double prontoPago = scanner.nextDouble();
                    descuentos.add(new DescuentoProntoPago(prontoPago));
                    break;
                case 2:
                    System.out.print("Ingrese el descuento fijo por servicio público: ");
                    double servicioPublico = scanner.nextDouble();
                    descuentos.add(new DescuentoServicioPublico(servicioPublico));
                    break;
                case 3:
                    System.out.print("Ingrese el porcentaje de descuento por traslado de cuenta: ");
                    double trasladoCuenta = scanner.nextDouble();
                    descuentos.add(new DescuentoTrasladoCuenta(trasladoCuenta));
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("¿Desea aplicar otro descuento? (si/no): ");
            respuesta = scanner.next();
        }

        CalculadorImpuestos calculador = new CalculadorImpuestos(miVehiculo, descuentos);
        double totalImpuestos = calculador.calcularTotalImpuestos();
        System.out.println("Total a pagar después de descuentos: $" + totalImpuestos);

        scanner.close();
    }
}
