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
    float nextLevel = -1;

    float currentSpeed=0.006f;
    float speedDifficulty=0.001f;

    float distanceInMemory=0;
    float maxDistanceInMemory=10f;

    private ArrayList<LevelSections> sublevels;

    public Level()
    {
        sublevels = new ArrayList<LevelSections>();

        checkAndGenerate();
        checkCurrentLevel();
    }
    private void checkAndGenerate()
    {
        while(distanceInMemory<maxDistanceInMemory)
        {
            generateLevel();
        }
    }


    private void generateLevel()
    {
        LevelSections temp = new LevelSections(distanceInMemory+currentDistance);
        sublevels.add(temp);
        checkDistance();
        System.out.println("generaterinod");

    }
    private void checkDistance()
    {
        float distance=0;
        for(LevelSections sublevel: sublevels)
        {
            distance+=sublevel.getDistance();
        }

            distanceInMemory=distance;

    }


    public GameplayComponent[] getReleventObjects()
    {
        GameplayComponent badthings;
        return sublevels.get(0).getAllObjects();
    }
    @Override
    public void Update()
    {
        System.out.println("cur "+ currentDistance+". nex "+nextLevel);
        System.out.println("dist in mem "+ distanceInMemory+". max "+maxDistanceInMemory);
        currentDistance+=currentSpeed;
        checkCurrentLevel();
        checkAndGenerate();

        currentSpeed+=speedDifficulty;

        for(LevelSections sublevel: sublevels)
        {
            sublevel.Update();
        }




    }
    private void checkCurrentLevel()
    {
        if(currentDistance>nextLevel)
        {

            nextLevel = sublevels.get(1).getRelativeDistance();
            sublevels.remove(0);
            checkDistance();
        }
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
