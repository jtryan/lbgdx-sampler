package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;

public class ApplicationListenerSample implements ApplicationListener {

	private static final Logger log = new Logger(ApplicationListenerSample.class.getName(), Logger.DEBUG);
	private boolean renderInterrupted = true;

	@Override
	public void create() {
		//used to initialize game and load resources
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		log.debug("create()");

	}

	@Override
	public void resize(int width, int height) {
		//used to handle setting a new screen size
		log.debug("resize() width= " + width + " height= " + height);

	}

	@Override
	public void render() {
		//used to update and render game elements called 60 times /sec
		if(renderInterrupted) {
			log.debug("render()");
			renderInterrupted = false;
		}

	}

	@Override
	public void pause() {
		// used to save games state when it loses focus, which doesn't involve the acutal
		// game play being paused unless the developer wants it to pause
		log.debug("pause()");
		renderInterrupted = true;

	}

	@Override
	public void resume() {
		// used ot handle the game coming back from being paused and retires game state
		log.debug("resume()");
		renderInterrupted = true;
	}

	@Override
	public void dispose() {
		// free resources and clean up
		log.debug("dispose()");

	}
}
