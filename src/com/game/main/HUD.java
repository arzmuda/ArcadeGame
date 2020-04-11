package com.game.main;

import java.awt.*;

public class HUD {

    public static float HEALTH = 100;

    private float greenValue = 255;

    private int score = 0;
    private int level = 1;

    public void tick(){


        HEALTH = Game.clamp(HEALTH,0,100);
        greenValue = Game.clamp(greenValue,0,255);

        greenValue = HEALTH*2;

        score++;



    }

    public void render(Graphics graphics){
        graphics.setColor(Color.lightGray);
        graphics.fillRect(15,15,200,32 );
        graphics.setColor(Color.getHSBColor( (1f * HEALTH) / 360, 1f, 1f));
        graphics.fillRect(15,15, (int)HEALTH * 2,32 );
        graphics.setColor(Color.white);
        graphics.drawRect(15,15,200,32);
        graphics.drawString(HEALTH+"%", 15, 15);

        graphics.drawString("Score: " + score, 10, 65);
        graphics.drawString("Level: " + level, 10, 80);

    }
    public void score(int score){
        this.score = score;
    }
    public  int getScore(){
        return score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
