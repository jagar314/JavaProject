
/*
 * Javier Garcia Rodriguez
 * 
 * Luis Manuel Pena Canizares
 * 
 * pii-34
 * 
 * 
 * 
 */

package p1;
import java.text.ParseException;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;



public class Principal{
	
	 
	/**
	 * Realiza las operaciones que se indican en el fichero ejecucion.txt
	 */
	public static void main(String [ ] args) throws IOException, ParseException{
		LinkedHashMap<String,Profesor> prof = new LinkedHashMap<String,Profesor>();
		LinkedHashMap<String,Alumno> alum = new LinkedHashMap<String,Alumno>();
		LinkedHashMap<String,Asignatura> asig = new LinkedHashMap<String,Asignatura>();
		LinkedHashMap<String,Asignatura> asig2 = new LinkedHashMap<String,Asignatura>();
		LinkedHashMap<String,Persona> personas = new LinkedHashMap<String,Persona>();
		String n=System.getProperty("line.separator");//Variable que representa un salto de línea
		
		Scanner entrada = null;  
		Scanner entrada2 = null;  
		Scanner ejecucion = null;
		
		
		
		                   
	
			try  {  
			         entrada  =  new  Scanner  (new  FileInputStream("personas.txt"));
			     entrada2 = new Scanner (new FileInputStream("asignaturas.txt"));
			         ejecucion = new Scanner (new FileInputStream("ejecucion.txt"));
			        
			        
			         
			        
			         
}  
			catch(FileNotFoundException e)  {  
			System.out.println("Error  abriendo  el  fichero");  
			System.exit(-1);  
			}  
			
			
			
			ArrayList<String> c = new ArrayList<String>();
			ArrayList<String> t = new ArrayList<String>();
			
			
		while (entrada.hasNextLine()) {
			String campos = entrada.nextLine();
			c.add(campos);
		}
		int i = 0;
		int j = c.size();

			do{
			
			 if(c.get(i).trim().equals("alumno")){ 
				 
				 alum.put(c.get(i+1).trim(), new Alumno(c.get(i).trim(),c.get(i+1).trim(),c.get(i+2),c.get(i+3),c.get(i+4),c.get(i+5),c.get(i+6),c.get(i+7)));
				i+=9;  
				
//				System.out.println("funciona alumno");
//				System.out.println(alum.get("53456789M").getFechaDeIngreso());
			 }
			 else if(c.get(i).trim().equals("profesor")){
			   
		      
		       
		   prof.put(c.get(i+1).trim(), new Profesor(c.get(i).trim(),c.get(i+1).trim(),c.get(i+2),c.get(i+3),c.get(i+4),c.get(i+5),c.get(i+6),Integer.parseInt(c.get(i+7).trim()),c.get(i+8)));
		   i+=10;
//		   System.out.println("funciona profesor");
//		  System.out.println(prof.get("33218765A").getCategoria());
		   }
		//	 else if(){}
			 else{
				 System.out.println("Fichero personas incorrecto");
			 System.exit(0);}
			// i+=10;
			}while(i<j);
			
			entrada.close();  
			

			while (entrada2.hasNextLine()) {
				String  campos2 =entrada2.nextLine();
				t.add(campos2);
				}	 i=0;j=t.size();	
			
				
				do{
					
					Grupo grupo= new Grupo(t.get(i+6), t.get(i+7));

					 asig.put(t.get(i+2).trim(), new Asignatura(Integer.parseInt(t.get(i).trim()),t.get(i+1),t.get(i+2),Integer.parseInt(t.get(i+3).trim()),t.get(i+4),t.get(i+5),grupo));  
					 
					 asig2.put(t.get(i).trim(), new Asignatura(Integer.parseInt(t.get(i).trim()),t.get(i+1),t.get(i+2),Integer.parseInt(t.get(i+3).trim()),t.get(i+4),t.get(i+5),grupo));
		
		i+=9;
	}while(i<j);
			
				
				
			
			while (ejecucion.hasNextLine()) {
				Map<String,Profesor> proford = new TreeMap<String,Profesor>(prof);
			Map<String,Alumno> alumord = new TreeMap<String,Alumno>(alum);
				
					String  datos =ejecucion.nextLine();
					String[] coment = datos.split("");
					String[] div=datos.split("\\s+");
			//		System.out.println("coment "+datos);
				
					while(coment[0].charAt(0)=='*'){	try{datos =ejecucion.nextLine();
					 coment = datos.split("");
					 div=datos.split("\\s+");
					 }catch(Exception e){break;}
					}
					
					Avisos A=new Avisos();
					A.setErr(0);
					
					
				
					
					switch(div[0].toLowerCase()){
					
					//Comando inserta persona.
					
					case ("insertapersona") : {
						
					//	System.out.println(n+datos);
						
			
				String[] comillas=datos.split("\"");
				
				String[] fecha=comillas[4].split("\\s+");	
			
				
//				System.out.println(comillas[0]);
//				System.out.println(comillas[1]);
//				System.out.println(comillas[2]);
//				System.out.println(comillas[3]);
			//	System.out.println(comillas[4]);
//				System.out.println(fecha[1]);
				
				
				if(!comprobarDNI(div[2])){Errores("IP","DNI incorrecto");
				break;
				}
				if(prof.get(div[2])!=null){Errores("IP","Profesor ya existente");
					break;
				}
				if(alum.get(div[2])!=null){Errores("IP","Alumno ya existente");
					break;
				}
				
				
				
				int l=1;	
				 Set<String> s = new HashSet<String>();
				 s.addAll(proford.keySet());
				 s.addAll(alumord.keySet());
				
				
				 //Si añadimos un profesor
				 
				 

			//	  System.out.println(comillas.length);
				
				if(div[1].toLowerCase().equals("profesor")){
					
					if(comillas.length!=7){Errores("IP","Numero de argumentos incorrecto");break;}
					
					try{if(A.fechaCorrecta(fecha[1].trim())==false){
					Errores("IP","Fecha Incorrecta");  A.Error();
				}}
				catch(Exception e){Errores("IP","Fecha Incorrecta");  A.Error();}
					
					
	
					try{if(A.HorasCorrectas(fecha[2].trim(),comillas[6].trim())==false){
						Errores("IP","Numero de horas incorrecto");   A.Error();
					}}
					catch(Exception e){Errores("IP","Numero de horas incorrecto");   A.Error();}
if(A.getErr()>0) {break;}
					
					
					
while(s.contains(Integer.toString(l))){
						l++; 
					}
	
								
   // PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("personas.txt", true))) ;
  
  //  out.println(n+"*"+n+"profesor"+n+div[2]+n+comillas[1]+n+comillas[3]+n+fecha[1]+n+fecha[2]+n+comillas[5]+n+Integer.parseInt(comillas[6].trim()));

	 prof.put(div[2], new Profesor("profesor",div[2],comillas[1],comillas[3],fecha[1],fecha[2],comillas[5],Integer.parseInt(comillas[6].trim()),""));
	    PrintWriter salida2=  null;
		try  {  
			
			//Creación  de  fichero  nuevo  
			                   salida2  =  new  PrintWriter(new  FileOutputStream("personas.txt")); 
		    }  
		catch  (FileNotFoundException e)  {  
		System.out.println("Error  abriendo  el  fichero");  
		System.exit(-1);  
		}
		personas.putAll(alum);
		personas.putAll(prof);
		
		salida2.print(personas.values().toString().replace("[","").replace("*"+n+",", "*").replace("]","").trim());
		salida2.close();
		break ;
	
	
	//System.out.println(prof.get("53456789M").getCategoria());
}
				
				
				
				//Si añadimos un alumno	
				else {
					if(comillas.length!=5){Errores("IP","Numero de argumentos incorrecto");break;}
				//	System.out.println(fecha.length);
					if(fecha.length<=2){Errores("IP","Numero de argumentos incorrecto"); A.Error();
					//	System.out.println("argumentos incorrecto");
						break;
						
						}
	
					if(A.fechaCorrecta(fecha[1].trim())==false){
						Errores("IP","Fecha Incorrecta (fecha1)");   A.Error();
					//	System.out.println("fecha inc1");
						break;
					}
				
				//	System.out.println(fecha[2]);
				
					
					if(A.fechaCorrecta(fecha[2].trim())==false){
						Errores("IP","Fecha Incorrecta (fecha2)");   A.Error();
				//		System.out.println("fecha inc2");
						break;
					}
					
					
					if(A.fechaIngresoCorrecta(fecha[1].trim(), fecha[2].trim())==false){
						Errores("IP","Fecha de ingreso incorrecta"); A.Error();
				//		System.out.println("fecha ingreso inc");
						break;
					}
					
					
                    
if(A.getErr()>0) break;

					while(s.contains(Integer.toString(l))){
					l++; 
					}
					
						
//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("personas.txt", true))) ;
  //  out.println(n+"*"+n+"alumno"+n+div[2]+n+comillas[1]+n+comillas[3]+n+fecha[1]+n+fecha[2]+n+"");
    alum.put(div[2], new Alumno("alumno",div[2],comillas[1],comillas[3],fecha[1],fecha[2],"",""));
    
    PrintWriter salida2=  null;
	try  {  
		
		//Creación  de  fichero  nuevo  
		                   salida2  =  new  PrintWriter(new  FileOutputStream("personas.txt")); 
	    }  
	catch  (FileNotFoundException e)  {  
	System.out.println("Error  abriendo  el  fichero");  
	System.exit(-1);  
	}
	personas.putAll(alum);
	personas.putAll(prof);
	
	salida2.print(personas.values().toString().replace("[","").replace("*"+n+",", "*").replace("]","").trim());
	salida2.close();
	break ;
	

		
							 
}}
				
				//Comando asigna coordinador.

					case ("asignacoordinador"): {
						
					//	System.out.println(div.length);
						
						if(div.length!=3){Errores("ACOORD","Numero de argumentos incorrecto"); A.Error();
						//	System.out.println("argumentos incorrecto");
							break;
								
							}
						
					//	System.out.println(n+div[1]);
					//	System.out.println(div[2]);
						
						//try{System.out.println(prof.get(div[1]).getCategoria());}
						//catch(Exception e){}
					//System.out.println(asig.get(div[2].trim()));
					
						if(prof.get(div[1])==null){Errores("ACOORD","Profesor Inexistente"); A.Error();
						//System.out.println("profesor inexistente"); 
						break;
						}
						
						if(asig.get(div[2])==null){Errores("ACOORD","Asignatura Inexistente"); A.Error();
						//System.out.println("asignatura inexistente");
						}
						
						try{if(prof.get(div[1].trim()).getCategoria().trim().equals("titular")){
						 }else{Errores("ACOORD","Profesor no titular");   A.Error();
						 //System.out.println("profesor no titular");
						 }}
						
						catch(Exception e){Errores("ACOORD","Profesor no titular");   A.Error();}
						
						int r=0;
						
						Iterator<Entry<String,Asignatura>> it = asig.entrySet().iterator();
						while (it.hasNext()) { Entry<String,Asignatura> e = it.next();
						if((e.getValue().getCoordinador()).equals(div[1])){ r++;}
						
						}
				
						if(r>=2){Errores("ACOORD","Profesor ya es coordinador de dos materias"); A.Error();
						//System.out.println("profesor coordinador de 2");
						}
						
						
						if(A.getErr()>0) break;
						
						
							
						
						PrintWriter salida2=  null;
						try  {  
							 //Creación  de  fichero  nuevo  
							                   salida2  =  new  PrintWriter(new  FileOutputStream("asignaturas.txt")); 
						    }  
						catch  (FileNotFoundException e)  {  
						System.out.println("Error  abriendo  el  fichero");  
						System.exit(-1);  
						}
						Asignatura a =  asig.get(div[2]);
						a.setCoordinador(div[1]);
						String s=System.getProperty("line.separator");
						salida2.print(asig.values().toString().replace("[","").replace("*"+s+",", "*").replace("]","").trim());
						salida2.close();
						break ;
					}
					
					
					
					//Comando asigna carga docente.
					
					case ("asignacargadocente"): {
				//		System.out.println(n+datos);
						if(prof.get(div[1])==null){Errores("ACD","Profesor Inexistente"); A.Error();
						//System.out.println("profesor inexistente");
				//		break;
						}
						if(asig.get(div[2])==null){Errores("ACD","Asignatura Inexistente"); A.Error();
						//System.out.println("asignatura inexistente");
				//		break;
						}
						
						
						if(A.GrupoCorrecto(div[3].trim())==false){Errores("ACD","Tipo de grupo incorrecto"); A.Error();
			//			System.out.println("tipo de grupo incorrecto");
			//			break;
						}
						
					
					if(	asig.get(div[2]).getCal(div[4], div[3])==true)
					{Errores("ACD","Grupo Inexistente"); A.Error();
			//		System.out.println("grupo inexistente");
			//		break;
					}
						
							int r=0;
						if(div[3].trim().equals("A")) r=asig.get(div[2]).getDuracion("A",div[4].trim());
						if(div[3].trim().equals("B")) r=asig.get(div[2]).getDuracion("B",div[4].trim());
						
				try{		
						int w=0;
					String[] k=	prof.get(div[1]).getDocenciaImpartida().split("; ");
					
					for(int l=0;l<k.length;l++){
					String[] h=k[l].split("\\s+");
				//	System.out.println(h[1]);
					
					if(h[1].equals("A")){
					 w+=asig2.get(h[0]).getDuracion("A",h[2]);}
					if(h[1].equals("B")){
						w+=asig2.get(h[0]).getDuracion("B",h[2]);}
					}
					//	System.out.println(w);
						if(prof.get(div[1]).getHorasAsignables()<= w+r)
						{Errores("ACD","Horas asignables superior al máximo"); A.Error();
				//		System.out.println("Horas asignables superior al maximo");
			//			break;
						
						}
			//			if(A.getErr()>0) break;
						}
				catch(Exception e){
			//		System.out.println("catch");
					
					
				}
						
				try{		Iterator<Entry<String,Profesor>> itt = prof.entrySet().iterator();
						while (itt.hasNext()) { 
							Entry<String,Profesor> e = itt.next();
					//		System.out.println(prof.get("33218765A").getDocenciaImpartida());
							//System.out.println(prof.get("34567210G"));
					//		System.out.println(asig.get(div[2]).getID_Asignatura()+" "+div[3]+" "+div[4]);
							
					//	System.out.println(prof.containsValue("33218765A"));
					//	System.out.println(prof.get("33218765A"));
				
							//	System.out.println((e.getValue().getDocenciaImpartida()));
					//	System.out.println((e.getValue().getDocenciaImpartida()).contains(asig.get(div[2]).getID_Asignatura()+" "+div[3]+" "+div[4]));

						if((e.getValue().getDocenciaImpartida()).contains(asig.get(div[2]).getID_Asignatura()+" "+div[3]+" "+div[4])){ 
							Errores("ACD","Grupo ya asignado"); A.Error();
			//				System.out.println("grupo ya asignado");
							
					//		break;
							}
						}}
				catch(Exception e){}
				if(A.getErr()>0) break;

						
						
						
						
						
						
			//	System.out.println(prof.get(div[1]));		
				
			//	System.out.println(prof.get(div[1]).getDocenciaImpartida());	
			//	System.out.println("FUNCIONA MECAJONOMUNDO");		
					
				
				try{		String[] f=prof.get(div[1]).getDocenciaImpartida().split("; ");
				for(int m=0;m<f.length;m++){
				String[] q=f[m].split(" ");
				String[] gr=asig2.get(q[0]).getGrupo(q[1]).split("; ");
		//		System.out.println(asig2.get(q[0]).getGrupo(q[1]));
		//		System.out.println(gr);
					for(int w=0;w<gr.length;w++){
						String[] cl=gr[w].split(" ");
					//	System.out.println(gr[w]);
						if(asig.get(div[2]).getCalendarioGrupo(div[4],div[3]).contains(cl[1]+" "+cl[2])){
							
					//		System.out.println(asig.get(div[2]).getCalendarioGrupo(div[4],div[3])+"-------"+cl[1]+" "+cl[2]);
							Errores("ACD","Se genera solape"); A.Error();
						//	System.out.println("solape");
							break;
						}
						if(A.getErr()>0) break;
					}if(A.getErr()>0) break;
					
				}}
		catch(Exception e){}
				
				
				
						// System.out.println("DIV2 "+div[2]);
						if(A.getErr()>0) break;
						
			//			System.out.println("FUNCIONA MECAJONOMUNDO");
						
						PrintWriter salida2=  null;
						try  {  
							
							//Creación  de  fichero  nuevo  
							                   salida2  =  new  PrintWriter(new  FileOutputStream("personas.txt")); 
						    }  
						catch  (FileNotFoundException e)  {  
						System.out.println("Error  abriendo  el  fichero");  
						System.exit(-1);  
						}
						Profesor a = prof.get(div[1]);
						
		//			System.out.println(a.getDocenciaImpartida());	
					
						if(a.getDocenciaImpartida().equals("")||a.getDocenciaImpartida()==null){
							a.setDocenciaImpartida(asig.get(div[2].trim()).getID_Asignatura() + " " + div[3] + " " + div[4]);
							
						}else a.setDocenciaImpartida(a.getDocenciaImpartida() + "; " + asig.get(div[2].trim()).getID_Asignatura() + " " + div[3] + " " + div[4]);
					
						personas.putAll(alum);
						personas.putAll(prof);
						
						salida2.print(personas.values().toString().replace("[","").replace("*"+n+",", "*").replace("]","").trim());
						salida2.close();
						break ;
					}
					
					
					//Comando matricular alumno.
					
					case ("matricula"): {
				//		System.out.println(n+datos);
				//		System.out.println(alum.get("56534219N").getDocenciaRecibida());
						
						if(alum.get(div[1])==null){Errores("MAT","Alumno Inexistente"); A.Error();
				//		System.out.println("Alumno inexistente");
						break;
						}
						if(asig.get(div[2])==null){Errores("MAT","Asignatura Inexistente"); A.Error();
				//		System.out.println("asignatura inexistente");
						break;
						}
						
						 String doc=alum.get(div[1]).getDocenciaRecibida();
					      String[] docpartida=doc.split("; ");
					      for(int k=0; k<docpartida.length; k++ ){
					      String[] docpartida2=docpartida[k].split(" ");
				//	      System.out.println(docpartida2[0]);
					      if(docpartida2[0].trim().equals(Integer.toString(asig.get(div[2].trim()).getID_Asignatura()))){
					       Errores("MAT","Ya es alumno de la asignatura indicada");   A.Error(); 
				//	       System.out.println("ya es alumno");
					     break;
					      }
					      }
					      if(A.getErr()>0) break;
					      		      
					      if(!(alum.get(div[1]).getAsignaturasSuperadas()).contains(asig.get(div[2]).getPrerrequisitos())){ 
					          Errores("MAT","No cumple requisitos");   A.Error(); 
					//          System.out.println("no cumple requisitos");
					         }
					                if(A.getErr()>0) break;
					      
						
						PrintWriter salida2=  null;
						try  {  
							 //Creación  de  fichero  nuevo  
							                   salida2  =  new  PrintWriter(new  FileOutputStream("personas.txt")); 
						    }  
						catch  (FileNotFoundException e)  {  
						System.out.println("Error  abriendo  el  fichero");  
						System.exit(-1);  
						}
						
						
					//Alumno a = alum.get(div[1]);
					//String b=asig.getID_Asignatura(div[2]);
					alum.get(div[1]).setAsigEnCurso(Integer.toString(asig.get(div[2]).getID_Asignatura()));
				
				//	System.out.println(alum.get(div[1]).getDocenciaRecibida());
					
					personas.putAll(alum);
					personas.putAll(prof);
					
					salida2.print(personas.values().toString().replace("[","").replace("*"+n+",", "*").replace("]","").trim());
					salida2.close();
					break ;
					}
					
					//Comando asignar grupo.
					case("asignagrupo"):{
						
				//		System.out.println(n+datos);
						
						if(div.length!=5){Errores("AGRUPO","Numero de argumentos incorrecto"); A.Error();
				//		System.out.println("argumentos incorrecto");
						break;
							
						}
						
						if(alum.get(div[1])==null){Errores("AGRUPO","Alumno Inexistente"); A.Error();
				//		System.out.println("alumno inexistente");
						break;
						}
						
						if(asig.get(div[2])==null){Errores("AGRUPO","Asignatura Inexistente"); A.Error();
			//			System.out.println("asignatura inexistente");
						break;
						}
						
						if(alum.get(div[1]).getAsigEnCurso().contains(Integer.toString(asig.get(div[2]).getID_Asignatura()))){}else{
							Errores("AGRUPO","Alumno no matriculado"); A.Error();
			//				System.out.println("Alumno no matriculado");	
							break;
						}
						
						if(A.GrupoCorrecto(div[3].trim())==false){Errores("AGRUPO","Tipo de grupo incorrecto"); A.Error();
			//			System.out.println("tipo de grupo incorrecto");
						break;
						}
						
						if(	asig.get(div[2]).getCal(div[4], div[3])==true)
						{Errores("AGRUPO","Grupo Inexistente"); A.Error();
			//			System.out.println("Grupo inexistente");
						break;
						}
						if(alum.get(div[1]).getDocenciaRecibida().contains(asig.get(div[2]).getID_Asignatura()+" "+div[3])){
							
							if(div[3].trim().equals("A")){Errores("AGRUPO","Alumno ya tiene un grupo A asignado para esta asignatura"); A.Error();
						//	System.out.println("mas de A");
							break;
							}
							else{Errores("AGRUPO","Alumno ya tiene un grupo B asignado para esta asignatura"); A.Error(); 
						//	System.out.println("mas de B");
							break;}
							
					}
						if(A.getErr()>0) break;
					//	System.out.println(alum.get(div[1]).getDocenciaRecibida());
						
				try{		String[] f=alum.get(div[1]).getDocenciaRecibida().split("; ");
						for(int m=0;m<f.length;m++){
						String[] q=f[m].split(" ");
						String[] gr=asig2.get(q[0]).getGrupo(q[1]).split("; ");
				//		System.out.println(asig2.get(q[0]).getGrupo(q[1]));
				//		System.out.println(gr);
							for(int w=0;w<gr.length;w++){
								String[] cl=gr[w].split(" ");
							//	System.out.println(gr[w]);
								if(asig.get(div[2]).getCalendarioGrupo(div[4],div[3]).contains(cl[1]+" "+cl[2])){
									
							//		System.out.println(asig.get(div[2]).getCalendarioGrupo(div[4],div[3])+"-------"+cl[1]+" "+cl[2]);
									Errores("AGRUPO","Se genera solape"); A.Error();
							//		System.out.println("solape");
									break;
								}
								if(A.getErr()>0) break;
							}if(A.getErr()>0) break;
							
						}}
				catch(Exception e){}
						
						
						
						
						if(alum.get(div[1]).getDocenciaRecibida().contains(asig.get(div[2]).getID_Asignatura()+" "+div[3]+" "+div[4])){
							
			//				System.out.println(alum.get(div[1]).getDocenciaRecibida()+"-----"+asig.get(div[2]).getID_Asignatura()+" "+div[3]+" "+div[4]);
				//			System.out.println("repetido");
							A.Error();
						}
						if(A.getErr()>0) break;
						
						PrintWriter salida2=  null;
						try  {  
							 //Creación  de  fichero  nuevo  
							                   salida2  =  new  PrintWriter(new  FileOutputStream("personas.txt")); 
						    }  
						catch  (FileNotFoundException e)  {  
						System.out.println("Error  abriendo  el  fichero");  
						System.exit(-1);  
						}
						
						
					//	Alumno a = alum.get(div[1]);
					//	if(alum.get(div[1]).getAsigEnCurso().indexOf(asig.get(div[2]).getID_Asignatura())!=-1){
							alum.get(div[1]).setDocenciaRecibida(Integer.toString(asig.get(div[2]).getID_Asignatura()),asig.get(div[2]).getID_Asignatura()+" "+div[3]+" "+div[4]);
					//		System.out.println("FUNCIONA");
					//	}
						
						
						personas.putAll(alum);
						personas.putAll(prof);
						
						salida2.print(personas.values().toString().replace("[","").replace("*"+n+",", "*").replace("]","").trim());
						salida2.close();
						break ;
					}
					
					//Comando evaluar asignatura.
					
					case ("evalua"): {
						
				//		System.out.println(n+datos);
						
						
					
						if(div.length!=4){Errores("EVALUA","Numero de argumentos incorrecto"); A.Error();
				//		System.out.println("argumentos incorrecto");
						break;
							
						}
			//			System.out.println(div[3]);
						
						if(asig.get(div[1])==null){Errores("EVALUA","Asignatura Inexistente"); A.Error();
			//			System.out.println("asignatura inex");
						break;
						}
						
						if (!(new File(div[3]+".txt").exists()||new File(div[3]).exists())){Errores("EVALUA","Fichero de notas inexistente"); A.Error();
				//		System.out.println("fichero inex");
						}
						if(A.getErr()>0) break;
						
					
						try{		Iterator<Entry<String,Alumno>> itt = alum.entrySet().iterator();
						while (itt.hasNext()) { 
							Entry<String,Alumno> e = itt.next();
					
						if((e.getValue().getAsignaturasSuperadas()).contains(asig.get(div[1]).getID_Asignatura()+" "+div[2])){ 
							Errores("EVALUA","Asignatura ya evaluada en ese curso academico"); A.Error();
					//		System.out.println("asig ya evaluada");
							
							break;
							}
						}}
				catch(Exception e){}
				if(A.getErr()>0) break;
						 
						 
						 
						PrintWriter salida2=  null;
						try  {  
							 //Creación  de  fichero  nuevo  
							                   salida2  =  new  PrintWriter(new  FileOutputStream("personas.txt")); 
						    }  
						catch  (FileNotFoundException e)  {  
						System.out.println("Error  abriendo  el  fichero");  
						System.exit(-1);  
						}
						
						
						 Scanner aux = null;
					      aux = new Scanner (new FileInputStream(div[3])); int linea=0;
			//		     int g=0;
							  while (aux.hasNextLine()) {linea++; String o=("    Error en linea: "+linea);
							  
							  String notas =aux.nextLine();
						       String [] nota = notas.split("\\s+");
							      
//System.out.println(n+notas);

							 
							 
							 
							 
							       if(alum.get(nota[0])==null){Errores("EVALUA","Alumno Inexistente: "+nota[0]+o); A.Error();
					//		       System.out.println("alumno inex "+nota[0]+o);
							       continue;
							       }
							      
							     
							      try{ 		       if(alum.get(nota[0]).getDocenciaRecibida().contains(Integer.toString(asig.get(div[1]).getID_Asignatura()))){}else{
										Errores("EVALUA","Alumno no matriculado: "+nota[0]+o); A.Error();
									//	System.out.println("alumno no matriculado "+nota[0]+o);	
									//	System.out.println("if");
										continue;
							       }}
							       catch(NullPointerException e){
							    	   //System.out.println("catch");
							       
							       }
							       
							       if(Float.parseFloat(nota[1])<0 || Float.parseFloat(nota[1])>5 || Float.parseFloat(nota[2])<0 || Float.parseFloat(nota[2])>5)
							       {Errores("EVALUA","Nota grupo A/B incorrecta"+o); A.Error();
							    //   System.out.println("nota ab incorrecta "+nota[0]+o);
							       continue;
							       }
							       
					//		       if(A.getErr()>0){ A.setErr(0);g++;continue;}
						//	    System.out.println("TOD OK");
							    
							   
							       Alumno a = alum.get(nota[0]); 
							//       System.out.println(a);
							       float not=Float.parseFloat(nota[1])+Float.parseFloat(nota[2]);
							       //Double.parseDouble() sirve para pasar de String a double
							       if(not>=5){
							           
							          // a.setNotaDeExpediente(Double.parseDouble(nota[1]));
							    	   
							           a.setAsignaturasSuperadas(Integer.toString(asig.get(div[1]).getID_Asignatura())+" "+div[2]+" "+not);
							//          System.out.println(a.getAsignaturasSuperadas());
							           EliminarAlumno(a,asig.get(div[1]).getID_Asignatura());
							       }else EliminarAlumno(a,asig.get(div[1]).getID_Asignatura());
						  }
							  
							  //A.setErr(g);if(A.getErr()>0) break; 
							  aux.close();
						  
						 
						  personas.putAll(alum);
							personas.putAll(prof);
							
							salida2.print(personas.values().toString().replace("[","").replace("*"+n+",", "*").replace("]","").trim());
							salida2.close();
							
							
						  break ;
					}
					
					//Comando Expediente
					
					
					case("expediente"):{
					//	System.out.println(n+datos);
						
						if(alum.get(div[1])==null){Errores("EXP","Alumno Inexistente"); A.Error();
					//		System.out.println("alumno inexistente");
							break;
							}
			//		System.out.println("aaaaaaaa "+alum.get(div[1]).getAsignaturasSuperadas());
						
						if(alum.get(div[1]).getAsignaturasSuperadas()==null||alum.get(div[1]).getAsignaturasSuperadas().equals("")){Errores("EXP","Expediente Vacio"); A.Error();
					//		System.out.println("expediente vacio");
							break;
							}
						
						PrintWriter salida=  null;
						try  {  
						 //Creación  de  fichero  nuevo  
						                   salida  =  new  PrintWriter(new  FileOutputStream(div[2])); 
					    }  
					catch  (FileNotFoundException e)  {  
					System.out.println("Error  abriendo  el  fichero");  
					System.exit(-1);  
					}
						float p=0;
						Alumno a=alum.get(div[1]);
					
						
				//		a.odenarAsignaturasSuperadas();
						salida.println("curso; nombreAsignatura; nota; cursoAcademico"+n);
						String[] docencia=a.getAsignaturasSuperadas().split("; ");
						
			//			System.out.println(Arrays.toString(docencia));
					
//System.out.print(Arrays.sort(docencia,0,2));
			//			Arrays.sort(docencia,0,2);
			//			System.out.println(n+Arrays.toString(docencia));
						
		//				System.out.println(docencia[0]);
	//			System.out.println(docencia[0].startsWith("8"));
				
//				for(int w=0; w<100;w++){
//					for(int q=0; q<docencia.length;q++){
//					int r=0;
//						if(docencia[q].startsWith(Integer.toString(w))){
//							String[] docen=null;
//							docen[r]=docencia[q];
//							
//							System.out.println(docen[r]);
//							r+=1;
//						}
//				
//					
//					
//				}}
				
				
						for(int k=0; k<docencia.length; k++){
					//		String o="49";
		
							String[] docencia2=docencia[k].split(" ");
				
		//				if(docencia[0].equals(o)){
							Asignatura b =  asig2.get(docencia2[0]);
				
						p+=Float.parseFloat(docencia2[2].trim());
			
					salida.println(b.getCurso()+"; "+b.getSiglas().trim()+"; "+docencia2[2]+"; "+docencia2[1]);
	//				o+=1;
	//					}
						
					
					                              
						}
						salida.println(n+"Nota Media:"+ p/(docencia.length));
					salida.close();
					break;
					}	
					                             
					
					
					
					//Comando obtener calendario.
					
					case ("obtenercalendarioclases"):{
						
					//	System.out.println(n+datos);
						
						if(div.length!=3){Errores("OCALEN","Numero de argumentos incorrecto"); A.Error();
						//	System.out.println("argumentos incorrecto");
							break;
								
							}
					
						if(prof.get(div[1])==null){Errores("OCALEN","Profesor Inexistente"); A.Error();
					//	System.out.println("prof inex");
						}
						if(A.getErr()>0) break;
						
						Profesor a = prof.get(div[1]);
					//	System.out.println(a);
						
						if(a.getDocenciaImpartida().equals("")||a.getDocenciaImpartida()==null){Errores("OCALEN","Profesor sin asignaciones"); A.Error();}
						if(A.getErr()>0){ break;}
						
						PrintWriter salida=  null;
						try  {  
						 //Creación  de  fichero  nuevo  
						                   salida  =  new  PrintWriter(new  FileOutputStream(div[2])); 
					    }  
					catch  (FileNotFoundException e)  {  
					System.out.println("Error  abriendo  el  fichero");  
					System.exit(-1);  
					}
						
						salida.println("Dia; Hora; Asignatura; Tipo grupo; Id grupo"+n);
						
						String[] docencia=a.getDocenciaImpartida().split("; ");
				//		System.out.println(a.getDocenciaImpartida());
				//		String[] docencia3=docencia[0].split(" ");
				//		String s=docencia3[0];
					//	System.out.println();
			//			int[] s=(asig2.get(docencia3).getDia(docencia3[2], docencia3[1]));
			//			Arrays.sort(docencia);
						
						for(int k=0; k<docencia.length; k++){
						String[] docencia2=docencia[k].split(" ");
						
					if(docencia2.length>1){
						Asignatura b =  asig2.get(docencia2[0]);
					
				String dh=			b.getCalendarioGrupo(docencia2[2], docencia2[1]);
			
						
					salida.println(dh+"; "+b.getSiglas().trim()+"; "+docencia2[1]+"; "+docencia2[2]);
						
						}	
							}
						salida.close();
						break ;
						}
						
					
					default: Errores("","Comando Incorrecto"); 
					//System.out.println("comando incorrecto");
					break;
//					
					}
			
			
			} 
			
			Errores("","");
			
			
			
			
			}
			

