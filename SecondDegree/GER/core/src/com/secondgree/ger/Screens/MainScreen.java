package com.secondgree.ger.Screens;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.secondgree.ger.T;
import com.secondgree.ger.Gameplay.GameComponent;
import com.secondgree.ger.Gameplay.GameStage;

public class MainScreen implements Screen{

	private SpriteBatch batch;
	private OrthographicCamera cam;

    public static int gHeight,gWidth;

    public static ArrayList<GameComponent> game = new ArrayList<GameComponent>();


    //go ahead and run the project ;'D

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

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
