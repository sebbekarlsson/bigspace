package nu.sebka.spacegame.main;

public abstract class Instance {

	public float x = 0;
	public float y = 0;
	public Sprite sprite = new Sprite();
	private String id;
	
	public Instance(float x, float y){
		this.x = x;
		this.y = y;
		for(int i = 0; i < 4; i++){
		id += Utili.chooseString("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","W","V","X","Y","Z")
		+Utili.random.nextInt(9);
		}
		
	}
	
	public void update(){
		tick();
		draw();
	}
	
	
	public abstract void tick();
	public void draw(){
		if(sprite.images.size() > 0)
		sprite.draw(x, y, sprite.getCurrentImage().getImageWidth(), sprite.getCurrentImage().getImageHeight());
	}
	
	public abstract void onDestroy();
	
	public abstract void onCreation();
	
	public void destroy(){
		Main.getCurrentScene().destroy(this);
	}

	
	public boolean isColliding(Instance instance){
		boolean c = false;
		if(
			x >= instance.x-sprite.width/2 && x <= instance.x+instance.sprite.width&&
			y >= instance.y-sprite.height/2 && y <= instance.y+instance.sprite.height
		){c = true;}
		
		return c;
	}
	
	public void setDepth(int depth){
		sprite.depth = depth;
	}
	
	public int getDepth(){
		return sprite.depth;
	}
	
	public boolean isOutsideView(){
		if(
			x > -Main.getCurrentScene().getCamera().x+Main.FRAMESIZE.width ||
			x < -Main.getCurrentScene().getCamera().x-200 ||
			y > -Main.getCurrentScene().getCamera().y+Main.FRAMESIZE.height ||
			y < -Main.getCurrentScene().getCamera().y-200
		){
			return true;
		}
		
		return false;
			
	}
	
	public String getId(){
		return id;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public float getMass(){
		return sprite.width*sprite.height;
	}
}
