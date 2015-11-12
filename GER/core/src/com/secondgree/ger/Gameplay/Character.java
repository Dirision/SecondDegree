package com.secondgree.ger.Gameplay;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.GERGame;
import com.secondgree.ger.T;

/**
 * Created by david on 2015-11-11.
 */
public class Character implements GameplayComponent {

    private float x,y;

    private float currentGravity = 0;
    private float gravity = 4.9f;
    private float gravityMin = 3;

    //jumping mechanics
    //private boolean inThe
    private boolean inTheAir=true;

    public Character()
    {
        this.x = 0f;
        this.y = 1f;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public int type() {
        return 2;
    }

    @Override
    public boolean holds(int x, int y) {
        return false;
    }


    public void Update(GameplayComponent[] d)//this must take in an array of all the collideables!!!!!!
    {

        if(Gdx.input.isTouched())
        {
            jump();
        }
       for (GameplayComponent thing: d)
       {
           if(thing.type()==1)
           {
               //walls
           }
       }
        if(y<=0.10f)
        {
            ground();
        }
        if(inTheAir)
        {
            currentGravity+=0.005f;
            y-=currentGravity;

        }
    }
    private void ground()
    {
        inTheAir=false;
        currentGravity=0;
        y=0.1f;
    }
    private void jump()
    {
        y+=0.05f;
        inTheAir=true;
        currentGravity=-0.05f;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(SpriteBatch batch)
    {
        T.dude.setPosition(x*GERGame.gWidth,y*GERGame.gHeight);

        T.dude.draw(batch);
    }
}
