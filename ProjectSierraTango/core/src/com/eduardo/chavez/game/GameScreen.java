package com.eduardo.chavez.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Timer;

import java.sql.Time;


/**
 * Created by usuario on 19/8/17.
 */

class GameScreen implements Screen {
    final GameLoader game;


    //Carga de personaje
    private TextureAtlas textureAtlas;
    private Sprite sprite;
    private int currentFrame = 1;
    private String currentAtlasKey = new String("IDLE000");


    //
    //OrthographicCamera camera;

    public GameScreen(GameLoader gameLoader) {
        this.game = gameLoader;

        //camera = new OrthographicCamera();
        //camera.setToOrtho(false, 800, 480);

        textureAtlas = new TextureAtlas(Gdx.files.internal("spritesheet .atlas"));
        TextureAtlas.AtlasRegion region = textureAtlas.findRegion("IDLE000");
        sprite = new Sprite(region);
        sprite.setPosition(120, 100);
        sprite.scale(0.05f);


    }

    private void moveAnimation() {
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                currentFrame++;
                if (currentFrame > 20) currentFrame = 1;

                currentAtlasKey = "IDLE" + String.format("%03d", currentFrame);
                sprite.setRegion(textureAtlas.findRegion(currentAtlasKey));
            }
        }, 0, 1 / 30.0f);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //camera.update();
        //game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        sprite.draw(game.batch);


        game.batch.end();

        if (Gdx.input.isTouched()){
            moveAnimation();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        textureAtlas.dispose();
    }
}
