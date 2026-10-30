import java.util.ArrayList;
import java.util.List;

public class Categoria
{
    //Atributos de la clase 'Categoría'
    private String nombre;
    private String descripcion;
    private List<Producto> productos = new ArrayList<>();
    private String rutaImagen;

    //Constructor
    public Categoria(String nombre, String descripcion, String rutaImagen)
    {
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.rutaImagen=rutaImagen;
    }

    //Metodo de Agregar Producto
    public void agregarProducto (Producto producto)
    {
        //Agregar solo productos que no sean nulos y que no estén dentro de la lista ya
        if (producto!=null && !this.productos.contains(producto))
        {
            this.productos.add(producto); 
        }
    }

    //Metodo de Eliminar Producto
    public void eliminarProducto (Producto producto)
    {
        this.productos.remove(producto);
    }

    //Metodo de Buscar Producto
    public Producto buscarProducto (String nombre)
    {
        for (Producto producto : this.productos)
        {
            if (producto.getNombre().equalsIgnoreCase(nombre))
            {
                return producto;
            }
        }
        return null;
    }

    //Metodo de Consultar Productos
    public List<Producto> consultarProductos()
    {
            return this.productos;
    }

    //Metodo de Consultar Productos Disponibles
    public List<Producto> consultarProductosDisponibles ()
    {
        List<Producto> disponibles = new ArrayList<>();
        for (Producto producto : this.productos)
        {
            if (producto.isDisponible())
            {
                disponibles.add(producto);
            }
        }
        return disponibles;
    }

    //Setters y Getters
    //-Nombre
    public String getNombre ()
    {
        return nombre;
    }
    public void setNombre(String nombre)
    {
        this.nombre=nombre;
    }

    //-Descripción
    public String getDescripcion ()
    {
        return descripcion;
    }
    public void setDescripcion (String descripcion)
    {
        this.descripcion=descripcion;
    }

    //Ruta de Imagen
    public String getRutaImagen ()
    {
        return rutaImagen;
    }
    public void setRutaImagen (String rutaImagen)
    {
        this.rutaImagen=rutaImagen;
    }
}
