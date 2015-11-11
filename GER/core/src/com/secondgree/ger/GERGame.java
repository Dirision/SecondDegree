package com.secondgree.ger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.Gameplay.GameComponent;
import com.secondgree.ger.Gameplay.GameStage;
import com.secondgree.ger.Screens.MainScreen;

import java.util.ArrayList;


/**
 * An amazing endless runner, written together by David Zolnieryk, and Nick DiRiso
 * GER = Generic Endless Runner
 *
 *
 */
public class GERGame extends Game
{
	MainScreen mainScreen;
	@Override
	public void create() {
		mainScreen = new MainScreen(this);
		setScreen(mainScreen);
	}

}
