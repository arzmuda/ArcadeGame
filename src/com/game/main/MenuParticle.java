package com.game.main;

import java.awt.*;
import java.util.Random;

public class MenuParticle extends GameObject {

    private Handler handler;

    Random random = new Random();

    private int red = random.nextInt(255);
    private int green = random.nextInt(255);
    private int blue = random.nextInt(255);
    private Color color;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = (random.nextInt(6 - -6)+ -6);
        velY = (random.nextInt(6 - -6)+ -6);
        if(velX == 0) velX = 1;
        if(velY == 0) velY = 1;

        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);
    }

    @Override
    public void tick() {
        x +=velX;
        y +=velY;
        if(y < 0 || y >= Game.HEIGHT -32) velY *= -1;
        if(x < 0 || x >= Game.WIDTH -16) velX *= -1;

        handler.addObject(new Trail((int)x, (int)y,ID.Trail, color, 16, 16, 0.03f, handler));


    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect((int)x, (int)y, 16, 16 );


    }
}
