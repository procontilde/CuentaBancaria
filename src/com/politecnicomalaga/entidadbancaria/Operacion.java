package com.politecnicomalaga.entidadbancaria;

public class Operacion {

    private long codigo;
    private String fechaOperacion;
    private float cantidad;

    public Operacion(long codigo, String fechaOperacion, float cantidad) {

        this.codigo = codigo;
        this.fechaOperacion = fechaOperacion;
        this.cantidad = cantidad;

    }

    public void crearCodigo() {

        this.codigo = Math.round(Math.random() * 1000000);

    }

    public long getCodigo() { return codigo; }
    public String getFechaOperacion() { return fechaOperacion; }
    public float getCantidad() { return cantidad; }

    public void setCodigo(long codigo) { this.codigo = codigo; }
    public void setFechaOperacion(String fechaOperacion) { this.fechaOperacion = fechaOperacion; }
    public void setCantidad(float cantidad) { this.cantidad = cantidad; }

    @Override
    public String toString() {

        return "codigo;" + codigo + ";\n"
                + "fechaOperacion;" + fechaOperacion + ";\n"
                + "cantidad;" + cantidad + ";\n";

    }

}

