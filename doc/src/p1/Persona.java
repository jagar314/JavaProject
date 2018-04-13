package p1;

import java.util.GregorianCalendar;

public class Persona{

private String Tipo, Nombre, Apellidos,Fecha,dni;
private GregorianCalendar FechaDeNacimiento;

public String getDNI() {
	return dni;
}
public void setDNI(String dni) {
	this.dni = dni;
}
public String getTipo() {
	return Tipo;
}
public void setTipo(String tipo) {
	Tipo = tipo;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getApellidos() {
	return Apellidos;
}
public void setApellidos(String apellidos) {
	Apellidos = apellidos;
}
public GregorianCalendar getFechaDeNacimiento() {
	return FechaDeNacimiento;
}
public void setFechaDeNacimiento(GregorianCalendar fechaDeNacimiento) {
	FechaDeNacimiento = fechaDeNacimiento;
}
@Override
public String toString() {
	String l=System.getProperty("line.separator");
	return l + Nombre  + l + Apellidos + l 
			+ Fecha;
}

public Persona(String tipo,String dni, String nombre, String apellidos, String fechaDeNacimiento){
	Nombre = nombre;
	Apellidos = apellidos;
	this.dni=dni;
	Fecha=fechaDeNacimiento;
	 String[] Fecha = fechaDeNacimiento.split("/");
	    FechaDeNacimiento= new GregorianCalendar(Integer.parseInt(Fecha[2].trim()), 
	      Integer.parseInt(Fecha[1])-1, Integer.parseInt(Fecha[0]));
}

}
