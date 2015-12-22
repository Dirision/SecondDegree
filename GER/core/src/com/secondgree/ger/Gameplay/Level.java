package com.secondgree.ger.Gameplay;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.GERGame;

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

    float currentSpeed=0.01f;
    float speedDifficulty=0.00001f;

    float distanceInMemory=0;
    float maxDistanceInMemory=10f;

    Character player;

    private ArrayList<LevelSection> sublevels;

    public Level()
    {
        sublevels = new ArrayList<LevelSection>();
        player = new Character(0,0.15f);//starting position

        checkAndGenerate();
        nextLevel = sublevels.get(0).getDistance();
        checkCurrentLevel();
    }
    private void checkAndGenerate()
    {
        while(distanceInMemory<maxDistanceInMemory)
        {
            generateLevel();

        }
    }


    /**
     * Internal usage to create a single level, and adds it at the end of the sublevels list.
     */
    private void generateLevel()
    {
        LevelSection temp=null;


        if (distanceInMemory>0)
        {
            temp = new LevelSection(currentDistance+distanceInMemory,sublevels.get(sublevels.size()-1).getFirstPlatform());
        }
        else
        {
            temp = new LevelSection();
        }
        sublevels.add(temp);
        checkDistance();
        System.out.println("generaterinod");

    }
    private void checkDistance()
    {
        float distance=0;
        for(LevelSection sublevel: sublevels)
        {
            distance+=sublevel.getDistance();
        }

            distanceInMemory=distance;

    }


    public ArrayList<GameplayComponent> getReleventObjects()
    {
        ArrayList<GameplayComponent> c = new ArrayList<GameplayComponent>();
        for(int x=0;x<2;x++)
        {

            for(GameplayComponent g:sublevels.get(x).getAllObjects())
            {
                c.add(g);
            }
        }

        return c;
    }
    @Override
    public void Update()
    {

        GERGame.cam.translate(currentSpeed * GERGame.gWidth, 0);
        GERGame.cam.update();
        currentDistance+=currentSpeed;
        checkCurrentLevel();
        checkAndGenerate();

        currentSpeed+=speedDifficulty;
        player.doCollision(getReleventObjects());

        player.Update(currentDistance);
        for(LevelSection sublevel: sublevels)
        {
            sublevel.Update();
        }




    }
    private void checkCurrentLevel()
    {
        if(currentDistance>(nextLevel+0.5f))
        {

            nextLevel = sublevels.get(1).getRelativeDistance();
            sublevels.remove(0);
            checkDistance();
        }
    }

    @Override
    public void Draw(SpriteBatch batch)
    {
       // GERGame.cam.translate();


        for(LevelSection sublevel:sublevels)
        {
            sublevel.Draw(batch);
        }
        player.Draw(batch);
       // sublevels.get(0).Draw(batch);

    }
}
