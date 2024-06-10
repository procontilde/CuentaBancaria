package com.politecnicomalaga.entidadbancaria;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {

	private String ccc, fechaApertura;
	private float saldo;
	private Cliente miCliente;
	private List<Operacion> listaOperaciones;

	public Cuenta(String ccc, float saldo, String fechaApertura, Cliente miCliente) {

		this.ccc = ccc;
		this.saldo = saldo;
		this.fechaApertura = fechaApertura;
		this.miCliente = miCliente;
		this.listaOperaciones = new ArrayList<>();

	}

	public boolean retirarEfectivo(float cantidad, String fecha) {

		if (cantidad <= 0) return false;

		if (cantidad <= saldo) {

			saldo -= cantidad;
			Operacion nuevaOperacion = new Operacion(0, fecha, cantidad);
			nuevaOperacion.crearCodigo();
			listaOperaciones.add(nuevaOperacion);

			return true;

		}

		return false;

	}

	public boolean ingresarEfectivo(float cantidad, String fecha) {

		if (cantidad <= 0) return false;
		saldo += cantidad;
		Operacion nuevaOperacion = new Operacion(0, fecha, cantidad);
		nuevaOperacion.crearCodigo();
		listaOperaciones.add(nuevaOperacion);

		return true;

	}

	public String getCcc() { return ccc; }
	public float getSaldo() { return saldo; }
	public String getFechaApertura() { return fechaApertura; }
	public Cliente getMiCliente() { return miCliente; }
	public List<Operacion> getListaOperaciones() { return listaOperaciones; }
	public boolean isActiva() { return saldo > 0; }


	public void setCcc(String ccc) { this.ccc = ccc; }
	public void setFechaApertura(String fechaApertura) { this.fechaApertura = fechaApertura; }
	public void setListaOperaciones(List<Operacion> listaOperaciones) { this.listaOperaciones = listaOperaciones; }
	public void setSaldo(float saldo) { this.saldo = saldo; }
	public void setMiCliente(Cliente miCliente) { this.miCliente = miCliente; }

	@Override
	public String toString() {

		StringBuilder sB = new StringBuilder();
		for (Operacion op : listaOperaciones) sB.append(op.toString()).append("\n");

		return miCliente.toString() +
				"ccc;" + ccc + ";\n"
				+ "saldo;" + saldo + ";\n"
				+ "fechaApertura;" + fechaApertura + ";\n"
				+ "clienteCuenta;" + miCliente + ";\n"
				+ "listaOperaciones;" + listaOperaciones + ";\n"
				+ sB;

	}

}
