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
    private static Board board;

    PointDTO head;
    List<PointDTO> foodList;
    List<SnakeDTO> snakeList;
    MoveResponseDTO moveResponse;
    MoveResponseDTO lastMoveResponse;

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
        startResponse.setColor("red");
        startResponse.setHeadUrl(BASE_URI + "static/head.png");
        startResponse.setName("PunkisSnake");
        startResponse.setTaunt("Meep meep");

        startResponse.setHeadType(HeadType.getPixel());
        startResponse.setTailType(TailType.getBlockbum());

        board = new Board(startRequestDTO.getWidth(), startRequestDTO.getHeight());
        final String responseBody = gson.toJson(startResponse);
        return Response.status(Response.Status.OK).entity(responseBody).build();
    }

    @POST
    //  @Consumes(MediaType.APPLICATION_JSON)
    //  @Produces(MediaType.APPLICATION_JSON)
    @Path("/move")
    public final Response move(final String moveRequest) {
        MoveRequestDTO moveRequestDTO = gson.fromJson(moveRequest, MoveRequestDTO.class);
        System.out.println("FoodPoint" + moveRequestDTO.getFoodAsPoints());

        board.setBoard(moveRequestDTO.getFoodAsPoints(), moveRequestDTO.getSnakes());
        foodList = moveRequestDTO.getFoodAsPoints();
        snakeList = moveRequestDTO.getSnakes();

        head = new PointDTO();
        for (int i = 0; i < snakeList.size(); i++) {
            //  System.out.println("ID-i:" + snakeList.get(i).getId());
            //  System.out.println("My-ID-i:" + moveRequestDTO.getYou());
            if (snakeList.get(i).getId().equals(moveRequestDTO.getYou())) {
                int tmp = snakeList.get(i).getCoordsAsPoints().get(0).getX();
                head.setX(tmp);
                tmp = snakeList.get(i).getCoordsAsPoints().get(0).getY();
                head.setY(tmp);
            }
        }


        moveResponse = new MoveResponseDTO();

        move();

        final String responseBody = gson.toJson(moveResponse);


        return Response.status(Response.Status.OK).entity(responseBody).build();
    }


    public int[] bestimmeRichtung(PointDTO head) {
        int[] frei = new int[4];
        //Rechts Frei?
        if (board.getState(head.getX() + 1, head.getY()) == Tile.State.FREE) {
            frei[0] = 1;
        }
        //Links Frei?
        if (board.getState(head.getX() - 1, head.getY()) == Tile.State.FREE) {
            frei[1] = 1;
        }
        //Oben Frei?
        if (board.getState(head.getX(), head.getY() - 1) == Tile.State.FREE) {
            frei[2] = 1;
        }
        //Unten Frei?
        if (board.getState(head.getX(), head.getY() + 1) == Tile.State.FREE) {
            frei[3] = 1;
        }
        return frei;
    }

    private void move() {
       // final KillBot killBot = new KillBot();
      //  int[] frei = bestimmeRichtung(this.head);
        System.out.println("headX: " + head.getX());
        System.out.println("headY: " + head.getY());

        if (this.head.getY() == foodList.get(0).getY()) {

            if (head.getX() >= foodList.get(0).getX() &&  board.getState(head.getX()-1, head.getY()) != Tile.State.SNAKE) {
                moveResponse.setMove(Move.left);


            } else if(board.getState(head.getX()+1, head.getY())  != Tile.State.SNAKE) {
                moveResponse.setMove(Move.right);

            }
       }else {
            if (head.getY() >= foodList.get(0).getY() && board.getState(head.getX(), head.getY()-1)  != Tile.State.SNAKE) {
                moveResponse.setMove(Move.up);
            } else if(board.getState(head.getX(), head.getY()+1)  != Tile.State.SNAKE) {
                moveResponse.setMove(Move.down);

            }
        }
    }
}

