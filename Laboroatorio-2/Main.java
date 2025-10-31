import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase principal para probar el sistema de inventario.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producto producto = new Producto("", "", 0, 0); //  Declarado sin inicializar
        boolean productoCreado = false;

        System.out.println("=== Registro de Producto Alimenticio ===");

        // Bucle que se repetirá hasta que el producto se cree correctamente
        while (true) {
            try {
                System.out.print("Ingrese el código: ");
                String codigo = scanner.nextLine();

                System.out.print("Ingrese el nombre: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese el precio: ");
                double precio = scanner.nextDouble();
                scanner.nextLine(); // limpiar buffer

                System.out.print("Ingrese la fecha de caducidad (YYYY-MM-DD): ");
                String fecha = scanner.nextLine();

                // ✅ Crear producto con stock inicial (10 unidades)
                producto = new ProductoAlimenticio(codigo, nombre, precio, fecha, 10);
                productoCreado = true;

                // ✅ Si llega aquí, ya se creó, entonces salimos del bucle
                break;

            } catch (InventarioException e) {
                System.err.println("Error de negocio: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.err.println("Error de validación: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.err.println("Error: se esperaba un número válido para el precio.");
                scanner.nextLine(); // limpiar buffer
            } catch (Exception e) {
                System.err.println("Error inesperado: " + e.getMessage());
            }

            System.out.println("Intente ingresar los datos nuevamente.\n");
        }

        // ✅ El compilador sabe que si llegamos aquí, producto fue creado
        System.out.println("\nProducto registrado con éxito:");
        System.out.println(producto.toString());

        // Mostrar stock inicial
        System.out.println("Stock inicial del producto: " + producto.getStock());

        // Simular una venta con try-catch independiente
        try {
            System.out.print("Ingrese cuántas unidades desea comprar: ");
            int cantidad = scanner.nextInt();

            producto.vender(cantidad);
            System.out.println("Venta exitosa. Nuevo stock: " + producto.getStock());

        } catch (StockInsuficienteException e) {
            System.err.println("Error: No hay suficiente stock disponible. Stock actual: " + producto.getStock());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Cantidad no válida. Debe ingresar un número positivo.");
        } catch (InputMismatchException e) {
            System.err.println("Error: Entrada inválida. Debe ingresar un número entero.");
        }

        System.out.println("Total de productos creados: " + Producto.getContadorProductos());
        scanner.close();
    }
}
