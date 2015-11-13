package com.secondgree.ger;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.TreeMap;

/**
 * Created by david on 2015-11-11.
 */
public class T
{
    public static TreeMap<Integer,Sprite> r=new TreeMap<Integer, Sprite>();



    public static void load()
    {
        Sprite temp = new Sprite(new Texture("dude.png"));
        temp.setCenter(20,15);
        r.put(1,temp);

        temp = new Sprite(new Texture("base.png"));
        r.put(0,temp);



    }

}
