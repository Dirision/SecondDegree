package com.secondgree.ger;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.Gameplay.GameComponent;
import com.secondgree.ger.Gameplay.GameStage;

import java.util.ArrayList;


/**
 * An amazing endless runner, written together by David Zolnieryk, and Nick DiRiso
 * GER = Generic Endless Runner
 *
 *
 */
public class GERGame extends ApplicationAdapter
{
	private SpriteBatch batch;
	private OrthographicCamera cam;

    public static int gHeight,gWidth;

    public static ArrayList<GameComponent> game = new ArrayList<GameComponent>();


    //go ahead and run the project ;'D

	@Override
	public void create () {

        //This call includes graphic setup, as well as game logic setup.
		Initalization();

	}

    private void Initalization()
    {
        EngineSetup();

        LogicSetup();
    }

    private void EngineSetup()
    {
        //First, all the graphic stuff.

        //This is all the camera stuff. This will set the camera to a 2d view of the entire
        //resolution of the screen
        gWidth = Gdx.graphics.getWidth();
        gHeight = Gdx.graphics.getHeight();

        cam = new OrthographicCamera(gWidth,gHeight);
        batch = new SpriteBatch();
        batch.setProjectionMatrix(cam.combined);

        T.load();

    }
    private void LogicSetup()
    {
        GameStage stage = new GameStage();
        game.add(stage);
    }

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

        for(GameComponent thing:game)
        {
            thing.Update();
            thing.Draw(batch);
        }


		batch.end();
	}
}
