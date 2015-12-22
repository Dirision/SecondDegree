package com.secondgree.ger.Gameplay;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.GERGame;
import com.secondgree.ger.T;

import java.util.ArrayList;

/**
 * Created by david on 2015-11-11.
 */
public class Character implements GameplayComponent {

    private float x,y,oldy;

    private float currentGravity = 0;
    private float gravity = 4.9f;
    private float gravityMin = 3;

    private boolean previousState=false;
    private boolean currentState=false;

    private boolean touching=true;//is ON a platform;

    //jumping mechanics

    private boolean inTheAir=true;

    public Character(float x,float y)
    {
        this.x = x;
        this.y = y;
        oldy=0;
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
        if(this.x > x-0.01f && this.x < x+Platform.length)
        {
            return true;
            /**
            if(this.y>y &&this.y<y+0.05f)
            {
                return true;
            }
             */
        }
        return false;
    }


    public void Update(float x)
    {
        System.out.print(touching);
        this.x = x;

        checkControls();

        y-=currentGravity;

        if(y<0.001f)
        {
            ground();
        }

        if(touching)
        {
            currentGravity=0;
        }
        else
        {
            currentGravity+=0.001f;
        }

    }
    public void doCollision(ArrayList<GameplayComponent> f)
    {
        for(GameplayComponent g :f)
        {
            if(g.type()==1)
            {
                if(g.holds(this.x,this.y)||this.y<0.01f)
                {
                    touching = true;
                    return;
                }
            }
        }
        touching = false;
    }
    private void checkControls()
    {
        previousState = currentState;

        currentState = Gdx.input.isTouched();

        if(currentState&&touching)
        {

            jump();
        }
    }

    private void ground()
    {
        touching = true;
        currentGravity=0;
        y=0.0f;
    }

    private void jump()//Internal usage only
    {
        y+=0.03f;
        touching = false;
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
