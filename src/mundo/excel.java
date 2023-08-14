/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Daniel Arias
 */
public class excel {

    private ControlProducto cp;

    public excel() {
        cp = new ControlProducto();
    }

    public void leerArchivoExcel() {
        try {
            FileInputStream archivo = new FileInputStream("src/excel/productos.xlsx");
            XSSFWorkbook libro = new XSSFWorkbook(archivo);
            XSSFSheet hoja = libro.getSheetAt(0);
            int filas = hoja.getLastRowNum();

            for (int i = 1; i < filas; i++) {
                Row fila = hoja.getRow(i);

                Cell nombre = fila.getCell(0);
                Cell unidades = fila.getCell(1);
                Cell precioUnidad = fila.getCell(2);
                Cell precioEntrada = fila.getCell(3);

                String descripcion = nombre.getStringCellValue();
                int cantidad = (int) unidades.getNumericCellValue();
                Double valorUnidad = precioUnidad.getNumericCellValue();
                Double valorEntrada = precioEntrada.getNumericCellValue();

                Producto p = new Producto(0, descripcion, cantidad, valorUnidad, valorEntrada);
                cp.agregarProducto(p);
            }
            cp.imprimirProductos();
            //cp.insertarBasedatos();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
