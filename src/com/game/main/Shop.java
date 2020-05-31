package com.game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter {
    Handler handler;
    HUD hud;

    private int Box1 = 300; //Upgrade health
    private int Box2 = 200; //Upgrade Speed
    private int Box3 = 500; //Refile Health

    public Shop(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;

    }

    public void render(Graphics graphics){
        graphics.setColor(Color.white);
        graphics.setFont(new Font("arial",0,48));
        graphics.drawString("SHOP", Game.WIDTH/2-100, 50);

        //box 1
        graphics.setFont(new Font("arial",0,12));
        graphics.drawString("Uprage Health", 110, 120);
        graphics.drawString("Cost: " + Box1, 110, 140);
        graphics.drawRect(100,100,100,80);

        //box 2
        graphics.drawString("Upgrade Speed", 260, 120);
        graphics.drawString("Cost: " + Box2, 260, 140);
        graphics.drawRect(250,100,100,80);

        //box 3
        graphics.drawString("Refile Health", 410, 120);
        graphics.drawString("Cost: " + Box3, 410, 140);
        graphics.drawRect(400,100,100,80);

        graphics.drawString("Score: " + hud.getScore(), Game.WIDTH/2-50, 300);
        graphics.drawString("Press Space to go back: ", Game.WIDTH/2-50, 330);
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        //box 1
        if(mx >= 100 && mx <= 200){
            if(my >= 100 && my <= 180){
                //select box 1(upgrade health)
                if(hud.getScore() >= Box1){
                    hud.setScore(hud.getScore() - Box1);
                    Box1 += 200;
                    hud.bounds += 20;
                   // hud.HEALTH = (100 + (hud.bounds/2));
                }
            }
        }
        //box 2
        if(mx >= 250 && mx <= 350){
            if(my >= 100 && my <= 180){
                //select box 2(upgrade speed)
                if(hud.getScore() >= Box2){
                    hud.setScore(hud.getScore() - Box2);
                    Box2 += 100;
                    handler.speed++;
                }
            }
        }
        //box 3
        if(mx >= 400 && mx <= 500){
            if(my >= 100 && my <= 180){
                //select box 3(refile health)
                if(hud.getScore() >= Box3){
                    hud.setScore(hud.getScore() - Box3);
                    Box3 += 200;
                    hud.HEALTH = (100 + (hud.bounds/2));
                }
            }
        }
    }

    public void setBox1(int box1) {
        Box1 = box1;
    }

    public void setBox2(int box2) {
        Box2 = box2;
    }

    public void setBox3(int box3) {
        Box3 = box3;
    }
}
