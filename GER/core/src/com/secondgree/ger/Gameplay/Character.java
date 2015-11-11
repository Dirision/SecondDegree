package com.secondgree.ger.Gameplay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.GERGame;
import com.secondgree.ger.T;

/**
 * Created by david on 2015-11-11.
 */
public class Character implements GameplayComponent {

    private float x,y;

    private float speed;
    private float gravity = 4.9f;
    private float gravityMin = 3;

    //jumping mechanics
    //private boolean inThe

    public Character()
    {
        this.x = -0.5f;
        this.y = -0.3f;
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
    public boolean holds(int x, int y) {
        return false;
    }

    @Override
    public void Update()
    {

    }

    @Override
    public void Draw(SpriteBatch batch)
    {
        //T.dude.setPosition(x* GERGame.gWidth,y*GERGame.gWidth);
        T.dude.draw(batch);
    }
}
