/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 *
 * @author pablo1107
 */
public class MainMenuScreen implements Screen {
  
  private final Drop game;
  
  private OrthographicCamera camera;
  
  public MainMenuScreen(final Drop game) {
    this.game = game;
    
    camera = new OrthographicCamera(800, 480);
    camera.setToOrtho(false, 800, 480);
}

  @Override
  public void show() {
  }

  @Override
  public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0.2f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    
    camera.update();
    game.batch.setProjectionMatrix(camera.combined);
    
    game.batch.begin();
    game.font.draw(game.batch, "Drop: The Game", 100, 150);
    game.font.draw(game.batch, "Apreta en cualquier lugar para comenzar.", 100, 100);
    game.batch.end();
    
    if(Gdx.input.isTouched()) {
      game.setScreen(new GameScreen(game));
      dispose();
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
  }
}
