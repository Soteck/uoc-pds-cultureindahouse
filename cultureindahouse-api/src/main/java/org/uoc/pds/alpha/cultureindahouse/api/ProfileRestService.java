package org.uoc.pds.alpha.cultureindahouse.api;

import dto.AddOrUpdateEvent;
import dto.AddOrUpdateUser;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.ProfileLocal;
import org.uoc.pds.alpha.cultureindahouse.ejb.helpers.DateHelper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/profile")
@Produces(MediaType.APPLICATION_JSON)
public class ProfileRestService {

    @EJB
    private ProfileLocal profileLocal;

    @GET
    @Path("/login?email={email}&password={password}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@PathParam("email") String email, @PathParam("password") String password) {
        return Response.ok(profileLocal.login(email, password)).build();
    }

    @GET
    @Path("/events?name={name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showEvent(@PathParam("name") String name) {
        return Response.ok(profileLocal.showEventByName(name)).build();
    }

    @GET
    @Path("/users?email={email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showUser(@PathParam("email") String email) {
        return Response.ok(profileLocal.showUser(email)).build();
    }

    @PUT
    @Path("/events/{eventId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateEvent(@PathParam("eventId") int eventId, AddOrUpdateEvent dto) {
        return Response.ok(
                profileLocal.updateEvent(
                        eventId, dto.name, dto.description, dto.location, dto.image,
                        dto.initDate, dto.endDate, dto.eventOrganizerId, dto.categoryId)).build();
    }



    @PUT
    @Path("/events/{eventId}/label/{labelId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addLabelToEvent(@PathParam("eventId") int eventId, @PathParam("labelId") int labelId) {
        profileLocal.addLabelToEvent(eventId, labelId);
        return Response.ok().build();
    }


    @PUT
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(AddOrUpdateUser dto) {
        return Response.ok(profileLocal.updateUser(dto.nif, dto.email, dto.password, dto.name, dto.surname, dto.preferedLanguage, dto.address))
                .build();
    }


    @POST
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registerUser(AddOrUpdateUser dto) {
        return Response.ok(profileLocal.registerUser(dto.nif, dto.email, dto.password, dto.name, dto.surname, dto.preferedLanguage, dto.address))
                .build();
    }

    @POST
    @Path("/events")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEvent(AddOrUpdateEvent dto) {
        return Response
                .ok(
                        profileLocal.addEvent(dto.name, dto.description, dto.location, dto.image,
                                dto.initDate, dto.endDate, dto.eventOrganizerId, dto.categoryId))
                .build();
    }


    @DELETE
    @Path("/events/{eventId}/label/{labelId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response removeLabelFromEvent(@PathParam("eventId") int eventId, @PathParam("labelId") int labelId) {
        profileLocal.removeLabelFromEvent(eventId, labelId);
        return Response.ok().build();
    }

}
