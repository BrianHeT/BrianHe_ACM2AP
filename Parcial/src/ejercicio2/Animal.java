package ejercicio2;

import java.time.LocalDate;

public class Animal {
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private LocalDate fechaTurno;
    private String observaciones;

    public Animal(String nombre, String especie, String raza, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.edad = edad;
    }

  
    public void registrarTurno(LocalDate fecha, String observaciones) {
        this.fechaTurno = fecha;
        this.observaciones = observaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getRaza() {
        return raza;
    }

    public int getEdad() {
        return edad;
    }

    public LocalDate getFechaTurno() {
        return fechaTurno;
    }

   

    public String getObservaciones() {
        return observaciones;
    }


	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", especie=" + especie + ", raza=" + raza + ", edad=" + edad
				+ ", fechaTurno=" + fechaTurno + ", observaciones=" + observaciones + "]";
	}
}

