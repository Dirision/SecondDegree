package com.secondgree.ger.Gameplay;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by david on 2015-11-11.
 * This represents an individual portion of the level, a slice, there are many of these.
 */
public class LevelSections implements GameComponent {

    private float sectionDistance;



    private float sectionBeginning;

    Color sectionColor;

    ArrayList<Platform> platforms = new ArrayList<Platform>();

    public LevelSections(float beginning)
    {

        sectionBeginning = beginning;

        //lets generate a level!
        Random r = new Random();
        sectionDistance = (r.nextFloat() * 2)+0.5f;
    }

    public float getBeginning() {
        return sectionBeginning;
    }

    public float getRelativeDistance()
    {
        return sectionDistance+sectionBeginning;
    }

    public float getDistance()
    {
        return sectionDistance;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(SpriteBatch batch) {

    }
    public GameplayComponent[] getAllObjects()
    {
        GameplayComponent[] things = new GameplayComponent[platforms.size()];
        for(GameplayComponent c : platforms)
        {
            things[platforms.indexOf(c)]= c;
        }
        return things;
    }
}
