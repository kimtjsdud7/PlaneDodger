/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atkinson.game.content;

import com.atkinson.game.engine.BaseActor;
import com.badlogic.gdx.scenes.scene2d.Stage;
/*import com.badlogic.gdx.scenes.scene2d.actions.Actions;*/

/**
 *
 * @author seonyoung.kim
 */
public class Sparkle extends BaseActor {
    
    public Sparkle(float x, float y, Stage s) {
        super(x, y, s);
        
        loadAnimationFromSheet("sparkle.png", 8, 8, 0.02f, false);     // if I set true, it will compile over and over again 
                                                                        // loadAnimationFromSheet:  If you have an animation object called anim, a
                                                                        // sprite sheet called spritesheet.png (that you have put in your images directory and which has
                                                                        // the individual images arranged in a grid with 5 columns and 4 rows) and a frame duration of
                                                                        // 100 milli-seconds, you would use it as follows:
                                                                        // anim.loadAnimationFromSheet(“images/spritesheet.png",5,4,100)
    }
    
    @Override
    public void act(float dt) {
        super.act(dt);
        if(isAnimationFinished()) {
            remove();
        }
    }
    
    
}
