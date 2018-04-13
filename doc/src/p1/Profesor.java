package p1;

public class Profesor extends Persona{


private String Categoria, Departamento, DocenciaImpartida;
private int HorasAsignables; public int Duracion;

public int getDuracion() {
	return Duracion;
}

public void setDuracion(int duracion) {
	Duracion = duracion;
}

public Profesor(String tipo,String dni, String nombre, String apellidos, String fechaDeNacimiento, String categoria, String departamento, int horasAsignables, String docenciaImpartida){
	super(tipo, dni, nombre, apellidos, fechaDeNacimiento);
	Categoria=categoria;
	Departamento=departamento;
	HorasAsignables=horasAsignables;
	DocenciaImpartida=docenciaImpartida;
}

public String getCategoria() {
	return Categoria;
}
public void setCategoria(String categoria) {
	Categoria = categoria;
}
public String getDepartamento() {
	return Departamento;
}
public void setDepartamento(String departamento) {
	Departamento = departamento;
}
public String getDocenciaImpartida() {
	return DocenciaImpartida;
}
public void setDocenciaImpartida(String docenciaImpartida) {
	DocenciaImpartida = docenciaImpartida;
}
public int getHorasAsignables() {
	return HorasAsignables;
}
public void setHorasAsignables(int horasAsignables) {
	HorasAsignables = horasAsignables;
}
/**
 * Comprueba si el numero de horas asignadas al docente son correctas
 * @return true si son correctas
 */
public boolean NumeroHorasIncorrecto(){
	if (Categoria=="titular" && (HorasAsignables>20 || HorasAsignables<0)){
		return true;}
	if (Categoria=="interino" && (HorasAsignables>15 || HorasAsignables<0)){
		return true;}
	return false;
}
/*public boolean ProfesorInexistente(int iD_Profesor){
	if (iD_Profesor instanceof Profesor){
	return false;
}*/
/**
 * Comprueba si el docente no es titular
 * @param categoria Categoria del docente
 * @return true si no es titular
 */
public boolean ProfesorNoTitular(String categoria){
	if(categoria != "titular")
		return true; return false;
}
@Override
public String toString() {
	String l=System.getProperty("line.separator");
	return l+"profesor"+l+super.getDNI() +super.toString() + l + Categoria + l
			+ Departamento + l + HorasAsignables 
			+ l + DocenciaImpartida+ l + "*" + l;
}

public int compareTo(Profesor value) {
	// TODO Auto-generated method stub
	return 0;
}

/*public void OrdenarProfesor(int HorasAsignables){
	
}*/

/*public void AsignarCargaDocente(Grupo Grupo){
	
}*/
}
