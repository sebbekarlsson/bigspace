package nu.sebka.spacegame.main.instances.entities;

import nu.sebka.spacegame.main.TextureBank;

import org.lwjgl.input.Keyboard;

public class Player extends Ship {

	public float speed = 3f;
	public Player(float x, float y) {
		super(x, y);
		sprite.images.add(TextureBank.TEST);
		
		
	}

	@Override
	public void tick() {

		
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
				if(getRotationAcceleration() > -5)
				addRotationForce(-1);
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			if(getRotationAcceleration() < 5)
				addRotationForce(1);
		}

		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			float  travelSpeed = speed-getAcceleration();
			if(travelSpeed < 0){
				travelSpeed = 0;
			}
			addForce(getRotation(),travelSpeed,"both");

		}

		if(Keyboard.isKeyDown(Keyboard.KEY_X)){
			shoot();
		}
		

	}
	
	public void draw(){
		sprite.draw(x, y, sprite.getCurrentImage().getImageWidth(), sprite.getCurrentImage().getImageHeight());
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
