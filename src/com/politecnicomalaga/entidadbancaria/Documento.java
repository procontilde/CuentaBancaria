package com.politecnicomalaga.entidadbancaria;

public class Documento {

    private String tipo, numero;

    public Documento(String tipo, String numero) {

        this.tipo = tipo;
        this.numero = numero;

    }

    public String getTipo() { return tipo; }
    public String getNumero() { return numero; }

    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setNumero(String numero) { this.numero = numero; }

    @Override
    public String toString() {

        return "tipo;" + tipo + ";\n"
                + "numero;" + numero + ";\n";

    }

}
