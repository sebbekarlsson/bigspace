package nu.sebka.spacegame.main.scenes;

import nu.sebka.spacegame.main.Main;
import nu.sebka.spacegame.main.TextureBank;
import nu.sebka.spacegame.main.Utili;
import nu.sebka.spacegame.main.instances.entities.BackgroundStar;
import nu.sebka.spacegame.main.instances.entities.Comet;
import nu.sebka.spacegame.main.instances.entities.EnemyShip;

import com.sun.prism.paint.Color;

public class SpaceScene extends GameScene {




	public boolean meteorShower = false;

	@Override
	public void load() {
		setBackgroundColor(Color.BLACK);
		instantiate(player);

	}

	@Override
	public void tick(){

		if(random.nextInt(3) == 0){
			instantiate(new BackgroundStar(player.x + random.nextInt(Main.FRAMESIZE.width/2)*Utili.chooseInt(-1,1), player.y + random.nextInt(Main.FRAMESIZE.height/2)*Utili.chooseInt(-1,1)));
		}
		
		if(random.nextInt(360) == 0){
			instantiate(new EnemyShip(player.x + random.nextInt(Main.FRAMESIZE.width/2)*Utili.chooseInt(-1,1), player.y + random.nextInt(Main.FRAMESIZE.height/2)*Utili.chooseInt(-1,1)));
		}

		if(meteorShower == true){
			if(random.nextInt(16) == 0){
				instantiate(new Comet(player.x + random.nextInt(Main.FRAMESIZE.width/2)*Utili.chooseInt(-1,1), player.y + random.nextInt(Main.FRAMESIZE.height/2)*Utili.chooseInt(-1,1)));
			}
		}
		
		if(random.nextInt(1000) == 0){
			meteorShower = random.nextBoolean();
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}


	@Override
	public void drawGUI() {
		if(meteorShower){
			TextureBank.FONT_SERIF.drawString(10, 10, "Meteorshower");
		}

	}

}
