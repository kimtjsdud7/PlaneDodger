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
 * @author SAMSUNG ATIV 9 PRO
 */
public class Extra extends BaseActor{
    
    public Extra(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("smallGreenPlane.png");
    }
    
}
