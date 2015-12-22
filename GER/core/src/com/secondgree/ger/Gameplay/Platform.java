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

    final static float length = 0.2f;//the actual amounts of screen
    private int lengthp = (int)(length*(GERGame.gWidth));


    public Platform(float x,float y)
    {
        this.x=x;this.y=y;
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
    public boolean holds(float x, float y) {

        //System.out.println("checking to see if "+Float.toString(x)+","+Float.toString(y)+" are in between "+Float.toString(this.x)+","+Float.toString(this.y));

        if(x >= (this.x-0.05f) && x<this.x+(length+0.05f))
        {
           // System.out.println("it is");
            if(this.y<y)
            {
               if( this.y+0.05f>y)
                {
                    c = Color.RED;

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
