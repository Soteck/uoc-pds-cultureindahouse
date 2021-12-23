package org.uoc.pds.alpha.cultureindahouse.api;

import dto.EventEmail;
import org.uoc.pds.alpha.cultureindahouse.ejb.bean.EventLocal;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
public class EventRestService {

    @EJB
    private EventLocal eventLocal;

    @GET
    @Path("/events")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllEvents() {
        return Response.ok(eventLocal.listAllEvents()).build();
    }

    @GET
    @Path("/events?categoryId={categoryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findEventsByCategory(@PathParam("categoryId") int categoryId) {
        return Response.ok(eventLocal.findEventsByCategory(categoryId)).build();
    }

    @GET
    @Path("/events?name={name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findEventsByName(@PathParam("name") String name) {
        return Response.ok(eventLocal.findEventsByName(name)).build();
    }

    @GET
    @Path("/events?labelId={labelId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findEventsByLabel(@PathParam("labelId") int labelId) {
        return Response.ok(eventLocal.findEventsByLabel(labelId)).build();
    }

    @GET
    @Path("/events/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showEvent(@PathParam("eventId") int eventId) {
        return Response.ok(eventLocal.showEvent(eventId)).build();
    }

    @GET
    @Path("/orders?email={email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findOrdersByUser(@PathParam("email") String email) {
        return Response.ok(eventLocal.findOrdersByUser(email)).build();
    }

    @GET
    @Path("/orders")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllOrders() {
        return Response.ok(eventLocal.findAllOrders()).build();
    }

    @GET
    @Path("/orders/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response showOrder(@PathParam("orderId") int orderId) {
        return Response.ok(eventLocal.showOrder(orderId)).build();
    }


    @PUT
    @Path("/order-event")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response orderEvent(EventEmail dto) {
        return Response.ok(eventLocal.orderEvent(dto.eventId, dto.email)).build();

    }

}
