package com.javagame.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends JPanel implements ActionListener {


    ClassLoader loader = this.getClass().getClassLoader();
    Image ship = new ImageIcon(loader.getResource("Ship.png")).getImage();
    Image enemyShip = new ImageIcon(loader.getResource("Enemy.png")).getImage();

    Timer timer = new Timer(10, this);
    Player player = new Player();
    Enemy enemy = new Enemy();
    JFrame frame;

    public Controller(JFrame frame) {
        timer.start();
        this.frame = frame;


        Thread keyThread = new Thread(new Runnable() {
            @Override
            public void run() {
                frame.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e) {
                        player.keyPressed(e);
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        player.keyReleased(e);
                    }
                });
            }
        });
        keyThread.start();
    }

    /*
    public void fail(){
        if ((player.getMapX()+5 == enemy.getMapX()) && (player.getMapY()-5 == enemy.getMapY()) || (player.getMapX()-5 == enemy.getMapX()) &&  ){

        }
    }

     */



    @Override
    public void paint(Graphics g) {


        //Paint Map
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, frame.getWidth(), frame.getHeight());


        //Paint Player

        //Check Player location
        if (player.getMapX() >= frame.getWidth() - player.playerWidth) {
            player.setMapX(frame.getWidth() - player.playerWidth);
        } else if (player.getMapX() <= 0) {
            player.setMapX(0);
        }

        if (player.getMapY() >= frame.getHeight() - player.playerHeight) {
            player.setMapY(frame.getHeight() - player.playerHeight);
        } else if (player.getMapY() <= 0) {
            player.setMapY(0);
        }

        if (player.getMapY() == enemy.getMapY() && player.getMapX() == enemy.getMapX() ){
            JOptionPane.showMessageDialog(null, "You Lose");
        }

        //draw Player
        g.drawImage(ship, player.getMapX(), player.getMapY(), player.playerWidth, player.playerHeight, null);


        //Paint Enemy
/*
                if (enemy.getMapX() == player.getMapX()){
                    enemy.relocation(frame.getWidth()-enemy.enemyWidth, frame.getHeight()-enemy.enemyHeight);
                } else if (enemy.getMapX() >= frame.getWidth() - enemy.enemyWidth) {
                    enemy.setMapX(frame.getWidth() - enemy.enemyWidth);
                } else if (enemy.getMapX() <= frame.getWidth() - enemy.enemyWidth) {
                    enemy.setMapX(0);
                }

                if (enemy.getMapY() == player.getMapY()){
                    enemy.relocation(frame.getWidth() - enemy.enemyWidth, frame.getHeight() - enemy.enemyHeight);
                } else if (enemy.getMapY() >= frame.getHeight() - enemy.enemyWidth) {
                    enemy.setMapY(frame.getHeight());
                } else if (enemy.getMapY() <= frame.getHeight() - enemy.enemyWidth) {
                    enemy.setMapY(0);
                }
 */

        if (enemy.getMapX() >= frame.getWidth() - enemy.enemyWidth){
            enemy.setSpeed(-2);
        }
       else if (enemy.getMapX() <= 0) {
           enemy.setSpeed(2);
       }

        g.drawImage(enemyShip, enemy.getMapX(), enemy.getMapY(), enemy.enemyWidth, enemy.enemyHeight, null);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        enemy.move();
        player.move();



        player.showLog();
        enemy.showLog();

    }
}
