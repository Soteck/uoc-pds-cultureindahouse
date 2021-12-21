package org.uoc.pds.alpha.cultureindahouse.api;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

@Path("/category")
@Produces(MediaType.APPLICATION_JSON)
public class AdministrationRestService {

	@EJB
	private AdministrationLocal administrationLocal;

	@GET
	@Path("/{primaryKey}")
	public Response getCategory(
			@PathParam("primaryKey") int id) {
		return Response.ok(administrationLocal.showCategory(id)).build();
	}

	@GET
	@Path("/")
	public Response listAllCategories() {
		return Response.ok(administrationLocal.listAllCategories()).build();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response insertCategory(
			MultivaluedMap<String, String> formParams) {
		String name = formParams.getFirst("name");
		String description = formParams.getFirst("description");
		return Response.ok(administrationLocal.addCategory(name, description)).build();
	}

	@PUT
	@Path("/{primaryKey}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateCategory(
			MultivaluedMap<String, String> formParams,
			@PathParam("primaryKey") int id) {
		String name = formParams.getFirst("name");
		String description = formParams.getFirst("description");
		return Response.ok(administrationLocal.updateCategory(id, name, description)).build();
	}

	@DELETE
	@Path("/{primaryKey}")
	public Response deleteCategory(
			@PathParam("primaryKey") int id) {
		administrationLocal.deleteCategory(id);
		return Response.ok().build();
	}


}
