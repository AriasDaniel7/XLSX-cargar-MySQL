/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo;

/**
 *
 * @author Daniel Arias
 */
public class Producto {

    private int codigo;
    private int cantidad;
    private String descripcion;
    private Double valorUnidad;
    private Double valorEntrada;
    private Double valorTotal;

    public Producto(int codigo, String descripcion, int cantidad, Double valorUnidad, Double valorEntrada) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.valorUnidad = valorUnidad;
        this.valorEntrada = valorEntrada;
        this.valorTotal = valorUnidad * cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValorUnidad() {
        return valorUnidad;
    }

    public void setValorUnidad(Double valorUnidad) {
        this.valorUnidad = valorUnidad;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(Double valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return this.codigo + "\n"
                + this.descripcion + "\n"
                + this.cantidad + "\n"
                + this.valorUnidad + "\n"
                + this.valorEntrada + "\n"
                + this.valorTotal + "\n";
    }

}
