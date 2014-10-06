package nu.sebka.spacegame.main;

public class StaticImage {
	
	float x = 0, y = 0;
	public Sprite sprite = new Sprite();
	
	public void draw(){
		sprite.draw(x, y, sprite.getCurrentImage().getImageWidth(), sprite.getCurrentImage().getImageWidth());
	}
}
