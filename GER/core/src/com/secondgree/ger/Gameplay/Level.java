package com.secondgree.ger.Gameplay;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by david on 2015-11-11.
 *
 * This will be the first thing to be created; it will create initial levelsections,
 * then create a new levelsection whenever needed to.
 */
public class Level implements GameComponent {

    int currentLevel=0;

    float currentDistance = 0;
    float nextLevel = 0;

    float currentSpeed=0.006f;
    float speedDifficulty=0.001f;

    float distanceInMemory=0;
    float maxDistanceInMemory=5f;

    private ArrayList<LevelSections> sublevels;

    public Level()
    {
        sublevels = new ArrayList<LevelSections>();

        while(distanceInMemory<maxDistanceInMemory)
        {
            generateLevel();
        }

    }
    private void generateLevel()
    {
        LevelSections temp = new LevelSections(distanceInMemory);
        sublevels.add(temp);
        checkDistance();

    }
    private void checkDistance()
    {
        float distance=0;
        for(LevelSections sublevel: sublevels)
        {
            distance+=sublevel.getDistance();
        }
        if(distance>distanceInMemory)
        {
            distanceInMemory=distance;
        }
    }


    @Override
    public void Update()
    {

        currentDistance+=currentSpeed;

        currentSpeed+=speedDifficulty;


    }

    @Override
    public void Draw(SpriteBatch batch)
    {
        for(LevelSections sublevel:sublevels)
        {
            sublevel.Draw(batch);
        }

    }
}
