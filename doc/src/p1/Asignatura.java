package p1;

public class Asignatura {
int ID_Asignatura,Curso;
String Nombre,Siglas,Coordinador, Prerrequisitos;
Grupo grupo;


public Asignatura(int iD_Asignatura,String nombre, String siglas,int curso, String coordinador, String prerrequisitos, Grupo grp){
	Nombre=nombre;
	Siglas=siglas;
	Coordinador=coordinador;
	Prerrequisitos=prerrequisitos;	
	ID_Asignatura= iD_Asignatura;
	grupo=grp;
	Curso=curso;
	}


public int getID_Asignatura() {
	return ID_Asignatura;
}
public void setID_Asignatura(int iD_Asignatura) {
	ID_Asignatura = iD_Asignatura;
}
public String getPrerrequisitos() {
	return Prerrequisitos;
}
public void setPrerrequisitos(String prerrequisitos) {
	Prerrequisitos = prerrequisitos;
}
public int getCurso(){
	return Curso;
}
public void setCurso(int curso){
	Curso=curso;
}
public String getNombre() {
	return Nombre;
}
public void setNombre(String nombre) {
	Nombre = nombre;
}
public String getSiglas() {
	return Siglas;
}
public void setSiglas(String siglas) {
	Siglas = siglas;
}
public String getCoordinador() {
	return Coordinador;
}
public void setCoordinador(String idcoord) {
	Coordinador = idcoord;
}
public String getGrupo(String a){
	if(a.trim().equals("A")){
	return grupo.getCalA();}
	else{return grupo.getCalB();}
	}
//public String getGrupoB(){
//	return grupo.getCalB();
//}
@Override
public String toString() {String l=System.getProperty("line.separator");
	return l+ID_Asignatura 
			 +l+  Nombre +l+ Siglas+l+Curso
			+ l+ Coordinador+ l+ Prerrequisitos+l+grupo.getCalA()+l+grupo.getCalB()+l+"*"+l;
}
/**
 * Retorna la duracion de una clase
 * @param tipo Tipo de grupo
 * @param a ID del grupo
 * @return Duracion de la clase
 */
public int getDuracion(String tipo,String a){
if(tipo.equals("A")){return grupo.getDurA(a);}
else return grupo.getDurB(a);
}


/**
 * Comprueba si existe un grupo dado para la asignatura
 * @param id ID del grupo
 * @param tipo Tipo de grupo
 * @return true si no existe
 */
public boolean getCal(String id,String tipo){
	
	if(tipo.equals("A")){
		
		String[] cal=grupo.getCalA().split("; ");
		for(int i=0; i<cal.length ; i++){
		String[] cal2=cal[i].split(" ");
		if(id.equals(cal2[0])){return false;
		}else {}
		
		}}else{ String[] cal=grupo.getCalB().split("; ");
		for(int i=0; i<cal.length ; i++){
			String[] cal2=cal[i].split(" ");
			
			if(id.equals(cal2[0])){;return false;
			}else {}
}}return true;}



/**
 * Retorna el dia y la hora de comienzo de clase del grupo dado
 * @param iD_Grupo ID del grupo
 * @param tipo Tipo de grupo
 * @return Dia y hora de comienzo de la clase
 */
public String getCalendarioGrupo(String iD_Grupo, String tipo){
	if(tipo.equals("A")){
		String[] cal=grupo.getCalA().split("; ");
		for(int i=0; i<cal.length-1 ; i++){
		String[] cal2=cal[i].split(" ");
		
		if(cal2[0].equals(iD_Grupo)){
			return cal2[1]+" "+cal2[2];
		}
	}
	}
	else {String[] cal=grupo.getCalB().split("; ");
	for(int i=0; i<cal.length-1 ; i++){
	String[] cal2=cal[i].split(" ");
	if(cal2[0].equals(iD_Grupo)){
		return cal2[1]+" "+cal2[2];}
		
}}return null;}

/**
 * Retorna el dia en el que se imparte la clase del grupo dado
 * @param iD_Grupo ID del grupo
 * @param tipo Tipo de grupo
 * @return Dia en el que se imparte la clase
 */
public String getDia(String iD_Grupo, String tipo){
	if(tipo.equals("A")){
		String[] cal=grupo.getCalA().split("; ");
		for(int i=0; i<cal.length-1 ; i++){
		String[] cal2=cal[i].split(" ");
		
		if(cal2[0].equals(iD_Grupo)){
			return cal2[1];
		}
	}
	}
	else {String[] cal=grupo.getCalB().split("; ");
	for(int i=0; i<cal.length-1 ; i++){
	String[] cal2=cal[i].split(" ");
	if(cal2[0].equals(iD_Grupo)){
		return cal2[1];}
		
}}return null;}
/*public boolean AsignaturaInexistente(int iD_Asignatura){
	
}*/

/*public boolean ProfesorDeDosMaterias(int iD_Profesor)
*/

}
