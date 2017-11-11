package com.github.stairch.rest;

import com.github.stairch.dtos.MoveRequestDTO;
import com.github.stairch.dtos.PointDTO;
import com.github.stairch.dtos.SnakeDTO;

import java.util.ArrayList;
import java.util.List;

public class KillBot {
    public void killOppenent(MoveRequestDTO moveRequestDTO) {

        //Gibt die Koordinaten der Köpfe zurück
        List<SnakeDTO> snakeList = moveRequestDTO.getSnakes();
        PointDTO head = new PointDTO();
        PointDTO myHead = new PointDTO();
        ArrayList<PointDTO> headsToShoot = new ArrayList<PointDTO>();
        for (int i = 0; i < snakeList.size(); i++) {
            if (!snakeList.get(i).getId().equals(moveRequestDTO.getYou())) {
                int tmp = snakeList.get(i).getCoordsAsPoints().get(0).getX();
                head.setX(tmp);
                tmp = snakeList.get(i).getCoordsAsPoints().get(0).getY();
                head.setY(tmp);
                headsToShoot.add(head);
            } else {
                int tmp = snakeList.get(i).getCoordsAsPoints().get(0).getX();
                myHead.setX(tmp);
                tmp = snakeList.get(i).getCoordsAsPoints().get(0).getY();
                myHead.setY(tmp);
            }
        }
        

        //Ist der Gegnerische

    }

}


