package nu.sebka.spacegame.main.instances.entities;



import java.util.Random;

import nu.sebka.spacegame.main.Entity;
import nu.sebka.spacegame.main.Instance;

public abstract class Bullet extends Entity{

	private float damage = 1;
	Random random = new Random();
	private Instance owner;
	
	public Bullet(float x, float y, Instance owner) {
		super(x, y);
		setSpeed(10);
		setDepth(2);
		this.owner = owner;
	}
	
	
	public void update(){
		usePhysics();
		tick();
		draw();
		setForce(getRotation(),getSpeed(),"both");
		if(isOutsideView()){
			destroy();
		}
		
	}
	
	public float getDamage(){
		return damage;
	}
	
	public void setDamage(float damage){
		this.damage = damage;
	}
	
	public void setOwner(Instance instance){
		owner = instance;
	}
	
	public Instance getOwner(){
		return owner;
	}
	

	

}
