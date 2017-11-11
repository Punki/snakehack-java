package com.github.stairch.rest;

import com.github.stairch.dtos.*;
import com.github.stairch.types.HeadType;
import com.github.stairch.types.Move;
import com.github.stairch.types.TailType;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

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
        MoveRequestDTO moveRequestDTO = gson.fromJson(moveRequest, MoveRequestDTO.class);
        System.out.println(moveRequestDTO.getFoodAsPoints());

        List<PointDTO> foodList = moveRequestDTO.getFoodAsPoints();
        foodList.get(0).getX();
        foodList.get(0).getY();


        List<SnakeDTO> snakeList = moveRequestDTO.getSnakes();

        PointDTO head = new PointDTO();
        for (int i = 0; i < snakeList.size(); i++) {
            System.out.println("ID-i:"+snakeList.get(i).getId());
            System.out.println("My-ID-i:"+moveRequestDTO.getYou());
            if (snakeList.get(i).getId().equals(moveRequestDTO.getYou())) {
                int tmp = snakeList.get(i).getCoordsAsPoints().get(0).getX();
                head.setX(tmp);
                tmp = snakeList.get(i).getCoordsAsPoints().get(0).getY();
                head.setY(tmp);
            }
        }

        System.out.println("FoodX: " + foodList.get(0).getX());
        System.out.println("FoodY: " + foodList.get(0).getY());
        System.out.println("HeadX: " + head.getX());
        System.out.println("HeadY: " + head.getY());


        //System.out.println("ToString" + moveRequest.toString());

        final MoveResponseDTO moveResponse = new MoveResponseDTO();
        //moveResponse.setMove(Move.left);

        if (head.getY() == foodList.get(0).getY()) {
            if (head.getX() > foodList.get(0).getX()) {
                moveResponse.setMove(Move.left);
            } else {
                moveResponse.setMove(Move.right);
            }
        }else{
            if (head.getY() > foodList.get(0).getY()) {
                moveResponse.setMove(Move.up);
            } else {
                moveResponse.setMove(Move.down);
            }
        }

        // System.out.println(moveResponse.toString());

        final String responseBody = gson.toJson(moveResponse);


        return Response.status(Response.Status.OK).entity(responseBody).build();
    }
}

