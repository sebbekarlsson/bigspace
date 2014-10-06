package nu.sebka.spacegame.main.instances.entities;

import java.util.Random;

import nu.sebka.spacegame.main.Entity;
import nu.sebka.spacegame.main.Instance;
import nu.sebka.spacegame.main.Main;
import nu.sebka.spacegame.main.TextureBank;
import nu.sebka.spacegame.main.instances.entities.particles.CometParticle;

public class Comet extends Entity {

	Random random = new Random();
	float dir = 0;
	float rotforce = 0;
	private int size = 64;

	public Comet(float x, float y) {
		super(x, y);
		sprite.images.add(TextureBank.COMET);

		setSpeed(random.nextInt(5)+1);
		dir = random.nextInt(360);
		rotforce = random.nextInt(10);

	}

	@Override
	public void tick() {
		setRotationForce(rotforce);
		setForce(dir,getSpeed(),"both"); 
		if(isOutsideView()){
			destroy();
		}

		if(getHealth() < 1){
			destroy();
		}

		for(int i = 0; i < Main.getCurrentScene().getinstances().size(); i++){
			Instance instance = Main.getCurrentScene().getinstances().get(i);
			if(instance instanceof Bullet){
				if(instance.isColliding(this)){
					for(int ii = 0; ii < random.nextInt(10); ii++){
						Main.getCurrentScene().instantiate(new CometParticle(x,y));
					}
					setHealth(getHealth()-50);
					instance.destroy();
				}
			}
		}

	}

	public void draw(){
		sprite.draw(x, y, size, size);
	}

	@Override
	public void onDestroy() {
		if(!isOutsideView()){
			for(int i = 0; i < random.nextInt(40); i++){
				Main.getCurrentScene().instantiate(new CometParticle(x,y));
			}


			for(int i = 0; i < random.nextInt(5); i++){
				Comet comet = new Comet(x,y);
				comet.setSize(getSize()-random.nextInt(getSize()/2));
				Main.getCurrentScene().instantiate(comet);
			}

		}

	}

	@Override
	public void onCreation() {
		// TODO Auto-generated method stub

	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

}
