package com.secondgree.ger.Gameplay;

/**
 * Created by david on 2015-11-11.
 */
public interface GameplayComponent extends GameComponent {

    public float getX();
    public float getY();
    public int type();

    public boolean holds(int x, int y);


}
