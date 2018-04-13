package p1;

public class Grupo {

private String CalA,CalB,Tipo;
private int DurA,DurB;


/**
 * Retorna la duracion de un grupo A dado
 * @param a ID del grupo
 * @return Duracion de la clase
 */
public int getDurA(String a) {
String[]	b=CalA.split("; ");
for(int k=0; k<b.length-1; k++ ){
    String[] c=b[k].split(" ");
    if(c[0].trim().equals(a)){
    	
    //	System.out.println(CalA);
    //	System.out.println(c[0]);
    //	System.out.println(c[1]);
   // 	System.out.println(c[2]);
    	
   int x=  Integer.parseInt(c[3].trim());
    int y= Integer.parseInt(c[2].trim());
     DurA= x-y;
  //   System.out.println(DurA);
   
    }
    }
return DurA;
	
	
	
}
//
//
//public void setDurP(int durP) {
//	DurP = durP;
//}
//
//
/**
 * Retorna la duracion de un grupo B dado
 * @param a ID del grupo
 * @return Duracion de la clase
 */
public int getDurB(String a) {
	String[]	b=CalA.split("; ");
	for(int k=0; k<b.length-1; k++ ){
	    String[] c=b[k].split(" ");
	    if(c[0].trim().equals(a)){
	   int x=  Integer.parseInt(c[3].trim());
	    int y= Integer.parseInt(c[2].trim());
	     DurB= x-y;
	   
	    }
	    }
	
	return DurB;
}
//
//
//public void setDurT(int durT) {
//	DurT = durT;
//}


public String getCalA() {
	return CalA;
}


public void setCalA(String calA) {
	CalA = calA;
}


public String getCalB() {
	return CalB;
}


public void setCalB(String calB) {
	CalB = calB;
}


public String getTipo() {
	return Tipo;
}


public void setTipo(String tipo) {
	Tipo = tipo;
}


public Grupo(String calA, String calB){
	
	CalA=calA;
	CalB=calB;
	
}


/**
 * Comprueba si el tipo de grupo no se corresponde a A o B
 * @param tipo Tipo de grupo
 * @return true si se corresponde
 */
public boolean tipoGrupoIncorrecto(String tipo){
	if(tipo!="A"||tipo!="B")
		return true;
	return false;
}
/*public boolean grupoInexistente(int iD_Grupo){
	
	return false;
}*/
/*public boolean grupoYaAsignado(int iD_Grupo, int iD_Profesor){
	
	return false;
}*/
}
