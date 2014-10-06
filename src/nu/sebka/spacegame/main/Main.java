package nu.sebka.spacegame.main;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import nu.sebka.spacegame.main.scenes.SpaceScene;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


public class Main {

	private static int WIDTH = 640;
	private static int HEIGHT = WIDTH / 16 * 9;
	private static int SCALE = 2;
	public static Dimension FRAMESIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);

	private static ArrayList<Scene> scenes = new ArrayList<Scene>();
	private static int sceneIndex = 0;

	static Socket socket;
	static BufferedReader input;
	public static PrintWriter output;
	Sprite sprite = new Sprite();


	public static void main(String[] args){

		new InstanceViewer();
		new Main();

	}

	public Main(){

		try {
			Display.setDisplayMode(new DisplayMode(FRAMESIZE.width, FRAMESIZE.height));
			Display.setTitle("TestGame");
			Display.create();




			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable (GL11.GL_BLEND);
			GL11.glAlphaFunc(GL11.GL_GREATER, (float) 0.5);
			GL11.glEnable(GL11.GL_ALPHA_TEST);
			GL11.glBlendFunc (GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glEnable(GL11.GL_DEPTH_TEST);

			GL11.glDepthFunc(GL11.GL_LEQUAL);
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();



			GL11.glOrtho(0, Display.getWidth()/2, Display.getHeight()/2, 0, -1, 20);
			scenes.add(new SpaceScene());


			while(!Display.isCloseRequested()){
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
				GL11.glMatrixMode(GL11.GL_MODELVIEW);
				GL11.glClearColor(getCurrentScene().getBackgroundColor().getRed(), getCurrentScene().getBackgroundColor().getGreen(), getCurrentScene().getBackgroundColor().getBlue(), 1);



				GL11.glColor3f(100, 100, 100);
				sprite = Main.getCurrentScene().getBackgroundSprite();
				if(sprite != null){
					sprite.depth = 20;
					sprite.draw(0,0, Main.FRAMESIZE.width, Main.FRAMESIZE.height);
				}
				GL11.glLoadIdentity();



				GL11.glPushMatrix();






				GL11.glTranslatef(getCurrentScene().getCamera().x, getCurrentScene().getCamera().y, 0);




				GL11.glPushMatrix();
				update();
				GL11.glPopMatrix();


				GL11.glTranslatef(-getCurrentScene().getCamera().x, -getCurrentScene().getCamera().y, 0);



				GL11.glPopMatrix();

				getCurrentScene().drawGUI();




				Display.sync(60);
				Display.update();
			}


			System.exit(0);


		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(){
		if(!getCurrentScene().hasBeenLoaded()){
			getCurrentScene().load();
			getCurrentScene().setLoaded(true);
		}else{
			getCurrentScene().update();
		}
		for(int i = 0; i < getCurrentScene().getinstances().size(); i++){
			Instance instance = getCurrentScene().getinstances().get(i);
			if(!instance.isOutsideView()){
				instance.update();
			}else{
				instance.tick();
			}
		}
	}

	public static Scene getCurrentScene(){
		return scenes.get(sceneIndex);
	}

	public void gotoNextScene(){
		sceneIndex += 1;
	}

	public void gotoPreviousScene(){
		sceneIndex -= 1;
	}

	public int getSceneIndex(){
		return sceneIndex;
	}

	public void setSceneIndex(int index){
		sceneIndex = index;
	}





}
