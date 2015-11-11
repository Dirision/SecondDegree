package com.secondgree.ger.Gameplay;

import com.badlogic.gdx.Game;

/**
 * Created by david on 2015-11-11.
 */
public interface ScoreKeeperInterface extends GameComponent {

    public void addScore();
    public void getScore();

    public boolean isHighScore(int compareScore);



}
