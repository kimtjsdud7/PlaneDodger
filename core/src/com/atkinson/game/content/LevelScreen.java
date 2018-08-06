package com.atkinson.game.content;

import com.atkinson.game.engine.BaseScreen;
import com.atkinson.game.engine.BaseActor;
import com.atkinson.game.engine.BaseGame;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.audio.Sound;        // sound effect
import com.badlogic.gdx.audio.Music;        // background music
import com.badlogic.gdx.scenes.scene2d.ui.List;
import java.util.ArrayList;


public class LevelScreen extends BaseScreen {
    
    // Plane
    private Plane plane;
    
    
    // Extra life
//    private Extra extra[];
    private Extra extra1;
    private Extra extra2;
    private Extra extra3;
    boolean lives;
    boolean lives1;
    private int count = 0;


    // Bullet
    private Bullet bullet;
    
    // Star stuff
    private float starTimer;
    private float starSpawnInterval;
    
    private int score;
    Label scoreLabel;

            ;
    // Enemy stuff
    float enemyTimer;
    float enemySpawnInterval;
    float enemySpeed;
    
    boolean gameOver;
    BaseActor gameOverMessage;
    
    // Chicken Stuff
    float chickenTimer;
    float chickenSpawnInterval;
    float chickenSpeed;
    
    // Sound Stuff
    Music backgroundMusic;
    Sound sparkleSound;
    Sound explosionSound;
    Sound chickenSound;
    Sound shot;
    
