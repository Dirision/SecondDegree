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
public class LevelSections implements GameComponent {

    private float sectionDistance;



    private float sectionBeginning;

    Color sectionColor;
    Color colors[] = {Color.BLUE,Color.RED,Color.CYAN,Color.CHARTREUSE,Color.FIREBRICK};

    ArrayList<Platform> platforms = new ArrayList<Platform>();

    public LevelSections(float beginning)
    {

        sectionColor = colors[(int)(Math.random()*(colors.length-1))];
        sectionBeginning = beginning;

        //lets generate a level!
        Random r = new Random();
        sectionDistance = (r.nextFloat() * 4)+2f;

        platforms = makePlatforms(platforms);
    }

    public ArrayList<Platform> makePlatforms(ArrayList<Platform> c)
    {

        /*int numPlatforms = 10;
        if(c.size() >= numPlatforms)
        {
            return c;
        }
        if(c.size() == 0)
        {
            Platform temp = new Platform(sectionBeginning+0.1f,0.2f);
            c.add(temp);
        }
        if(c.size() < numPlatforms)
        {
            float oldx = c.get(c.size()-1).getX(),oldy=c.get(c.size()-1).getY();
            float rnd = (float)(Math.random());
            int i=0;
            while(i<rnd)
            {
                float rng = (float)(Math.random());
                float tR = rng * oldy + (float)0.1;
                Platform temp = new Platform(oldx+rng,oldy+tr);
                c.add(temp);

                i++;
            }

        }
        System.out.println("fuck");
      return makePlatforms(c);*/
        int num = (int)(sectionDistance/0.2f);
        int i = 0;
        float distance = 0.5f;
        while(i<num) {
            Platform t = new Platform(sectionBeginning+(i*distance), (float)Math.random()*0.15f*(i-1)+0.15f);
            c.add(t);
            i++;
        }
        return c;

    }

    public ArrayList<Platform> getFirstPlatform() {
        ArrayList<Platform> p = new ArrayList<Platform>();
        p.add(platforms.get(platforms.size()-1));
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
        t1.setBounds(((sectionBeginning)* GERGame.gWidth),0,(sectionDistance+0.1f)*GERGame.gWidth,GERGame.gHeight);
        t1.setColor(sectionColor);
        t1.draw(batch,0.75f);

        for(Platform p: platforms)
        {
            p.Draw(batch);
        }

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
