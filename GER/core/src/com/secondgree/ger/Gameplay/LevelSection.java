package com.secondgree.ger.Gameplay;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.GERGame;
import com.secondgree.ger.T;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by david on 2015-11-11.
 * This represents an individual portion of the level, a slice, there are many of these.
 */
public class LevelSection implements GameComponent {

    private float sectionDistance;



    private float sectionBeginning;

    private float platformDistance;//used for platform generation

    Color sectionColor;
    Color colors[] = {Color.BLUE,Color.RED,Color.CYAN,Color.CHARTREUSE,Color.FIREBRICK};

    ArrayList<Platform> platforms = new ArrayList<Platform>();

    /**
     * Use this one for the very first level of the game (beginning platform is at default)
     */
    public LevelSection()
    {

        sectionColor = colors[(int)(Math.random()*(colors.length-1))];
        //
        //sectionBeginning = beginning; temp logic change
        sectionBeginning = 0;

        //lets generate a level!
        Random r = new Random();
        sectionDistance = (r.nextFloat() * 4)+2f;//how long, in pixels the section is

        //generate the platforms in the level.

        platformDistance = 0;
        platforms = makePlatforms(null); //precondition: sectionDistance is set!

    }

    /**
     * Use this one for every platform after the first one
     * @param beginning the distance, a float, in pixels, of when the section begins
     * @param start
     */
    public LevelSection(float beginning, ArrayList<Platform> start)
    {

        //
        sectionColor = colors[(int)(Math.random()*(colors.length-1))];
        sectionBeginning = beginning;

        //lets generate a level!
        Random r = new Random();
        sectionDistance = (r.nextFloat() * 4)+2f;


        platformDistance = 0;
        platforms = makePlatforms(start);
    }

    public ArrayList<Platform> makePlatforms(ArrayList<Platform> c)
    {

        if(c==null)
        {
            c = new ArrayList<Platform>();
        }
        int numPlatforms = (int)(sectionDistance/0.2f);
        for(int i=0;i<numPlatforms;i++)
        {
            Platform t = new Platform(sectionBeginning+(i*0.25f),0.2f);
            c.add(t);
        }
        return c;
    }

    public ArrayList<Platform> getFirstPlatform() {
        ArrayList<Platform> p = new ArrayList<Platform>();
        try {
            p.add(platforms.get(platforms.size() - 1));
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            p = null;
        }
        return p;
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

        //draw super cool background
        Sprite t1 = T.r.get(0);
        t1.setBounds(((sectionBeginning)* GERGame.gWidth),0,(sectionDistance)*GERGame.gWidth,GERGame.gHeight);
        t1.setColor(sectionColor);
        t1.draw(batch,0.75f);

        for(Platform p: platforms)
        {
            p.Draw(batch);
        }

    }
    public ArrayList<Platform> getAllObjects()
    {

        return platforms;
    }
}
