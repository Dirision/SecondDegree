package com.secondgree.ger.Gameplay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by david on 2015-11-11.
 *
 * The purpose of this class is to house the actual level, and everything that interacts with it.
 *
 */
public class GameStage implements GameComponent {

    Character dude;
    Level house;



    public GameStage()
    {
        dude = new Character();
    }

    @Override
    public void Update() {

        dude.Update();

    }

    @Override
    public void Draw(SpriteBatch batch) {

        dude.Draw(batch);

    }
}
