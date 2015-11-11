package com.secondgree.ger;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by david on 2015-11-11.
 */
public class T
{
    public static Sprite dude;

    public static void load()
    {
        dude = new Sprite(new Texture("dude.png"));
        dude.setCenter(20,15);
    }

}
