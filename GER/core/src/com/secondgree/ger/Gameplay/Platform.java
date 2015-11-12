package com.secondgree.ger.Gameplay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by david on 2015-11-12.
 */
public class Platform implements GameplayComponent {

    private float x,y;

    public float length=0.3f;

    public Platform(float x,float y)
    {
        this.x=x;this.y=y;
    }

    @Override
    public float getX() {
        return 0;
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public boolean holds(int x, int y) {

        if(y>=this.y)
        {
            if(x>=this.x)
            {
                if(x-this.x <=length)
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(SpriteBatch batch) {

    }

    @Override public int type()
    {
        return 1;
    }
}
