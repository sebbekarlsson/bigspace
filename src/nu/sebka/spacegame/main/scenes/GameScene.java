package nu.sebka.spacegame.main.scenes;

import nu.sebka.spacegame.main.Main;
import nu.sebka.spacegame.main.Scene;
import nu.sebka.spacegame.main.instances.entities.Player;


public abstract class GameScene extends Scene {

	public Player player;
	
	public GameScene(){
		player = new Player(0*4,0*2);
	}
	
	public void update(){
		getCamera().x = -player.x+Main.FRAMESIZE.width/4;
		getCamera().y = -player.y+Main.FRAMESIZE.height/4;
		tick();
		draw();
	}

	
	




}
