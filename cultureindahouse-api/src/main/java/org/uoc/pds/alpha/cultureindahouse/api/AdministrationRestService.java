package org.uoc.pds.alpha.cultureindahouse.api;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.AdministrationLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.CategoryVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.LabelVO;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.UserVO;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/administration")
@Produces(MediaType.APPLICATION_JSON)
public class AdministrationRestService {

    @EJB
    private AdministrationLocal administrationLocal;

    //CATEGORY

    @GET
    @Path("/category/{primaryKey}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategory(@PathParam("primaryKey") int id) {
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
    @Path("/category/{primaryKey}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategory(@PathParam("primaryKey") int id, CategoryVO cat) {
        return Response.ok(administrationLocal.updateCategory(id, cat.getName(), cat.getDescription())).build();
    }

    @DELETE
    @Path("/category/{primaryKey}")
    public Response deleteCategory(
            @PathParam("primaryKey") int id) {
        administrationLocal.deleteCategory(id);
        return Response.ok().build();
    }


    //EVENT-ORGANIZER

    @GET
    @Path("/event-organizer/{primaryKey}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventOrganizer(@PathParam("primaryKey") int id) {
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
    public Response addEventOrganizer(EventOrganizerVO event) {
        return Response.ok(administrationLocal.addEventOrganizer(event.getName(), event.getDescription())).build();
    }

    @PUT
    @Path("/event-organizer/{primaryKey}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEventOrganizer(@PathParam("primaryKey") int id, EventOrganizerVO event) {
        return Response.ok(administrationLocal.updateEventOrganizer(id, event.getName(), event.getDescription())).build();
    }

    @DELETE
    @Path("/label/{primaryKey}")
    public Response deleteEventOrganizer(@PathParam("primaryKey") int id) {
        administrationLocal.deleteEventOrganizer(id);
        return Response.ok().build();
    }

    //ADMINISTRATOR

    @GET
    @Path("/administrator/{primaryKey}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAdministrator(@PathParam("primaryKey") int id) {
        return Response.ok(administrationLocal.showUser(id)).build();
    }

    @GET
    @Path("/administrator")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllAdministrators() {
        return Response.ok(administrationLocal.listAllUsers()).build();
    }

    @POST
    @Path("/administrator")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAdministrator(UserVO user) {

        return Response.ok(administrationLocal.addUser(user.getEmail(), user.getPassword(), user.getName(), user.getSurname())).build();
    }

    @PUT
    @Path("/administrator/{primaryKey}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAdministrator(@PathParam("primaryKey") int id, UserVO user) {

        return Response.ok(administrationLocal.updateUser(id, user.getEmail(), user.getPassword(), user.getName(), user.getSurname())).build();
    }

    @DELETE
    @Path("/label/{primaryKey}")
    public Response deleteAdministrator(@PathParam("primaryKey") int id) {
        administrationLocal.deleteUser(id);
        return Response.ok().build();
    }

    //LABEL

    @GET
    @Path("/label/{primaryKey}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLabel(@PathParam("primaryKey") int id) {
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
    @Path("/label/{primaryKey}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLabel(@PathParam("primaryKey") int id, LabelVO label) {
        return Response.ok(administrationLocal.updateLabel(id, label.getName(), label.getDescription())).build();
    }

    @DELETE
    @Path("/label/{primaryKey}")
    public Response deleteLabel(@PathParam("primaryKey") int id) {
        administrationLocal.deleteLabel(id);
        return Response.ok().build();
    }


}
