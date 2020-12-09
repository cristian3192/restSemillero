package com.clearminds.ccc.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
}
