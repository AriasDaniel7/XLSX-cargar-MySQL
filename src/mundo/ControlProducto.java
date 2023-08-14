/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

import java.util.ArrayList;

/**
 *
 * @author Daniel Arias
 */
public class ControlProducto {

    public ArrayList<Producto> lista;
    private CrudProducto cp;

    public ControlProducto() {
        lista = new ArrayList<>();
        cp = new CrudProducto();
    }

    public void agregarProducto(Producto p) {
        lista.add(p);
    }

    public void insertarBasedatos() {
        lista.stream().map((producto) -> {
            producto.setDescripcion(producto.getDescripcion().toUpperCase());
            return producto;
        }).forEach((producto) -> {
            cp.insertarProductoStock(producto);
        });
    }

    public void imprimirProductos() {
        System.out.printf("| %50s", "Descripcion");
        System.out.printf("     | %10s", "Cantidad");
        System.out.printf("     | %10s", "Valor Unidad");
        System.out.printf("   | %10s|", "Valor Entrada");
        System.out.println("");
        lista.stream().map((producto) -> {
            System.out.printf("| %50s", producto.getDescripcion());
            System.out.printf("     | %10s", producto.getCantidad());
            System.out.printf("     | %10s", producto.getValorUnidad());
            System.out.printf("     | %11s  |", producto.getValorEntrada());
            return producto;
        }).forEach((producto) -> {
            System.out.println("");
        });

    }
}
