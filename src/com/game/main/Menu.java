package com.game.main;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Menu extends MouseAdapter {

   private Game game;
   private Handler handler;
   private Random random = new Random();

    public Menu(Game game, Handler handler){
        this.game = game;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == Game.STATE.Menu) {

            //play button
            if(mouseOver(mx, my, 210, 150, 200,64)){
                game.gameState = Game.STATE.Game;
                handler.addObject(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
                handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
            }

            //help button
            if(mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = Game.STATE.Help;
            }



            //quit button
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                System.exit(1);
            }
        }



        // back button for help
        if(game.gameState == Game.STATE.Help){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = Game.STATE.Menu;
                return;
            }
        }

    }
    public void mouseReleased(MouseEvent e){

    }

    private  boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height){
                return true;
            }else return false;
        }else return false;
    }

    public void tick(){


    }

    public void render(Graphics graphics){
        if(game.gameState == Game.STATE.Menu){
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);

            graphics.setFont(font);
            graphics.setColor(Color.white);
            graphics.drawString("Menu",240, 70);

            graphics.setFont(font2);
            graphics.drawRect(210,150,200,64);
            graphics.drawString("Play",280, 190);

            graphics.setColor(Color.white);
            graphics.drawRect(210, 250,200, 64);
            graphics.drawString("Help",280, 290);

            graphics.setColor(Color.white);
            graphics.drawRect(210, 350,200, 64);
            graphics.drawString("Quit",280, 390);
        }else if(game.gameState == Game.STATE.Help){
            Font font = new Font("arial", 1, 50);
            Font font2 = new Font("arial", 1, 30);
            Font font3 = new Font("arial", 1, 20);

            graphics.setFont(font);
            graphics.setColor(Color.white);
            graphics.drawString("Help",240, 70);

            graphics.setFont(font3);
            graphics.drawString("Use WASD keys to move and dodge enemies", 100, 200);

            graphics.setFont(font2);
            graphics.drawRect(210, 350, 200, 64);
            graphics.drawString("Back", 270, 390);
        }


    }

}
