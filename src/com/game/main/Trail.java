package com.game.main;

import java.awt.*;

public class Trail extends GameObject {
    private int width, height;
    private float lifetime;
    private Color color;
    private float alpha = 1;
    private Handler handler;


    public Trail(float x, float y, ID id, Color color, int width, int height, float lifetime, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        this.color = color;
        this.width = width;
        this.height = height;
        this.lifetime = lifetime;
    }

    @Override
    public void tick() {
        if(alpha > lifetime) {
            alpha -= (lifetime - 0.0001f);
        }else handler.removeObject(this);

        }


    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        graphics2D.setComposite(makeTransparent(alpha));
        graphics.setColor(color);
        graphics.fillRect((int)x, (int)y,width,height);
        graphics2D.setComposite(makeTransparent(1));


    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
