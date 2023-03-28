package org.bcit.comp2522.project;

public class Level_1 extends Level{
  Window window;

  int timeRegularEnemy;
  int timeFastEnemy;
  int timeBossEnemy;
  public Level_1(Window window){
    super(window);
    this.window = window;
    init();
  }

  public void init(){
    timeBossEnemy = 0;
    timeFastEnemy = 0;
    timeRegularEnemy = 0;
    getPath().clearCorner();
    getPath().addCorner(40, 432);
    getPath().addCorner(328, 432);
    getPath().connectCorners();
  }

  public void draw(){
    window.background(0);
    getPath().draw();
    if (window.enemies.size() > 0) {
      window.testBullet.move();
    }
    window.testBullet.draw();

    // Update the timer
    timeRegularEnemy++;
    timeFastEnemy++;
    timeBossEnemy++;

    // Check if it's time to spawn a new regular enemy
    if (timeRegularEnemy >= 300) { // 300 frames = 5 seconds
      timeRegularEnemy = 0;
      window.enemies.add(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 2, 2, 2, 50, this));
    }

    // Check if it's time to spawn a new fast enemy
    if (timeFastEnemy >= 600) { // 600 frames = 10 seconds
      timeFastEnemy = 0;
      window.enemies.add(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 1, 4, 4,35, this));
    }

    // Check if it's time to spawn a new boss enemy
    if (timeBossEnemy >= 900) { // 900 frames = 15 seconds
      timeBossEnemy = 0;
      window.enemies.add(new Enemy(getPath().getHead().getXpos(), getPath().getHead().getYpos(), window, 4, 1, 1, 75, this));
    }

    // Update and draw the enemies
    for (Enemy enemy : window.enemies) {
      enemy.move();
      enemy.draw();
//      if (enemy.collide(testBullet)){
//        System.out.println("Hits");
//      }
    }
    window.grid.draw();

  }
}
