package org.uoc.pds.alpha.cultureindahouse.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import dto.AddOrUpdateEventOrganizer;

@Path("/administration")
@Produces(MediaType.APPLICATION_JSON)
public class AdministrationRestService {

    @EJB
    private AdministrationLocal administrationLocal;

    //CATEGORY

    @GET
    @Path("/category/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategory(@PathParam("id") int id) {
        return Response.ok(administrationLocal.showCategory(id)).build();
    }

    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllCategories() {
        return Response.ok(administrationLocal.listAllCategories()).build();
    }

    @POST
    @Path("/category")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCategory(CategoryVO category) {
        return Response.ok(administrationLocal.addCategory(category.getName(), category.getDescription())).build();
    }

    @PUT
    @Path("/category/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategory(@PathParam("id") int id, CategoryVO cat) {
        return Response.ok(administrationLocal.updateCategory(id, cat.getName(), cat.getDescription())).build();
    }

    @DELETE
    @Path("/category/{id}")
    public Response deleteCategory(
            @PathParam("id") int id) {
        administrationLocal.deleteCategory(id);
        return Response.ok().build();
    }


    //EVENT-ORGANIZER

    @GET
    @Path("/event-organizer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventOrganizer(@PathParam("id") int id) {
        return Response.ok(administrationLocal.showEventOrganizer(id)).build();
    }

    @GET
    @Path("/event-organizer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllEventOrganizer() {
        return Response.ok(administrationLocal.listAllEventOrganizers()).build();
    }

    @POST
    @Path("/event-organizer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEventOrganizer(AddOrUpdateEventOrganizer event) throws Exception {
        return Response.ok(administrationLocal.addEventOrganizer(event.getName(), event.getDescription(), event.getUserId())).build();
    }

    @PUT
    @Path("/event-organizer/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEventOrganizer(@PathParam("id") int id, AddOrUpdateEventOrganizer event) throws Exception {
        return Response.ok(administrationLocal.updateEventOrganizer(id, event.getName(), event.getDescription(), event.getUserId())).build();
    }

    @DELETE
    @Path("/event-organizer/{id}")
    public Response deleteEventOrganizer(@PathParam("id") int id) {
        administrationLocal.deleteEventOrganizer(id);
        return Response.ok().build();
    }

    //ADMINISTRATOR

    @GET
    @Path("/administrator/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdministrator(@PathParam("id") int id) {
        return Response.ok(administrationLocal.showAdministator(id)).build();
    }

    @GET
    @Path("/administrator")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllAdministrators() {
        return Response.ok(administrationLocal.listAllAdministrators()).build();
    }

    @POST
    @Path("/administrator")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAdministrator(UserVO user) {

        return Response.ok(administrationLocal.addAdministrator(user.getEmail(), user.getPassword(), user.getName(), user.getSurname())).build();
    }

    @PUT
    @Path("/administrator/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdministrator(@PathParam("id") int id, UserVO user) {

        return Response.ok(administrationLocal.updateAdministrator(id, user.getEmail(), user.getPassword(), user.getName(), user.getSurname())).build();
    }

    @DELETE
    @Path("/administrator/{id}")
    public Response deleteAdministrator(@PathParam("id") int id) {
        administrationLocal.deleteAdministrator(id);
        return Response.ok().build();
    }

    //LABEL

    @GET
    @Path("/label/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabel(@PathParam("id") int id) {
        return Response.ok(administrationLocal.showLabel(id)).build();
    }

    @GET
    @Path("/label")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllLabels() {
        return Response.ok(administrationLocal.listAllLabels()).build();
    }

    @POST
    @Path("/label")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLabel(LabelVO label) {
        return Response.ok(administrationLocal.addLabel(label.getName(), label.getDescription())).build();
    }

    @PUT
    @Path("/label/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLabel(@PathParam("id") int id, LabelVO label) {
        return Response.ok(administrationLocal.updateLabel(id, label.getName(), label.getDescription())).build();
    }

    @DELETE
    @Path("/label/{id}")
    public Response deleteLabel(@PathParam("id") int id) {
        administrationLocal.deleteLabel(id);
        return Response.ok().build();
    }


}
