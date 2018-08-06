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
public class Spatter extends BaseActor{
    
    public Spatter(float x, float y, Stage s) {
        super(x, y, s);
        loadAnimationFromSheet("bloodSpatter.png", 3, 3, 0.05f, false); 
        
    }
     @Override
    public void act(float dt) {
        super.act(dt);
        if(isAnimationFinished()) {
            remove();
        }
    }
}
