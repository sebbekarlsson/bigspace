package nu.sebka.spacegame.main.instances.entities;



import nu.sebka.spacegame.main.Instance;
import nu.sebka.spacegame.main.Main;
import nu.sebka.spacegame.main.TextureBank;
import nu.sebka.spacegame.main.instances.entities.particles.LaserParticle;

import org.lwjgl.opengl.GL11;

import com.sun.prism.paint.Color;



public class LaserBullet extends Bullet {

	private Color color = Color.GREEN;
	
	public LaserBullet(float x, float y, Instance owner) {
		super(x, y, owner);
		sprite.images.add(TextureBank.LASER_SMALL);
		setDamage(10);
	}

	
	
	public void draw(){
		GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
		sprite.draw(x, y, sprite.getCurrentImage().getImageWidth(), sprite.getCurrentImage().getImageHeight());
		GL11.glColor3f(1, 1, 1);
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}



	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onDestroy() {
		for(int i = 0; i < random.nextInt(10); i++){
			Main.getCurrentScene().instantiate(new LaserParticle(x,y,getColor()));
			
		}

		
	}



	@Override
	public void onCreation() {
		// TODO Auto-generated method stub
		
	}


}
