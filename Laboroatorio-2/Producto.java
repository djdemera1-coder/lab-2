/**
 * Clase base que representa un producto genérico del inventario.
 */
public class Producto {

    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private static int contadorProductos = 0;

    /**
     * Constructor parametrizado del producto.
     * @param codigo Código único del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @throws IllegalArgumentException Si alguno de los datos es inválido.
     */
    public Producto(String codigo, String nombre, double precio,int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock=stock;
        this.precio = precio;

        contadorProductos++;
    }

    // ----------- Getters ------------
    public String getCodigo() {
         return codigo; 
        }
    public String getNombre() {
         return nombre; 
        }
    public double getPrecio() { 
        return precio; 
    }

    public int getStock() {
        return stock;
    }



    /**
     * Retorna el contador total de productos creados.
     * @return Número total de productos.
     */
    public static int getContadorProductos() {
        return contadorProductos;
    }

    // ----------- Setters ------------
    public void setCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty())
            throw new IllegalArgumentException("El código es requerido.");
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new IllegalArgumentException("El nombre es requerido.");
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0)
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        this.precio = precio;
    }

    public void setStock(int stock) {
        if (stock < 0)
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        this.stock = stock;
    }

    public void vender (int cantidad) throws StockInsuficienteException {
        if(cantidad <= 0){
            throw new IllegalArgumentException("La cantidad a vender debe ser positiva ");
    }else if(cantidad > stock){
        throw new StockInsuficienteException ("Stock insuficiente para vender la cantidad solicitada");
    }
        stock -= cantidad;
    }

    /**
     * Retorna una representación base del producto.
     * @return Información base en formato texto.
     */
    protected String getDetalleBase() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio: $" + precio;
    }
}
