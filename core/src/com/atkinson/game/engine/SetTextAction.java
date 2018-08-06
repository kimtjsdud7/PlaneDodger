/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atkinson.game.engine;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Action;

/**
 *
 * @author Douglas Atkinson
 */
public class SetTextAction extends Action {

    protected String textToDisplay;
    
    public SetTextAction(String t) {  
        textToDisplay = t;
    }
     
    @Override
    public boolean act(float dt) {
        DialogBox db = (DialogBox)target;
        db.setText( textToDisplay );
        return true;
    }    
}
