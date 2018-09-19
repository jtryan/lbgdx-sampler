package com.sampler;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sampler.utils.GdxUtils;

public class InputListeningSample implements ApplicationListener, InputProcessor {

    private static final Logger log = new Logger(InputListeningSample.class.getName(), Logger.DEBUG);
    private static final int MAX_MESSAGE_COUNT = 15;
    private static final Array<String> messages = new Array<String>();

    private OrthographicCamera camera;
    private Viewport viewport;
    private SpriteBatch batch;
    private BitmapFont font;


    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);

        camera = new OrthographicCamera();
        viewport = new FitViewport(1080, 720, camera);
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal("fonts/oswald-32.fnt"));

//        InputMultiplexer multiplexer = new InputMultiplexer();
//
//        InputAdapter firstProcessor = new InputAdapter() {
//            @Override
//            public boolean keyDown(int keycode) {
//                log.debug("first - keyDown keyCode= " + keycode);
//                return true;
//            }
//
//            @Override
//            public boolean keyUp(int keycode) {
//                log.debug("first - keyUp keyCode= " + keycode);
//                return false;
//            }
//
//            @Override
//            public boolean keyTyped(char character) {
//                log.debug("first - keyTyped character= " + character);
//                return false;
//            }
//        };
//
//        InputAdapter secondProcessor = new InputAdapter() {
//            @Override
//            public boolean keyDown(int keycode) {
//                log.debug("second - keyDown keyCode= " + keycode);
//                return true;
//            }
//
//            @Override
//            public boolean keyUp(int keycode) {
//                log.debug("second - keyUp keyCode= " + keycode);
//                return true;
//            }
//
//            @Override
//            public boolean keyTyped(char character) {
//                log.debug("second - keyTyped character= " + character);
//                return false;
//            }
//        };

//        multiplexer.addProcessor(firstProcessor);
//        multiplexer.addProcessor(secondProcessor);
//
//        Gdx.input.setInputProcessor(multiplexer);


        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);

    }

    @Override
    public void render() {
        GdxUtils.clearScreen();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        draw();

        batch.end();

    }

    private void draw() {
        for (int i = 0; i < messages.size; i++) {
            font.draw(
                    batch,
                    messages.get(i),
                    20.f,
                    720 - (40.0f * (i + 1))
            );
        }
    }

    private void addMessage(String message) {
        messages.add(message);

        if (messages.size > MAX_MESSAGE_COUNT) {
            messages.removeIndex(0);
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        String message = "keyDown keycode= " + keycode;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        String message = "keyUp keycode= " + keycode;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        String message = "keyTyped keycode= " + character;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        String message = "touchDown screenX= " + screenX + " screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        String message = "touchUp screenX= " + screenX + " screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        String message = "touchDragged screenX= " + screenX + " screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        String message = "mouseMoved screenX= " + screenX + " screenY= " + screenY;
        log.debug(message);
        addMessage(message);
        return true;
    }

    @Override
    public boolean scrolled(int amount) {
        String message = "scrolled amount= " + amount;
        log.debug(message);
        addMessage(message);
        return true;
    }
}
