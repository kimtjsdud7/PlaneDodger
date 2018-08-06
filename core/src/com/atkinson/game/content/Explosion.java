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
public class Explosion extends BaseActor {
    
    public Explosion(float x, float y, Stage s) {
        super(x, y, s);
        loadAnimationFromSheet("explosion.png", 6, 6, 0.02f, false);
    }
    
    @Override
    public void act(float dt) {
        super.act(dt);
        
        if(isAnimationFinished()) {
                remove();
        }
    
    
    }
}
