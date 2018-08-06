/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atkinson.game.engine;

import com.badlogic.gdx.scenes.scene2d.Actor;
import java.util.ArrayList;

/**
 *
 * @author Douglas Atkinson
 */
public class Scene extends Actor {
    
    private ArrayList<SceneSegment> segmentList;
    private int index;
    
    public Scene() {
        super();
        segmentList = new ArrayList<SceneSegment>();
        index = -1;
    }
    
    public void addSegment(SceneSegment segment) {
        segmentList.add(segment);
    }
    
    public void clearSegments() {
        segmentList.clear();
    }
    
    public void start() {
        index = 0;
        segmentList.get(index).start();
    }
    
    public void act(float dt) {
        if ( isSegmentFinished() && !isLastSegment() )
            loadNextSegment();
    }
    
    public boolean isSegmentFinished() {
        return segmentList.get(index).isFinished();
    }
    
    public boolean isLastSegment() {
        return (index >= segmentList.size() - 1);
    }
    
    public void loadNextSegment() {
        if ( isLastSegment() )
            return;
        segmentList.get(index).finish();
        index++;
        segmentList.get(index).start();
    }
    
    public boolean isSceneFinished() {
        return ( isLastSegment() && isSegmentFinished() );
    }
}
