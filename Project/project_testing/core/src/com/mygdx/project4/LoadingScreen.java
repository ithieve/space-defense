package com.mygdx.project4;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class LoadingScreen implements Screen {
    ShapeRenderer shapeRenderer;
    OrthographicCamera camera;
    Viewport viewport;
    public static final float WORLD_HEIGHT = 9;
    public static final float WORLD_WIDTH = 16;

    StickMan man = new StickMan(130,210);

    /**
     * Called when this screen becomes the current screen for a {@link Game}.
     */
    @Override
    public void show() {
        shapeRenderer = new ShapeRenderer();
        camera = new OrthographicCamera();
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
        //Clear screen
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //screen size is set to 640 480
        viewport = new FitViewport(WORLD_WIDTH,WORLD_HEIGHT,camera);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);


        man.draw(shapeRenderer);


        shapeRenderer.end();
        man.move(delta*20,delta*10);

    }

    /**
     * @param width
     * @param height
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false,width,height);
        camera.position.set((float)(width/2),(float)height/2,0f );
        camera.viewportHeight = height;
        camera.viewportWidth= camera.viewportHeight * (1.0f * width/height);

    }

    /**
     * @see ApplicationListener#pause()
     */
    @Override
    public void pause() {
        // TODO Autogenerated method
    }

    /**
     * @see ApplicationListener#resume()
     */
    @Override
    public void resume() {
        // TODO Autogenerated method
    }

    /**
     * Called when this screen is no longer the current screen for a {@link Game}.
     */
    @Override
    public void hide() {
        // TODO Autogenerated method
    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        shapeRenderer.dispose();

    }
}
