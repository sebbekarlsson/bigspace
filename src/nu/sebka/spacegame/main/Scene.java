package nu.sebka.spacegame.main;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import com.sun.prism.paint.Color;

public abstract class Scene {

	private int width = Main.FRAMESIZE.width;
	private int height = Main.FRAMESIZE.height;
	private boolean loaded = false;

	private ArrayList<Instance> instances = new ArrayList<Instance>();
	
	private Camera camera = new Camera();
	protected Random random = new Random();
	private Color bgColor = Color.BLACK;
	private Sprite backgroundSprite = new Sprite();

	public abstract void load();

	public void update(){

		tick();
		draw();

	}


	public abstract void tick();
	public abstract void draw();
	//public abstract void drawBackground();
	public abstract void drawGUI();

	public ArrayList<Instance> getinstances(){
		return instances;
	}

	public void instantiate(Instance instance){
	
		//InstanceViewer.templist.add(instance);
		instance.onCreation();
		instances.add(instance);
	}

	public void destroy(Instance instance){
		instance.onDestroy();
		instances.remove(instance);
	}

	public boolean hasBeenLoaded(){
		return loaded;
	}
	
	public void setLoaded(boolean loaded){
		this.loaded = loaded;
	}
	
	public Camera getCamera(){
		return this.camera;
	}
	
	public Color getBackgroundColor(){
		return bgColor;
	}
	
	public void setBackgroundColor(Color color){
		bgColor = color;
	}
	
	public Dimension getSceneSize(){
		return new Dimension(width,height);
	}
	
	public void setSceneSize(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public float getDistance(Instance instance, Instance instance2){
		float distance = (float) Math.sqrt((instance.x-instance2.x)*(instance.x-instance2.x) + (instance.y-instance2.y)*(instance.y-instance2.y));
		return distance;
	}
	
	public float getDistance(float x1, float y1, float x2, float y2){
		float distance = (float) Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		return distance;
		
	}
	
	public Sprite getBackgroundSprite(){
		return backgroundSprite;
	}
	
	public void setBackgroundSprite(Sprite sprite){
		this.backgroundSprite = sprite;
	}

}
