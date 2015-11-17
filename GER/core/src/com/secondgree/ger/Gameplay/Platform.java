package com.secondgree.ger.Gameplay;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.GERGame;
import com.secondgree.ger.T;



/**
 * Created by david on 2015-11-12.
 */
public class Platform implements GameplayComponent {

    private float x,y;
    Color c = Color.BLACK;

    private float length = 0.5f;//the actual amounts of screen
    private int lengthp = (int)(length*(GERGame.gWidth));


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
    public boolean holds(float x, float y) {

        if(y>=this.y&&y-0.03f<this.y)
        {

            if(x>=this.x)
            {
                if(x-this.x <length+0.1f)
                {

                    c=Color.RED;
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

        Sprite temp  = T.r.get(0);
        temp.setBounds(x * GERGame.gWidth, y * GERGame.gHeight, lengthp, 20);
        temp.setColor(c);
        temp.draw(batch);

        c= Color.BLACK;


    }

    @Override public int type()
    {
        return 1;
    }
}
