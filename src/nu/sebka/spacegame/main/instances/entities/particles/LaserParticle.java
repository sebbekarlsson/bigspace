package nu.sebka.spacegame.main.instances.entities.particles;

import nu.sebka.spacegame.main.instances.entities.Particle;

import com.sun.prism.paint.Color;

public class LaserParticle extends Particle {

	float dir = random.nextInt(360);
	float speed = random.nextInt(10);
	public LaserParticle(float x, float y,Color color) {
		super(x, y);
		setColor(Color.GREEN);
		setSize(2);
		setLifeTime(20);
		setColor(color);
	}

	@Override
	public void tick() {
		setForce(dir,speed,"both");
		
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
