package org.uoc.pds.alpha.cultureindahouse.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.uoc.pds.alpha.cultureindahouse.ejb.bean.MediaLocal;

import dto.AnswerQuestion;
import dto.AskQuestion;
import dto.EventEmail;
import dto.EventUser;
import dto.SendCommentEmail;
import dto.SendCommentUser;
import dto.SendRatingEmail;
import dto.SendRatingUser;

@Path("/media")
@Produces(MediaType.APPLICATION_JSON)
public class MediaRestService {

    @EJB
    private MediaLocal mediaLocal;


    @GET
    @Path("/events/favorites")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllFavorites(){
        return Response.ok(mediaLocal.listAllFavorites()).build();
    }

    @GET
    @Path("/events/favorites/email/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllFavorites(@PathParam("email") String email){
        return Response.ok(mediaLocal.listAllFavorites(email)).build();
    }

    @GET
    @Path("/events/favorites/userId/{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllFavorites(@PathParam("userId")int userId){
        return Response.ok(mediaLocal.listAllFavorites(userId)).build();
    }

    @GET
    @Path("/questions/{questionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuestion(@PathParam("questionId")int questionId){
        return Response.ok(mediaLocal.getQuestion(questionId)).build();
    }

    @GET
    @Path("/responses/{questionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse(@PathParam("questionId")int questionId){
        return Response.ok(mediaLocal.getResponse(questionId)).build();
    }

    @GET
    @Path("/questions/eventId/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAllQuestions(@PathParam("eventId")int eventId){
        return Response.ok(mediaLocal.listAllQuestions(eventId)).build();
    }

    @PUT
    @Path("/events/favorites/by-email")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToFavorites(EventEmail dto){
        return Response.ok(mediaLocal.addToFavorites(dto.eventId, dto.email)).build();
    }

    @PUT
    @Path("/events/favorites/by-user-id")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addToFavorites(EventUser dto){
        return Response.ok(mediaLocal.addToFavorites(dto.eventId,dto.userId)).build();
    }


    @POST
    @Path("/comments/by-email")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendComment(SendCommentEmail dto){
        return Response.ok(mediaLocal.sendComment(dto.eventId,dto.email,dto.text)).build();
    }

    @POST
    @Path("/comments/by-user-id")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendComment(SendCommentUser dto){
        return Response.ok(mediaLocal.sendComment(dto.eventId, dto.userId, dto.text)).build();
    }

    @POST
    @Path("/ratings/by-email")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRating(SendRatingEmail dto){
        return Response.ok(mediaLocal.addRating(dto.eventId,dto.email,dto.rating)).build();
    }
    @POST
    @Path("/ratings/by-user-id")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addRating(SendRatingUser dto){
        return Response.ok(mediaLocal.addRating(dto.eventId, dto.userId, dto.rating)).build();
    }


    @POST
    @Path("/questions/answer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response answerQuestion(AnswerQuestion dto){
        return Response.ok(mediaLocal.answerQuestion(dto.questionId, dto.message)).build();
    }

    @POST
    @Path("/questions/ask")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response askQuestion(AskQuestion dto){
        return Response.ok(mediaLocal.askQuestion(dto.eventId, dto.title, dto.message)).build();
    }
    
}
