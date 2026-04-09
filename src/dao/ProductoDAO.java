package dao;

import conexion.Conexion;
import modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoDAO {

    // INSERTAR
    public void insertar(Producto producto) {
        String sql = "INSERT INTO producto (nombre, cantidad, precio) VALUES (?, ?, ?)";

        try {
            Connection conn = Conexion.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, producto.getNombre());
            ps.setInt(2, producto.getCantidad());
            ps.setDouble(3, producto.getPrecio());

            ps.executeUpdate();
            System.out.println("Producto insertado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // LISTAR
    public void listar() {
        String sql = "SELECT * FROM producto";

        try {
            Connection conn = Conexion.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                    "ID: " + rs.getInt("id_producto") +
                    " | Nombre: " + rs.getString("nombre") +
                    " | Cantidad: " + rs.getInt("cantidad") +
                    " | Precio: " + rs.getDouble("precio")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ACTUALIZAR
    public void actualizar(int id, String nombre, int cantidad, double precio) {
        String sql = "UPDATE producto SET nombre=?, cantidad=?, precio=? WHERE id_producto=?";

        try {
            Connection conn = Conexion.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, cantidad);
            ps.setDouble(3, precio);
            ps.setInt(4, id);

            ps.executeUpdate();
            System.out.println("Producto actualizado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ELIMINAR
    public void eliminar(int id) {
        String sql = "DELETE FROM producto WHERE id_producto=?";

        try {
            Connection conn = Conexion.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Producto eliminado correctamente");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}