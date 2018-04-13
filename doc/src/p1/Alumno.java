package p1;

public class Alumno extends Persona {
	private String FechaDeIngreso, DocenciaRecibida, AsignaturasSuperadas,
			AsigEnCurso = null;

	public Alumno(String tipo,String dni, String nombre, String apellidos,
			String fechaDeNacimiento, String fechaDeIngreso,
			String asignaturasSuperadas,
			String docenciaRecibida) {
		super(tipo,dni, nombre, apellidos, fechaDeNacimiento);
		FechaDeIngreso = fechaDeIngreso;
		AsignaturasSuperadas = asignaturasSuperadas;
		
		DocenciaRecibida = docenciaRecibida;

		// System.out.println(DocenciaRecibida);
		if (!DocenciaRecibida.equals("")) {

			String[] desc = DocenciaRecibida.split("; ");
			int i = 0;
			do {
				String[] serie1 = desc[i].split("\\s+");
				if (AsigEnCurso==null)
					AsigEnCurso = serie1[0];
				else
					AsigEnCurso = AsigEnCurso + " " + serie1[0];
				i++;
			} while (i < desc.length);
		}
	}

	public String getAsigEnCurso() {
		return AsigEnCurso;
	}

	public void setAsigEnCurso(String iD_Asignatura) {
	//	System.out.println(DocenciaRecibida);
	///	System.out.println(AsigEnCurso);
		if (AsigEnCurso==null) {
			AsigEnCurso = iD_Asignatura;
			DocenciaRecibida = iD_Asignatura;
		//	System.out.println(AsigEnCurso);
		} else {
			//System.out.println("GAS");
			if (AsigEnCurso.contains(iD_Asignatura)) {
				
				
			} else {AsigEnCurso = AsigEnCurso + " " + iD_Asignatura;
			DocenciaRecibida = DocenciaRecibida + ";" + " " + iD_Asignatura;
			}
		}
	}

	public void setAsigEnCursoBis(String asigEnCurso) {
		AsigEnCurso = asigEnCurso;
	}

	public String getFechaDeIngreso() {
		return FechaDeIngreso;
	}

	public void setFechaDeIngreso(String fechaDeIngreso) {
		FechaDeIngreso = fechaDeIngreso;
	}

	public String getDocenciaRecibida() {
		return DocenciaRecibida;
	}

	public void setDocenciaRecibida(String id,String docenciaRecibida) {
		
		
			String[] cal=DocenciaRecibida.trim().split("; ");
		//	System.out.println(DocenciaRecibida.trim());
			for(int i=0; i<cal.length ; i++){
			//	System.out.println(cal[i]);
			//	System.out.println(id);
			//	System.out.println(cal[0].equals(id));
		if(cal[i].equals(id)){
			
			DocenciaRecibida=	DocenciaRecibida.replace(id+"; ", "");
		//	System.out.println("ENTRA IFFFFFFFF");
		}
	//	else{System.out.println("no entra if");}
		}
		
		DocenciaRecibida = DocenciaRecibida + "; " + docenciaRecibida;
	}

	public void setDocenciaRecibida2(String docenciaRecibida) {
		DocenciaRecibida = docenciaRecibida;
	}

	public String getAsignaturasSuperadas() {
		return AsignaturasSuperadas;
	}

	public void setAsignaturasSuperadas(String asignatura) {
//System.out.println(AsignaturasSuperadas);
String a= AsignaturasSuperadas.trim();
		if (a.equals("")||a==null)
			AsignaturasSuperadas = asignatura;
		else
			a = AsignaturasSuperadas + "; " + asignatura;
	}



	@Override
	public String toString() {
		String l = System.getProperty("line.separator");
		return l+"alumno"+l+super.getDNI() + super.toString() + l
				+ FechaDeIngreso + l + AsignaturasSuperadas + l
			+ DocenciaRecibida + l + "*" + l;
	}
	
//	public void odenarAsignaturasSuperadas(){
//		String[] docencia=AsignaturasSuperadas.split("; ");
//		
//		AsignaturasSuperadas="";
//		for(int k=0; k<docencia.length; k++){
//			String[] docencia2=docencia[k].split(" ");
//			if(docencia2[0].equals("1")){
//				AsignaturasSuperadas=AsignaturasSuperadas+docencia[k]+"; ";}
//				else{if(docencia2[0].equals("2")){
//					AsignaturasSuperadas=AsignaturasSuperadas+docencia[k]+"; ";}
//					else{if(docencia2[0].equals("3")){
//						AsignaturasSuperadas=AsignaturasSuperadas+docencia[k]+"; ";}
//						else{if(docencia2[0].equals("4")){
//							AsignaturasSuperadas=AsignaturasSuperadas+docencia[k]+"; ";}
//				
//					
//				}
//				}
//				
//			}
//	}
//	//	System.out.println(AsignaturasSuperadas);
//		//AsignaturasSuperadas=AsignaturasSuperadas.substring(0, AsignaturasSuperadas.length-2);
//	}

}