    public void initialize() {
        
        new Sky(0, 0, mainStage);
        new Sky(800, 0, mainStage);
        new Ground(0, 0, mainStage);
        new Ground(800, 0, mainStage);
        
        // Instantiate Plane and set world bounds
        plane = new Plane(100,500, mainStage);  
        BaseActor.setWorldBounds(800,600);
        
        // extra life
//        ArrayList<Plane> lives = new ArrayList();
        extra1 = new Extra(90, 550, mainStage);
        extra2 = new Extra(50, 550, mainStage);
        extra3 = new Extra(10, 550, mainStage);
        lives = false;
        lives1 = false;
//        for(Plane s: lives){
//            System.out.print(s);
//        }
        
        // Star timer and score label
        starTimer = 0;
        starSpawnInterval = 4;
        score = 0;
        scoreLabel = new Label(Integer.toString(score), BaseGame.labelStyle);
      
        uiTable.pad(10);
        uiTable.add(scoreLabel);        // row 0, col 0
        uiTable.row();      // create a new row
             
        // Enemy timer
        enemyTimer = 0;
        enemySpeed = 100;
        enemySpawnInterval = 3;
        gameOver = false;
        gameOverMessage = new BaseActor(0, 0, uiStage);
        gameOverMessage.loadTexture("game-over.png");
        gameOverMessage.setVisible(false);
        uiTable.add(gameOverMessage).expandY(); 
        
        // Chicken timer
        chickenTimer = 0;
        chickenSpeed = 100;
        chickenSpawnInterval = 5;
        
        // Sound
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("Prelude-and-Action.mp3"));
        sparkleSound = Gdx.audio.newSound(Gdx.files.internal("sparkle.mp3"));
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosion.wav"));
        chickenSound = Gdx.audio.newSound(Gdx.files.internal("chickensquawk.wav"));
        shot = Gdx.audio.newSound(Gdx.files.internal("gunshot.ogg"));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(1.00f);
        backgroundMusic.play();   
 
    }
	
    public void update(float dt) {      
        
        // get out if game is over
        if(gameOver) return;
        // extra lives

        // For star spawning and star scoring, 
        starTimer += dt; // dt is deta time: everytime we call update, we add how much time pass since we update

        if(starTimer > starSpawnInterval) {
            new Star(800, MathUtils.random(100, 500), mainStage);
            starTimer = 0;
        }
        
        for(BaseActor star: BaseActor.getList(mainStage, "com.atkinson.game.content.Star")) {
            if(plane.overlaps(star)) {
                Sparkle sp = new Sparkle(0, 0, mainStage);
                sp.centerAtActor(star);
                sparkleSound.play();
                
                star.remove();
                score++;
                scoreLabel.setText(Integer.toString(score));
            }
            
        }

        // For enemy
        
        enemyTimer += dt;
        if(enemyTimer > enemySpawnInterval) {
            
            Enemy enemy = new Enemy(800, MathUtils.random(100,500), mainStage);
            enemy.setSpeed(enemySpeed);
            enemyTimer = 0;
            enemySpawnInterval -= 0.10f; // 10 of second
            enemySpeed += 10;
            
            if(enemySpawnInterval < 0.5f) 
                enemySpawnInterval = 0.5f;
            if(enemySpeed > 400)
                enemySpeed = 400;
        }
        
         for(BaseActor enemy: BaseActor.getList(mainStage, "com.atkinson.game.content.Enemy")) { 
            if(plane.overlaps(enemy) && !lives) {
                    // Enemy explosion code
                    Explosion ex = new Explosion(0, 0, mainStage);
                    ex.centerAtActor(enemy);
                    explosionSound.play();
                    enemy.remove();
                    plane.remove();
                    extra1.remove();
                    plane = new Plane(100,300, mainStage);
                    lives = true;
            }
            if(lives){
                if(plane.overlaps(enemy) && !lives1) {
                        // Enemy explosion code
                        Explosion ex = new Explosion(0, 0, mainStage);
                        ex.centerAtActor(enemy);
                        explosionSound.play();
                        enemy.remove();
                        plane.remove();
                        extra2.remove();
                        plane = new Plane(100,300, mainStage);
                        lives1 = true;
                }
            }
            if(lives1){
                if(plane.overlaps(enemy)) {
                        // Enemy explosion code
                        Explosion ex = new Explosion(0, 0, mainStage);
                        ex.centerAtActor(enemy);
                        explosionSound.play();
                        enemy.remove();
                        plane.remove();
                        extra3.remove();
                        lives = false;
                        lives1 = false;
                        backgroundMusic.stop();
                        gameOver = true;
                        gameOverMessage.setVisible(true);
                }                
            }                  
                     
            if(enemy.getX() + enemy.getWidth() < 0) {
                score++;
                scoreLabel.setText(Integer.toString(score));
                enemy.remove(); 
            } 

            for(BaseActor bullet: BaseActor.getList(mainStage, "com.atkinson.game.content.Bullet")){
            if(bullet.overlaps(enemy)){
                // Enemy explosion code
                Explosion ex = new Explosion(0, 0, mainStage);
                ex.centerAtActor(enemy);
                explosionSound.play();
                bullet.remove();
                enemy.remove();
            }
            }

            }

                
          // for Chicken
         chickenTimer += dt;
              
        if(chickenTimer > chickenSpawnInterval) {
            new Chicken(800, MathUtils.random(100, 500), mainStage);
            chickenTimer = 0;
        }
        for(BaseActor chicken: BaseActor.getList(mainStage, "com.atkinson.game.content.Chicken")) {
            if(plane.overlaps(chicken)) {
                Spatter spatter = new Spatter(0, 0, mainStage);
                spatter.centerAtActor(chicken);
                chickenSound.play();
//                sparkleSound.play();
                spatter.setScale(0.3f);
                chicken.remove();
                score += 10;
                scoreLabel.setText(Integer.toString(score));
            }
            for(BaseActor bullet: BaseActor.getList(mainStage, "com.atkinson.game.content.Bullet")) {
            if(bullet.overlaps(chicken) ){
                // Enemy explosion code
                Spatter spatter = new Spatter(0, 0, mainStage);
                spatter.centerAtActor(chicken);
                spatter.setScale(0.3f);
                chickenSound.play();
                chicken.remove();
                bullet.remove();
            }  
            }
        }
        
    }
    public boolean keyDown(int keyCode) {
        if(keyCode == Keys.SPACE)
           plane.shoot();
           shot.play();
           return true;
    }
    
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if(button == Input.Buttons.LEFT)
            plane.boost();
        return true;
    }  
}
