package com.game.main;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random random = new Random();
    private Game game;

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud, Game game) {
        this.handler = handler;
        this.game = game;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 100) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (game.difficult == 0) {
                if (hud.getLevel() == 2) {
                    handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 6) {
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 8) {
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                }  else if (hud.getLevel() == 10) {
                    handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                }   else if (hud.getLevel() == 12) {
                    handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 13) {
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                    handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 15) { // BOSS Lvl
                    handler.clearEnemies();
                    handler.addObject(new Boss((Game.WIDTH / 2) - 48, -120, ID.Boss, handler));
                } else if (hud.getLevel() == 21) {
                    handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                    handler.addObject(new SmartEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.SmartEnemy, handler));
                } else if (hud.getLevel() == 22) {
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 23) {
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 24) {
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 25) {
                    handler.addObject(new FastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.FastEnemy, handler));
                } else if (hud.getLevel() == 26) {
                    handler.addObject(new BasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.BasicEnemy, handler));
                }

            }else if(game.difficult == 1) {
                if (hud.getLevel() == 2) {
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardBasicEnemy, handler));
                } else if (hud.getLevel() == 3) {
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardBasicEnemy, handler));
                } else if (hud.getLevel() == 4) {
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                } else if (hud.getLevel() == 5) {
                    handler.addObject(new HardSmartEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardSmartEnemy, handler));
                } else if (hud.getLevel() == 6) {
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                } else if (hud.getLevel() == 8) {
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardSmartEnemy, handler));
                }  else if (hud.getLevel() == 10) {
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardBasicEnemy, handler));
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardSmartEnemy, handler));
                }   else if (hud.getLevel() == 12) {
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardBasicEnemy, handler));
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                } else if (hud.getLevel() == 13) {
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardSmartEnemy, handler));
                } else if (hud.getLevel() == 15) {
                    handler.clearEnemies();
                    handler.addObject(new Boss((Game.WIDTH / 2) - 48, -120, ID.Boss, handler));
                } else if (hud.getLevel() == 21) {
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardBasicEnemy, handler));
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardSmartEnemy, handler));
                } else if (hud.getLevel() == 22) {
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                } else if (hud.getLevel() == 23) {
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                } else if (hud.getLevel() == 24) {
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                } else if (hud.getLevel() == 25) {
                    handler.addObject(new HardFastEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardFastEnemy, handler));
                } else if (hud.getLevel() == 26) {
                    handler.addObject(new HardBasicEnemy(random.nextInt(Game.WIDTH), random.nextInt(Game.HEIGHT), ID.HardBasicEnemy, handler));
                }

            }
        }
    }
}
