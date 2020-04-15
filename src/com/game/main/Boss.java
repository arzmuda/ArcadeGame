package com.game.main;

import java.awt.*;
import java.util.Random;

public class Boss extends GameObject {

    private Handler handler;
    private Random random = new Random();
    private int timer = 150;
    private int timer2 = 100;

    public Boss(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        velX = 0;
        velY = 2;
    }
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 96, 96);
    }

    @Override
    public void tick() {
        x +=velX;
        y +=velY;

        timer--;
        if(timer <= 0) velY = 0;
        else timer--;

        if(timer <= 0) timer2--;
        if(timer2 <= 0)
        {
            if(velX == 0) velX = 2;
            if(velX > 0)
                velX += 0.01f*Math.signum(velX);

            velX = Game.clamp(velX,-10,10);



            int spawn = random.nextInt(10);
            if(spawn == 0) handler.addObject(new BossMinion((int)x + 48, (int)y + 48,ID.BossMinion,handler));
        }

        if(x < 0 || x >= Game.WIDTH -96) velX *= -1;

        //handler.addObject(new Trail((int)x, (int)y,ID.Trail, Color.red, 96, 96, 0.03f, handler));


    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        graphics.fillRect((int)x, (int)y, 96, 96 );


    }
}
