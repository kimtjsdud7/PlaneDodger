/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atkinson.game.engine;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 *
 * @author Douglas Atkinson
 */
public class Sign extends BaseActor {
    
    // the text to be displayed
    private String text;
    // used to determine if sign text is currently being displayed
    private boolean viewing;
    
    public Sign(float x, float y, Stage s) {
        super(x, y, s);
        
        loadTexture("sign.png");
        text = " ";
        viewing = false;
    }
    
    public void setText(String t) {
        text = t;  
    }
    
    public String getText() {
        return text;  
    }
    
    public void setViewing(boolean v) {
        viewing = v;  
    }
    
    public boolean isViewing() {
        return viewing;  
    }  
    
}
