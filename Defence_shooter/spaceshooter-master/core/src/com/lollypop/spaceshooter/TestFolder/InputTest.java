package com.mygdx.project4;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class InputTest extends ScreenAdapter {
    ShapeRenderer renderer;
    ExtendViewport viewport;
    public static final float WORLD_SIZE = 480.0f;
    BouncingBall ball;


    @Override
    public void show() {
        renderer = new ShapeRenderer();
        renderer.setAutoShapeType(true);
        viewport = new ExtendViewport(WORLD_SIZE,WORLD_SIZE);
        ball = new BouncingBall(viewport);

    }

    @Override
    public void render(float delta) {
        viewport.apply();
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setProjectionMatrix(viewport.getCamera().combined);
        ball.update(delta,viewport);

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        ball.render(renderer);
        renderer.end();



    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
        ball.init(viewport);
    }



    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void dispose() {
        renderer.dispose();
    }



}
