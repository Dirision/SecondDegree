package com.secondgree.ger.Gameplay;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
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

    private boolean touched=false;

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
    public boolean holds(float x, float y) {
        return false;
    }


    public void Update(GameplayComponent[] d,float x)//this must take in an array of all the collideables!!!!!!
    {


        GERGame.cam.translate(((x - this.x)) * GERGame.gWidth, 0);
        GERGame.cam.update();
        this.x = x;
        if (!inTheAir) {
            touched = false;
        }

        if (Gdx.input.isTouched() && !touched) {
            jump();
            touched = true;
        }
        boolean temp = true;
        for (GameplayComponent l : d) {
            if (l.type() == 1) {

                if (l.holds(this.x, this.y)) {
                    temp = false;

                }
            }
        }
        if(!inTheAir)
        {
            if(temp)
            {
                inTheAir=true;
            }
        }
        else
        {
            if(!temp)
            {
                inTheAir=false;
                currentGravity=0;
                System.out.println("platofmrd");
            }
        }

            if (y <= 0.10f) {
                ground();
            }

            if (inTheAir) {
                currentGravity += 0.001f;
                y -= currentGravity;

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
        y+=0.005f;
        inTheAir=true;
        currentGravity=-0.025f;
    }

    @Override
    public void Update() {

    }

    @Override
    public void Draw(SpriteBatch batch)
    {


        batch.setProjectionMatrix(GERGame.cam.combined);
        Sprite t1 = T.r.get(0);
        t1.setBounds(50,50,200,200);
        t1.setColor(Color.RED);
        t1.draw(batch);

        Sprite temp = T.r.get(1);
        temp.setPosition(x*GERGame.gWidth,y*GERGame.gHeight);
        temp.draw(batch);


    }
}
