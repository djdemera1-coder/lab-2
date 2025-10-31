/**
 * Clase que representa un producto electrónico.
 */
public class ProductoElectronico extends Producto {

    private int mesesGarantia;

    /**
     * Constructor parametrizado.
     * @param codigo Código del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param mesesGarantia Meses de garantía del producto.
     * @throws IllegalArgumentException Si los meses de garantía son negativos.
     */



    public ProductoElectronico(String codigo, String nombre, double precio, int mesesGarantia,int stock) {
        super(codigo, nombre, precio,stock);
        this.mesesGarantia = mesesGarantia;
    }

    public int getMesesGarantia() {
        return mesesGarantia;
    }

    public void setMesesGarantia(int mesesGarantia) {
        if (mesesGarantia < 0)
            throw new IllegalArgumentException("Los meses de garantía no pueden ser negativos.");
        this.mesesGarantia = mesesGarantia;
    }

    @Override
    public String toString() {
        return getDetalleBase() + ", Garantía: " + mesesGarantia + " meses";
    }
}
