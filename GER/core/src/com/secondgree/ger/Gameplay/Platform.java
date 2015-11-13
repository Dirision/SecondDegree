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

    public float length=100f;

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

        if(y>=this.y&&y-0.01f<this.y)
        {
            System.out.println("vertically correct");
            if(x>=this.x)
            {
                if(Math.abs(this.x-x) >0.00001f)
                {
                    System.out.println("horizontally correct");
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
        temp.setBounds(x * GERGame.gWidth, y * GERGame.gHeight, 100, 20);
        temp.setColor(c);
        temp.draw(batch);


    }

    @Override public int type()
    {
        return 1;
    }
}
