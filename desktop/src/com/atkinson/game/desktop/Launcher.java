package com.atkinson.game.desktop;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.atkinson.game.content.*;

public class Launcher {
    public static void main (String[] args)
    {
        Game myGame = new PlaneDodger();
        LwjglApplication launcher = new LwjglApplication( myGame, "Plane Dodger", 800, 600 );
    }
}
