package producto;

/**
 *
 * @author MARIANA
 */

// se importan opciones que se usarán a lo largo del programa
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

// se define la clase ProductoVenta

public class ProductoVenta 
{
    public static void main(String[] args) 
    {
        
    // se define "scanner" para el ingreso de los datos desde la consola y "listaProductos" como el ArrayList o el atributo que almacenará los datos
    Scanner scanner = new Scanner(System.in);
    ArrayList<producto> listaProductos = new ArrayList<>();
        
            // se define "option" como el código interno para cambiar las opciones que tendrá el usuario en el menú
            int option; 
            
            // se define el menú que será impreso y visible para el usuario
            do 
                {
                    System.out.println("\nMenu Principal");
                    System.out.println("1. Agregar producto");
                    System.out.println("2. Editar producto");
                    System.out.println("3. Eliminar producto");
                    System.out.println("4. Imprimir productos");
                    System.out.println("5. Salir");
                    System.out.print("Seleccione una opcion: ");
                    option = scanner.nextInt();
                    
                    // se le indica al programa que cambie entre las opciones y se explica cada una de estás
                    switch (option) 
                        {
                        
                        /* se le indica al programa que en el caso #1 se le solicitará al usuario ingresar el código, nombre y precio del producto.
                        Sin embargo, se le pide al programa validar por el nombre si el producto ya existe, y en ese caso, indicarle al usuario
                        que el producto ya está ingresqado. Además, se utiliza la palabra reservada "break" para cambiar a la siguiente opción del menú 
                        */
                        case 1:
                            scanner.nextLine();
                            System.out.print("Ingrese el codigo del producto: ");
                            String codigo = scanner.nextLine();
                            System.out.print("Ingrese el nombre del producto: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese el precio del producto: ");
                            double precio = scanner.nextDouble();
                            
                            boolean productoExistente = false;
                            for (producto producto : listaProductos)
                                {
                                    if (producto.getNombre().equalsIgnoreCase(nombre))
                                        {
                                            productoExistente = true;
                                            System.out.println("El producto ya existe");
                                            break;
                                        }
                                }
                            if (!productoExistente)
                                {
                                    int cantProductos = listaProductos.size();
                                    listaProductos.add(new producto(codigo, nombre, cantProductos, precio));
                                    System.out.println("Producto agregado");
                                }
                            break;

                        /* se le solicita al programa buscar por nombre el producto indicado por el usuario para realizar la modificación del mismo.
                            En el caso de que el producto no exista aún en el programa, el programa le indicará al usuario que el producto no existe
                            */
                        case 2:
                            scanner.nextLine();
                            System.out.print("Ingrese el nombre del producto a editar: ");
                            String nombreEditar = scanner.nextLine();
                                    
                            boolean productoEncontrado = false;
                            for (producto producto : listaProductos)
                            {
                                if (producto.getNombre().equalsIgnoreCase(nombreEditar))
                                productoEncontrado = true;
                                System.out.print("Ingrese el nuevo codigo del producto: ");
                                String nuevoCodigo = scanner.nextLine();
                                System.out.print("Ingrese el nuevo nombre del producto: ");
                                String nuevoNombre = scanner.nextLine();
                                System.out.print("Ingrese el nuevo precio del producto: ");
                                double nuevoPrecio = scanner.nextDouble();
                                 
                                 producto.setNombre(nuevoNombre);
                                 producto.setPrecio(nuevoPrecio);
                                 System.out.println("Producto editado");
                                 break;
                                 }
                            if (!productoEncontrado)
                                {
                                    System.out.println("Producto no existente");
                                }
                            break;
                            
                         /* se le solicita al programa buscar por nombre el producto indicado por el usuario para eliminar el mismo.
                            En el caso de que el producto no exista aún en el programa, el programa le indicará al usuario que el producto no existe
                            */   
                        case 3:
                            scanner.nextLine();
                            System.out.print("Ingrese el nombre del producto que desea eliminar: ");
                            String nombreEliminar = scanner.nextLine();
                            
                            boolean productoEliminar = false;
                            for (Iterator<producto> iterator = listaProductos.iterator(); iterator.hasNext();) 
                                {
                                producto producto = iterator.next();
                                if (producto.getNombre().equalsIgnoreCase(nombreEliminar)) 
                                {
                                iterator.remove();
                                productoEliminar = true;
                                System.out.println("Producto eliminado con exito");
                                break;
                                }  
                            }

                            if (!productoEliminar)
                                {
                                    System.out.println("Producto no existente");
                                }
                            break;
                            
                        // se le solicita al programa imprimir todos los productos almacenados en listaProductos    
                        case 4:
                            System.out.println("Lista de productos:");
                            if (listaProductos.size() > 0)
                            {
                            for (int i = 0; i < listaProductos.size(); i++)
                            {
                            listaProductos.get(i).imprimirDetalles();
                            }
                            }
                            else
                            {
                            System.out.println("No hay productos para imprimir");
                            }
                          break;
                          
                        // se imprime el mensaje de "saliendo del programa" para indicarle al usuario que el se salió del mismo con éxito
                        case 5:
                        System.out.println("Saliendo del programa");
                        break;
                        default:
                        System.out.println("Opcion invalida. Intente nuevamente: ");
                }
            }
            
            while (option != 5);
            
            // se cierra el escaner con el fin de indicarle al programa que ya no se solicitará más el ingreso de datos por consola
            scanner.close();
    }
  }