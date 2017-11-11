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
 * @author sandr
 */
public class Board {
    private Tile[][] tiles;
    private int width;
    private int height;

    public Board(int width, int height) {
        tiles = new Tile[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = new Tile();
            }
        }
        this.width = width;
        this.height = height;
    }

    private void cleanBoard(){
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if(tiles[x][y].getState() != Tile.State.FREE){
                    tiles[x][y].setState(Tile.State.FREE);
                }
            }
        }
    }

    public void setBoard(List<PointDTO> foods, List<SnakeDTO> snakes) {
        cleanBoard();
        for (PointDTO p : foods) {
            setFieldblocked(p, Tile.State.FOOD);
        }
        for (SnakeDTO s : snakes) {
            for (PointDTO p : s.getCoordsAsPoints()) {
                setFieldblocked(p, Tile.State.SNAKE);
            }
        }
    }

    private void setFieldblocked(PointDTO p, Tile.State state) {

        tiles[p.getX()][p.getY()].setState(state);
    }

    public Tile.State getState(int x, int y) {
        if (x >= tiles.length || x < 0) {
            System.out.println("Wall!");
            return Tile.State.WALL;
        } else if (y >= tiles.length || y < 0) {
            System.out.println("Wall!");
            return Tile.State.WALL;
        }
        return tiles[x][y].getState();
    }

    public void printBoard() {
        System.out.println("############################################################################33");
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                String tmp = "";
                if (tiles[y][x].getState() == Tile.State.FOOD) {
                    tmp = "X";
                } else if (tiles[y][x].getState() == Tile.State.SNAKE) {
                    tmp = "S";
                } else if (tiles[y][x].getState() == Tile.State.WALL) {
                    tmp = "W";
                } else {
                    tmp = "0";
                }

                System.out.printf(" " + tmp + " ");
            }
            System.out.println();
        }

        System.out.println("############################################################################33");
    }

}
