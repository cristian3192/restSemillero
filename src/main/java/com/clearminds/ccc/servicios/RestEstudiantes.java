package com.clearminds.ccc.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.clearminds.ccc.dtos.Estudiante;
import com.clearminds.ccc.excepciones.BDDException;



@Path("/estudiantes")
public class RestEstudiantes {

	@Path("/insertar")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	public void insertar (Estudiante estudiante) {
		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		try {
			srvEstudiante.insertarEstudiante(estudiante);
		} catch (BDDException e) {
			e.printStackTrace();
		}
	}
	
	@Path("/actualizar")
	@PUT
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Estudiante actualizar(Estudiante estudiante){
		ServicioEstudiante srvEstudiante = new ServicioEstudiante();
		try {
			if (estudiante != null ) {
				srvEstudiante.actualizarEstudiante(estudiante);
				System.out.println("Estudiante Modificado: "+estudiante);	
			}
			System.out.println("LLega persona en null");

					
		} catch (Exception e) {
			e.printStackTrace();
			return new Estudiante();
		}
		
		return estudiante;
	}
	
}
