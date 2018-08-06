/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atkinson.game.content;
import com.atkinson.game.engine.BaseActor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 *
 * @author seonyoung.kim
 */
public class Enemy extends BaseActor {
    
    public Enemy(float x, float y, Stage s) {
        super(x, y, s);
           
        String[] filenames = {"planeRed0.png", "planeRed1.png",
                               "planeRed2.png", "planeRed1.png"};
        
        loadAnimationFromFiles(filenames, 0.1f, true);
        
        setSpeed(100);
        setBoundaryPolygon(8);
        setMotionAngle(180);
    }
        
    @Override 
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
}
