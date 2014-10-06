package nu.sebka.spacegame.main;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureBank {

	
	
	
	public static Texture TEST = loadTexture("png","images/spaceship.png");
	public static Texture LASER_SMALL = loadTexture("png","images/laser_small.png");
	public static Texture STARS_BACKGROUND = loadTexture("jpg","images/bgg.jpg");
	public static Texture  BACKGROUND_STAR = loadTexture("png","images/star.png");
	public static Texture COMET = loadTexture("png","images/rock.png");
	public static Texture PARTICLE_SQUARED = loadTexture("png","images/particle.png");
	public static TrueTypeFont FONT_SERIF = loadFont(Font.SERIF,12,12);
	
	
	public static Texture loadTexture(String format, String path){
		Texture t = null;
		try {
			t = TextureLoader.getTexture(format, new FileInputStream(path));
			
			
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);

			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return t;
	}
	
	public static TrueTypeFont loadFont(String fonttype, int w, int h){
		Font font = new Font(fonttype,w,h);
		
		TrueTypeFont tfont = new TrueTypeFont(font,false);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);

		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		
		return tfont;
	}
}
