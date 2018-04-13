package p1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Avisos {	
	
	int Err=0;
	/**
	 * Compureba si una fecha es correcta y esta entre el año 1950 y 2020
	 * @param fecha Fecha a comprobar
	 * @return true si es correcta
	 */
	public  boolean fechaCorrecta(String fecha) throws ParseException {
		 String[] Fecha = fecha.split("/");
	int	   dia=Integer.parseInt(Fecha[0]);
	int	   mes=Integer.parseInt(Fecha[1]);
	int	   year=Integer.parseInt(Fecha[2]);
	
	
	
		 
	
		
		   
		
		
		   
		 String fecha1 = "01/01/1950";  
		 String fecha2 = "01/01/2020";  
		 
			   SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy"); 
			   Date fechaDate1 = formateador.parse(fecha1);
			   Date fechaDate2 = formateador.parse(fecha);
			   Date fechaDate3 = formateador.parse(fecha2);
			    
			    if ( fechaDate2.before(fechaDate1) )
			    { return  false;}
			    if(fechaDate3.before(fechaDate2))
			    {return false;}
			   
			GregorianCalendar calendarioTest = new GregorianCalendar();

		  if ((year < 0) || (year > 1000000) || (mes <0 ) || (mes > 11)
		    || (dia < 1) || (dia > 31))

		  {
		   return false;
		  }

		  if (((mes == 3) || (mes == 5) || (mes == 8) || (mes == 10))
		    && (dia > 30)) {
		   return false;
		  }

		  if (mes == 1) {
		   if (calendarioTest.isLeapYear(year)) {
		    if (dia > 29) {
		     return false;
		    }
		   }
		   if (dia > 28) {
		    return false;
		   }
		  }

		  return true;
		 }

	
	/**
	 * Comprueba si una nota es correcta
	 * @param nota Nota a comprobar
	 * @return true si es correcta
	 */
	public boolean NotaCorrecta(String nota) {
	
		if(nota.length()>4){ return false;}
		if (Double.parseDouble(nota) < 5 || Double.parseDouble(nota) > 10)
			return false;
		return true;
	}
	
	
	/**
	 * Comprueba si las horas asignadas a un docente son correctas
	 * @param categoria Categoria del docente
	 * @param horas Horas asignadas al docente
	 * @return true si son correctas
	 */
	public boolean HorasCorrectas(String categoria,String horas){
		if(Integer.parseInt(horas)<0) return false; 
		
	if(categoria.equals("titular")){
		if(Integer.parseInt(horas)>20)return false;}
	
	if(categoria.equals("asociado")){
		if(Integer.parseInt(horas)>15)return false;}
	
	return true;}
	
	
	
	
	
	public void Error(){
	Err+=1;
	}


	public int getErr() {
		return Err;
	}


	public void setErr(int err) {
		Err = err;
	}
	
	
	
	
	
	/**
	 * Comprubea si entre la fecha de nacimiento y la fecha de ingreso no hay mas de 65 años de diferencia o menos de 15
	 * @param fechaNac Fecha de nacimiento
	 * @param fechaIngreso Fecha de ingreso
	 * @return true si es correcto el rango de años
	 * @throws ParseException
	 */
	public boolean fechaIngresoCorrecta(String fechaNac, String fechaIngreso) throws ParseException {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy"); 
        Date fechaNac1 = formateador.parse(fechaNac);
        Date fechaIng2 = formateador.parse(fechaIngreso);
        //Date fechaDate3 = formateador.parse(fecha2);
         String[] feNac=fechaNac.split("/");
         String[] feIng=fechaIngreso.split("/");
         
        // System.out.println(fechaNac1);
       //  System.out.println(fechaIng2);
         
         int dia1 = Integer.parseInt(feNac[0]);
    int mes1 = Integer.parseInt(feNac[1]);
    int year1 = Integer.parseInt(feNac[2]);
    int dia2 = Integer.parseInt(feIng[0]);
    int mes2 = Integer.parseInt(feIng[1]);
    int year2 = Integer.parseInt(feIng[2]);

  if (fechaIng2.before(fechaNac1)){//System.out.println("FUNCIONA");
   return false;
  }
  else //Si fecha de nacimiento es menor que la fecha de ingreso
  {
   GregorianCalendar fecha3 = new GregorianCalendar(year2, mes2, dia2);//fecha3 es una copia de fecha de ingreso

   fecha3.add(GregorianCalendar.YEAR, -year1);
   fecha3.add(GregorianCalendar.MONTH, -mes1);
   fecha3.add(GregorianCalendar.DATE, -dia1);
   
       Date fecha=fecha3.getTime();
       //toLocaleString
        String fec=fecha.toLocaleString();
        //System.out.println(fec);
        String[] fe=fec.split("-");
        String[] f=fe[2].split(" ");
       // System.out.println(Integer.parseInt(f[0]));
        int finalyear=Integer.parseInt(f[0]);
       

   if(finalyear<15 ||finalyear>65){
   return false; 
   }
   
}
  return true;}

	public boolean GrupoCorrecto(String c){
		if((c.equals("A"))||(c.equals("B"))){ 
			return true;
		}return false;
	}
	
	
	
	
	
	
}