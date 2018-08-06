/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atkinson.game.content;

import com.atkinson.game.engine.BaseActor;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
/**
 *
 * @author SAMSUNG ATIV 9 PRO
 */
public class Bullet extends BaseActor {

    
    public Bullet(float x, float y, Stage s) {
        super(x, y, s);
        
        loadTexture("bullet.png");
        
        addAction(Actions.delay(1.6f));
        addAction(Actions.after(Actions.removeActor()));
        
        setSpeed(400);
        setMaxSpeed(400);
        setDeceleration(0);
    }
    @Override 
    public void act(float dt) {
        super.act(dt);
        applyPhysics(dt);
        wrapAroundWorld();
    }

}
