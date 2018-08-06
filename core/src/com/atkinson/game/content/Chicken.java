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
public class Chicken extends BaseActor {
    
    public Chicken(float x, float y, Stage s) {
        super(x, y, s);
        
        loadAnimationFromSheet("FlyingChickenLeft.png", 5, 5, 0.05f, true);
        
        setSpeed(80);
        setBoundaryPolygon(8);
        setMotionAngle(180);
    }
     
    @Override 
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
    }
    
}
