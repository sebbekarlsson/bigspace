package nu.sebka.spacegame.main.instances.entities;

import java.util.Random;

import nu.sebka.spacegame.main.Entity;
import nu.sebka.spacegame.main.Instance;
import nu.sebka.spacegame.main.Main;
import nu.sebka.spacegame.main.Utili;
import nu.sebka.spacegame.main.instances.entities.particles.CometParticle;

import com.sun.prism.paint.Color;

public abstract class Ship extends Entity {

	private float protection = 1.5f;
	private float shootTimer = 0;
	Random random = new Random();

	public Ship(float x, float y) {
		super(x, y);
		setFriction(0.05f);
		setRotationFriction(0.1f);
	}

	public void update(){
		usePhysics();
		tick();
		draw();


		for(int i = 0; i < Main.getCurrentScene().getinstances().size(); i++){
			Instance instance = Main.getCurrentScene().getinstances().get(i);
			if(instance.isColliding(this) && instance != this){
				if(instance instanceof Comet){
					if(this instanceof EnemyShip){
						EnemyShip enemy = (EnemyShip) this;
						enemy.canMove = false;
					}
					Entity ent = (Entity) instance;
					addForce((float)ent.getDirection(),ent.getAcceleration()+ent.getAcceleration()/2,"both");
					addRotationForce(Utili.chooseInt(-1,-2,-3,-4,-5,1,2,3,4,5));
					
					for(int ii = 0; ii < 5; ii++){
						Main.getCurrentScene().instantiate(new CometParticle(x,y));
					}
				}
				else if(instance instanceof Bullet){
					Bullet bullet = (Bullet) instance;
					if(bullet.getOwner() != this){
						damage(bullet.getDamage());
						if(this instanceof EnemyShip){
							EnemyShip enemy = (EnemyShip) this;
							enemy.setAgro(enemy.getAgro()+1);
							if(enemy.getTarget() == null && enemy.getAgro() > enemy.getAgroLimit()){
								enemy.setTarget(bullet.getOwner());
							}
						}
						
						

						bullet.destroy();

					}

				}
			}
		}			



	}

	public float getProtection(){
		return protection;
	}

	public void setProtection(float protection){
		this.protection = protection;
	}

	public void damage(float damage){
		setHealth(getHealth() - (damage-getProtection()));
	}

	public void shoot(){

		if(shootTimer == 5){
			LaserBullet bullet = new LaserBullet(x,y,this);

			if(this instanceof EnemyShip){
				bullet.setColor(Color.RED);
			}

			bullet.setRotation(getRotation());
			bullet.setSpeed(bullet.getSpeed()+getAcceleration());
			Main.getCurrentScene().instantiate(bullet);
			shootTimer = 0;
		}

		if(shootTimer < 5){
			shootTimer += 1;
		}
	}


}
