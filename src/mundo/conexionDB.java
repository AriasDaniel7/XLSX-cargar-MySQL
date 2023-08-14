package mundo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Arias
 */
public class conexionDB {

    protected Connection conexion;
    protected String BD;
    protected String HOST;
    protected String PORT;
    protected String URL;
    protected String USER;
    protected String CLAVE;

    public conexionDB() {
        conexion = null;
        BD = "pg_negocio";
        HOST = "localhost";
        PORT = "3306";
        URL = "jdbc:mysql://" + HOST + "/" + BD;
        USER = "root";
        CLAVE = "admin";
    }

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, CLAVE);
            return conexion;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexion fallida" + e, "conexion", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "desconexion fallida " + e, " conexion", JOptionPane.ERROR_MESSAGE);
        }
    }
}
