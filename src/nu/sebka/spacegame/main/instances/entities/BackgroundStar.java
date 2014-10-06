package nu.sebka.spacegame.main.instances.entities;

import java.util.Random;
import nu.sebka.spacegame.main.Entity;
import nu.sebka.spacegame.main.Main;
import nu.sebka.spacegame.main.TextureBank;

public class BackgroundStar extends Entity{

	Random random = new Random();
	float direction = 0;
	int size = 4;


	public BackgroundStar(float x, float y) {
		super(x, y);
		sprite.images.add(TextureBank.BACKGROUND_STAR);
		direction = random.nextInt(360);
		setSpeed(random.nextFloat()-0.1f);
		setDepth(19);
		size = random.nextInt(4);
	}

	public void draw(){
		sprite.draw(x, y, size, size);
	}

	@Override
	public void tick() {
		addForce(direction,getSpeed(),"both");
		if(random.nextInt(100) == 0){
			setSpeed(getSpeed()-0.1f);
		}
		if(random.nextInt(200) == 0){
			setSpeed(getSpeed()+0.1f);
		}

		if(random.nextInt(5000) == 0){
			Main.getCurrentScene().destroy(this);
		}
		
		if(isOutsideView()){
			this.destroy();
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreation() {
		// TODO Auto-generated method stub
		
	}

}
