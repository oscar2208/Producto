package producto;

/**
 *
 * @author MARIANA
 */

// se define la clase producto
public class producto
{
    
// se definen y encapsulan los atributos de la clase
private String codigo;
private String nombre;
private int cantProductos;
private double precio;

// se crea el método constructor de "producto"
public producto(String codigo, String nombre, int cantProductos, double precio)
    {
    this.codigo = codigo;
    this.nombre = nombre;
    this.cantProductos = cantProductos;
    this.precio = precio;
    }

// se abstraen los atributos
        public String getCodigo() {
        return codigo;
        }
   
        public void setCodigo(String codigo) {
        this.codigo = codigo;
        }
        
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }
        
        public int getCantProductos() {
        return cantProductos;
        }
        
        public void setCantProductos(int cantProductos) {
        this.cantProductos = cantProductos;
        }
        
        // se define el comportamiento de "imprimirDetalles"
        public void imprimirDetalles()
        {
        System.out.println("Indice del producto: "+ getCantProductos());
        System.out.println("Codigo: "+ codigo);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Precio: $"+ precio);
        }
    }