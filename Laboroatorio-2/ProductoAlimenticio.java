/**
 * Clase que representa un producto alimenticio.
 */
public class ProductoAlimenticio extends Producto {

    private String fechaCaducidad;

    /**
     * Constructor parametrizado.
     * @param codigo Código del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param fechaCaducidad Fecha de caducidad en formato "YYYY-MM-DD".
     * @throws InventarioException Si el producto está caducado.
     */
    public ProductoAlimenticio(String codigo, String nombre, double precio, String fechaCaducidad,int stock)throws InventarioException {
        super(codigo, nombre, precio,stock);
        this.fechaCaducidad = fechaCaducidad;;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    /**
     * Simula la validación de la fecha de caducidad.
     * Si la fecha es "2024-01-01" (o anterior), se considera caducada.
     * @param fecha Fecha de caducidad.
     * @throws InventarioException Si la fecha corresponde a un producto caducado.
     */
    public void setFechaCaducidad(String fecha) throws InventarioException {
        if (fecha == null || fecha.trim().isEmpty())
            throw new IllegalArgumentException("La fecha de caducidad es requerida.");

        // Validación simulada
        if (fecha.compareTo("2025-01-01") < 0) {
            throw new InventarioException("El producto está caducado.");
        }

        this.fechaCaducidad = fecha;
    }

    @Override
    public String toString() {
        return getDetalleBase() + ", Fecha de caducidad: " + fechaCaducidad;
    }
}
