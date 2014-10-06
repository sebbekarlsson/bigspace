package nu.sebka.spacegame.main;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Sprite {

	public ArrayList<Texture> images = new ArrayList<Texture>();
	public int imageindex = 0;
	public float r = 0;
	public int depth = 1;
	public int width = 0;
	public int height = 0;

	public Texture getCurrentImage(){
		return images.get(imageindex);
	}


	public void draw(float x, float y,int width, int height){
		if(images.size() > 0){
			this.width = width;
			this.height = height;
			getCurrentImage().bind();









			GL11.glTranslatef(x, y, -depth);
			GL11.glPushMatrix();



			GL11.glRotatef(r, 0, 0, 1);
			GL11.glTranslatef(-width/2,-height/2, 0);

			GL11.glBegin(GL11.GL_QUADS);

			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(0, 0);
			GL11.glTexCoord2f(0, getCurrentImage().getHeight());
			GL11.glVertex2f(0, height);
			GL11.glTexCoord2f(getCurrentImage().getWidth(), getCurrentImage().getHeight());
			GL11.glVertex2f(width, height);
			GL11.glTexCoord2f(getCurrentImage().getWidth(), 0);
			GL11.glVertex2f(width, 0);



			GL11.glEnd();



			//GL11.glTranslatef(0, 0, 0);

			GL11.glPopMatrix();
			GL11.glTranslatef(-x, -y, depth);

		}




	}
}
