package com.javagame.game;

public class Enemy implements Log{
    int enemyWidth = 50;
    int enemyHeight = 50;
    private int MapX = 200;
    private int MapY = 200;
    private int speed = 2;

    public void move(){
        MapX+=speed;
    }

    public void relocation(int width, int height){
        float random = (float) Math.random();
        float rX = random * width;
        float rY = random * height;

        int randomX = (int) Math.ceil(rX);
        int randomY = (int) Math.ceil(rY);

        MapX = randomX;
        MapY = randomY;
    }

    public int getMapX() {
        return MapX;
    }

    public int getMapY() {
        return MapY;
    }

    public void setMapX(int mapX) {
        MapX = mapX;
    }

    public void setMapY(int mapY) {
        MapY = mapY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void showLog() {
        System.out.println("Enemy Map X: " + MapX + "\nEnemy Map Y: " + MapY);
    }
}
