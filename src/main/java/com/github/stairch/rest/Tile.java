/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.stairch.rest;

/**
 *
 * @author sandr
 */
public class Tile {
    public enum State { FREE, SNAKE, FOOD};
    private State state = State.FREE;
    
    public void setState(State state){
        this.state = state;
    }
    
    public State getState(){
        return state;
    }
}
