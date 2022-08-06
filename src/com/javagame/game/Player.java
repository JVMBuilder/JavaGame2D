package com.javagame.game;

import java.awt.event.KeyEvent;



public class Player implements Log{

    int playerWidth = 60;
    int playerHeight = 60;
    private int mapX = 0;
    private int mapY = 0;
    private int speed = 3;

    @Override
    public void showLog() {
        System.out.println("Player Map X: " + mapX + "\nPlayer Map Y: " + mapY);
    }

    enum Direction{UP, DOWN, LEFT, RIGHT, NONE, ESC};
    private Direction playerDirection = Direction.NONE;

    public void move(){
        switch(playerDirection) {
            case UP:
                mapY-=speed;
                break;
            case DOWN:
                mapY+=speed;
                break;
            case LEFT:
                mapX-=speed;
                break;
            case RIGHT:
                mapX+=speed;
                break;
            case ESC:
                System.exit(3);
            case NONE:

            default:
                break;
        }
    }


    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W) {
            playerDirection = Direction.UP;
        }
        if(key == KeyEvent.VK_S) {
            playerDirection = Direction.DOWN;
        }
        if(key == KeyEvent.VK_A) {
            playerDirection = Direction.LEFT;
        }
        if(key == KeyEvent.VK_D) {
            playerDirection = Direction.RIGHT;
        }
        if (key == KeyEvent.VK_ESCAPE){
            playerDirection = Direction.ESC;
        }
    }

    public void keyReleased(KeyEvent e) {
        playerDirection = Direction.NONE;
    }

    public int getMapX() {
        return mapX;
    }
    public int getMapY() {
        return mapY;
    }
    public void setMapX(int mapX) {
        this.mapX = mapX;
    }
    public void setMapY(int mapY) {
        this.mapY = mapY;
    }

    public int getSpeed() {
        return speed;
    }
}
