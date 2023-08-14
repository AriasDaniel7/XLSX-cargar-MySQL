/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Arias
 */
public class CrudProducto {

    protected conexionDB conexion;
    protected PreparedStatement ps;
    protected ResultSet rs;

    public CrudProducto() {
        conexion = new conexionDB();
    }

    public boolean insertarProductoStock(Producto p) {
        try {
            ps = conexion.getConexion().prepareStatement("INSERT INTO productos_stock(cantidad,descripcion,valorUnidad, precioProductoEntrada) VALUES (?,?,?,?)");
            ps.setInt(1, p.getCantidad());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getValorUnidad());
            ps.setDouble(4, p.getValorEntrada());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "conexion", JOptionPane.ERROR_MESSAGE);
            return false;
        } finally {
            conexion.cerrarConexion();
        }
    }
}
