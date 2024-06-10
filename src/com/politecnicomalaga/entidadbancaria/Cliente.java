package com.politecnicomalaga.entidadbancaria;

public class Cliente {

    private String nombre, apellidos, mail;
    private Documento doc;

    public Cliente(String nombre, String apellidos, String mail, Documento doc) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.mail = mail;
        this.doc = doc;

    }

    public String getNombre() { return nombre; }
    public String getApellidos() { return apellidos; }
    public String getMail() { return mail; }
    public Documento getDoc() { return doc; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public void setMail(String mail) { this.mail = mail; }
    public void setDoc(Documento doc) { this.doc = doc; }

    @Override
    public String toString() {

        return "nombre;" + nombre + ";\n"
                + "apellidos;" + apellidos + ";\n"
                + "mail;" + mail + ";\n"
                + "documento;" + doc;

    }

}
