package com.game.main;

import java.awt.*;
import java.util.Random;

public class HardFastEnemy extends GameObject {

    private Handler handler;
    private Random random = new Random();

    public HardFastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 2;
        velY = 8;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    @Override
    public void tick() {
        x +=velX;
        y +=velY;
        if(y < 0 || y >= Game.HEIGHT -32) {if(velY < 0) velY = -(random.nextInt(8)+5)*-1;
        else velY = (random.nextInt(8)+5)*-1;}
        if(x < 0 || x >= Game.WIDTH -16) {if(velX < 0) velX = -(random.nextInt(8)+5)*-1;
        else velX = (random.nextInt(8)+5)*-1;}

        handler.addObject(new Trail((int)x, (int)y,ID.Trail, Color.MAGENTA, 16, 16, 0.03f, handler));


    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillRect((int)x, (int)y, 16, 16 );


    }
}
