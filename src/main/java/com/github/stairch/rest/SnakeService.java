package com.github.stairch.rest;

import com.github.stairch.dtos.*;
import com.github.stairch.types.HeadType;
import com.github.stairch.types.Move;
import com.github.stairch.types.TailType;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.SourceTree;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CopyOnWriteArrayList;

import static com.github.stairch.RestInPeace.BASE_URI;

@Path("/")
public class SnakeService {

    /**
     * Used for json serialization/deserialization.
     */
    private final Gson gson = new Gson();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "yeaay, your starter snake is up and running :)";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/start")
    public final Response start(final StartRequestDTO startRequestDTO) {
        System.out.println(startRequestDTO);

        final StartResponseDTO startResponse = new StartResponseDTO();
        startResponse.setColor("green");
        startResponse.setHeadUrl(BASE_URI + "static/head.png");
        startResponse.setName("PunkisSnake");
        startResponse.setTaunt("Meep meep");

        startResponse.setHeadType(HeadType.getPixel());
        startResponse.setTailType(TailType.getBlockbum());
        final String responseBody = gson.toJson(startResponse);
        return Response.status(Response.Status.OK).entity(responseBody).build();
    }

    @POST
  //  @Consumes(MediaType.APPLICATION_JSON)
  //  @Produces(MediaType.APPLICATION_JSON)
    @Path("/move")
    public final Response move(final String moveRequest) {
        MoveRequestDTO m = gson.fromJson(moveRequest, MoveRequestDTO.class);
        System.out.println("ToString"+ moveRequest.toString());

        final MoveResponseDTO moveResponse = new MoveResponseDTO();
        moveResponse.setMove(Move.left);

       // System.out.println(moveResponse.toString());

        final String responseBody = gson.toJson(moveResponse);



        return Response.status(Response.Status.OK).entity(responseBody).build();
    }
}