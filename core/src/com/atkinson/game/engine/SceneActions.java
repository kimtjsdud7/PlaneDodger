/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atkinson.game.engine;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Align;

/**
 *
 * @author Douglas Atkinson
 */
public class SceneActions extends Actions {
    
    public static Action setText(String s) {
        return new SetTextAction(s);
    }
    
    public static Action pause() {
        return Actions.forever( Actions.delay(1) );
    }
    
    public static Action moveToScreenLeft(float duration) {
        return Actions.moveToAligned( 0, 0, Align.bottomLeft, duration );
    }
    
    public static Action moveToScreenRight(float duration) {
        return Actions.moveToAligned( BaseActor.getWorldBounds().width, 0, Align.bottomRight, duration );
    }
    
    public static Action moveToScreenCenter(float duration) {
        return Actions.moveToAligned( BaseActor.getWorldBounds().width / 2, 0, Align.bottom, duration);
    }
            
    public static Action moveToOutsideLeft(float duration) {
        return Actions.moveToAligned( 0, 0, Align.bottomRight, duration );
    }
    
    public static Action moveToOutsideRight(float duration) {
        return Actions.moveToAligned( BaseActor.getWorldBounds().width, 0, Align.bottomLeft, duration );
    }
}