			/**
			 * Elimina una asignatura de la docencia recibida de un alumno
			 * @param x Alumno
			 * @param iD_Asignatura Asignatura a eliminar
			 */
			public static void EliminarAlumno(Alumno x , int iD_Asignatura){
		 String[] descc=x.getAsigEnCurso().split(" "); 
		 for(int i=0;i<descc.length-1;i++){
			 if(Integer.parseInt(descc[i])==iD_Asignatura){
				 x.setAsigEnCursoBis(x.getAsigEnCurso().replace(descc[0], "").trim());}}

		 String[] descd=x.getDocenciaRecibida().split("; ");
		 for(int j=0;j<descd.length;j++){
			String[] descd2=descd[j].split(" ");			
			if(Integer.parseInt(descd2[0])==iD_Asignatura){
				x.setDocenciaRecibida2(x.getDocenciaRecibida().replace(descd[j]+"; ", "").replace(descd[j], ""));
			}
		 }
	

			 
	
	}

			
/**
 * Modifica el fichero avisos.txt
 * @param w Tipo de aviso
 * @param sigla Sigla del comando que dio el aviso
 */
public static void Errores(String w,String sigla) throws FileNotFoundException{
	
			if (new File("avisos.txt").exists()){
				
		
				try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("avisos.txt", true)))) {
				    out.println(sigla+" -- "+w);
				}catch (IOException e) {
				    
				}
			
				
			}else{
			
			try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("avisos.txt", true)))) {
			    out.println(sigla+" -- "+w);
			}catch (IOException e) {
			  
			}
				
				
		    }
		
				
			
			
				
			}
			
/**
 * Comprueba si un DNI es valido
 * @param dniAComprobar DNI que se quiere comprobar	
 * @return true si es correcto
 */
public static boolean comprobarDNI(String dniAComprobar){
	
  // compruebo su longitud que sea 9
    if (dniAComprobar.length() != 9){   
         return false;
    }  
    
    

    // compruebo que el 9º digito es una letra
    if (!Character.isLetter(dniAComprobar.charAt(8))) {
         return false;  
    }

    

    // Compruebo que lo 8 primeros digitos sean numeros
    for (int i=0; i<8; i++) {

         if(!Character.isDigit(dniAComprobar.charAt(i))){
               return false;    
         }
           
    }return true;}	
			
				
		
		
}