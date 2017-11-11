/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.stairch.rest;

import com.github.stairch.dtos.PointDTO;
import com.github.stairch.dtos.SnakeDTO;
import java.util.List;

/**
 *
 * @author sandr
 */
public class Board {
    private Tile[][] tiles;
    
    public Board(int width, int height){
        tiles = new Tile[width][height];
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                tiles[x][y] = new Tile();
            }
        }
    }
    
    public void setBoard(List<PointDTO> foods, List<SnakeDTO> snakes){
        for(PointDTO p : foods){
            setFieldblocked(p, Tile.State.FOOD);
        }
        
        for(SnakeDTO s : snakes){
            for(PointDTO p : s.getCoordsAsPoints()){
                setFieldblocked(p, Tile.State.SNAKE);
            }
        }
    }
    
    private void setFieldblocked(PointDTO p, Tile.State state){
        tiles[p.getX()][p.getY()].setState(state);
    }

    public Tile.State getState(int x, int y){
        return tiles[x][y].getState();
    }
}
