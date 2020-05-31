package com.game.main;

import com.sun.xml.internal.messaging.saaj.soap.impl.HeaderImpl;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.Serializable;
import java.util.Random;

public class Game extends Canvas implements Serializable, Runnable {
    private static final long serialVersionUID = 3047141657277970391L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12*9;
    private Thread thread;
    private boolean running = false;

    public static boolean paused = false;
    public int difficult = 0;
    // 0 - normal
    // 1 - hard

    private Random random;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    private Shop shop;

    public enum STATE {
        Menu,
        Help,
        Game,
        SelectDifficulty,
        Shop,
        End
    };

    public STATE gameState = STATE.Menu;

    public Game(){
        handler = new Handler();
        hud = new HUD();
        shop = new Shop(handler, hud);
        menu = new Menu(this, handler, hud);

        this.addKeyListener(new KeyInput(handler, this));
        this.addMouseListener(menu);
        this.addMouseListener(shop);


        new Window(WIDTH, HEIGHT, "GAME", this);
        spawner = new Spawn(handler,hud, this);
        random = new Random();

        if(gameState ==  STATE.Game) {

            handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));
            handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));

        }else{
            for(int i = 0; i < 15; i++){
                handler.addObject(new MenuParticle(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.MenuParticle, handler));
            }
        }

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    public synchronized void stop() {
       try {
           thread.join();
           running = false;
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();

    }

    private void tick(){
        if(gameState == STATE.Game){
            if(!paused) {
                hud.tick();
                spawner.tick();
                handler.tick();
                if (HUD.HEALTH <= 0) {
                    HUD.HEALTH = 100;
                    shop.setBox1(300);
                    shop.setBox2(200);
                    shop.setBox3(500);
                    handler.object.clear();
                    gameState = STATE.End;
                    for (int i = 0; i < 15; i++) {
                        handler.addObject(new MenuParticle(random.nextInt(WIDTH), random.nextInt(HEIGHT), ID.MenuParticle, handler));
                    }
                }
            }
        }else if(gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.SelectDifficulty){
            menu.tick();
            handler.tick();
        }

    }

    private void render(){
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,WIDTH,HEIGHT);



        if(paused){
            graphics.setColor(Color.WHITE);
            graphics.drawString("PAUSED", 200, 100);
        }

        if(gameState == STATE.Game)
        {
            hud.render(graphics);
            handler.render(graphics);
        }else if(gameState == STATE.Shop){
                shop.render(graphics);
        }else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End || gameState == STATE.SelectDifficulty){
            handler.render(graphics);
            menu.render(graphics);
        }



        graphics.dispose();
        bufferStrategy.show();
    }
    public static float clamp(float value, float min, float max){
        if(value >= max)
            return value = max;
        else if (value <= min)
            return  value = min;
        else
            return value;

    }

    public static void main(String args[]) {
        new Game();

    }


}