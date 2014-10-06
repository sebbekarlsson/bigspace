package nu.sebka.spacegame.main.instances.entities.particles;



import com.sun.prism.paint.Color;

import nu.sebka.spacegame.main.instances.entities.Particle;

public class CometParticle extends Particle {

	float dir = random.nextInt(360);
	float speed = random.nextInt(10);
	public CometParticle(float x, float y) {
		super(x, y);
		setColor(new Color(0.5f,0.5f,0.5f,0.5f));
		setSize(random.nextInt(9)+1);
		setLifeTime(30);
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
