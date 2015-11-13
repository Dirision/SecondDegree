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
        house = new Level();
    }

    @Override
    public void Update() {

        house.Update();
        dude.Update(house.getReleventObjects(),house.currentDistance);

    }

    @Override
    public void Draw(SpriteBatch batch) {

        house.Draw(batch);
        dude.Draw(batch);

    }
}
