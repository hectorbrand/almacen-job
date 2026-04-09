import dao.ProductoDAO;
import modelo.Producto;

public class TestConexion {

    public static void main(String[] args) {

        ProductoDAO dao = new ProductoDAO();

        // INSERTAR
        Producto p = new Producto("Cafe", 3, 5000);
        dao.insertar(p);

        // ACTUALIZAR (ID 1)
        dao.actualizar(1, "Arroz Premium", 20, 4000);

        // ELIMINAR (ID 2)
        dao.eliminar(2);

        // LISTAR
        dao.listar();
    }
}