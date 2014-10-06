package nu.sebka.spacegame.main.instances.entities;

import java.util.Random;

import nu.sebka.spacegame.main.Entity;
import nu.sebka.spacegame.main.TextureBank;

import org.lwjgl.opengl.GL11;

import com.sun.prism.paint.Color;

public abstract class Particle extends Entity {

	private Color color = Color.RED;
	private int lifeTime = 100;
	protected Random random = new Random();
	private int size = 4;
	
	public Particle(float x, float y) {
		super(x, y);
		sprite.images.add(TextureBank.PARTICLE_SQUARED);
		setDepth(2);
	}

	public void update(){
		
		if(lifeTime > 0){
			lifeTime -= 1;
		}else{
			destroy();
		}
		
		if(isOutsideView()){
			destroy();
		}
		
		usePhysics();
		tick();
		draw();
	}
	
	public void draw(){
		GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
		sprite.draw(x, y, size, size);
		GL11.glColor3f(1,1,1);
	}
	
	
	
	public void drawSquare(float width, float height){
		
		GL11.glTranslatef(x, y, -getDepth());
		GL11.glColor3f(color.getRed(), color.getGreen(), color.getBlue());
		GL11.glPushMatrix();
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(0, height);
		GL11.glVertex2f(width, height);
		GL11.glVertex2f(width, 0);
		
		
		GL11.glEnd();
		GL11.glPopMatrix();
		GL11.glColor3f(1, 1, 1);
		GL11.glTranslatef(-x, -y, getDepth());
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	public Color getColor(){
		return color;
	}

	public void setLifeTime(int lifeTime){
		this.lifeTime = lifeTime;
	}
	
	public int getLifeTime(){
		return lifeTime;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public int getSize(){
		return size;
	}

}
