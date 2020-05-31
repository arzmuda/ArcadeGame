package com.game.main;

import java.awt.*;
import java.util.Random;

public class BossMinion extends GameObject {

    private Handler handler;
    Random random = new Random();

    public BossMinion(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = (random.nextInt(6 - -6)+ -6);
        velY = 6;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    @Override
    public void tick() {
        x +=velX;
        y +=velY;


        if(y >= Game.HEIGHT) handler.removeObject(this);
        handler.addObject(new Trail((int)x, (int)y,ID.Trail, Color.red, 16, 16, 0.03f, handler));


    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect((int)x, (int)y, 16, 16 );


    }
}
