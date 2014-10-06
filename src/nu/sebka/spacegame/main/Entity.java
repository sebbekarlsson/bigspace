package nu.sebka.spacegame.main;



public abstract class Entity extends Instance {

	public float dx = 0;
	public float dy = 0;
	private float r = 0;
	private float dr = 0;
	private double direction = 0;
	private float acceleration = 0;
	private float friction = 0.5f;
	private float rotationFriction = 0.9f;
	private float health = 100;
	private float speed = 1;

	public Entity(float x, float y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void update(){
	
		usePhysics();
		tick();
		draw();
	}
	
	public void usePhysics(){
		x += dx;
		y += dy;
		direction = Math.atan2(dy, dx) / Math.PI * 180; 
		float tempdx = dx;
		float tempdy = dy;
		if(dx < 0){
			tempdx = dx * -1;
		}
		if(dy < 0){
			tempdy = dy * -1;
		}
		acceleration = tempdx + tempdy;
		sprite.r = r;
		r += dr;
		
		if(dr > 0){
			dr -= getRotationFriction();
		}
		else if(dr < 0){
			dr += getRotationFriction();
		}

		if(dx > 0){
			dx -= friction;
		}

		else if(dx < 0){
			dx += friction;
		}

		if(dy > 0){
			dy -= friction;
		}

		else if(dy < 0){
			dy += friction;
		}
		
		if(r > 360){
			r = 0;
		}
		else if(r < -360){
			r = 0;
		}
	}

	public void addForce(float direction, float force,String mode){
		if(mode.equals("horizontal")){
			dx += (float) (Math.cos(Math.toRadians(direction)) * force);
		}
		else if(mode.equals("vertical")){
			dy += (float) (Math.sin(Math.toRadians(direction)) * force);
		}else{
			dx += (float) (Math.cos(Math.toRadians(direction)) * force);
			dy += (float) (Math.sin(Math.toRadians(direction)) * force);
		}
	}

	public void setForce(float direction, float force, String mode){
		if(mode.equals("horizontal")){
			dx = (float) (Math.cos(Math.toRadians(direction)) * force);
		}
		else if(mode.equals("vertical")){
			dy = (float) (Math.sin(Math.toRadians(direction)) * force);
		}else{
			dx = (float) (Math.cos(Math.toRadians(direction)) * force);
			dy = (float) (Math.sin(Math.toRadians(direction)) * force);
		}
	}
	
	public void setRotation(float rotation){
		this.r = rotation;
	}
	
	public void addRotationForce(float force){
		dr += force;
	}
	
	public void setRotationForce(float force){
		dr = force;
	}
	
	public float getRotation(){
		return this.r;
	}
	
	public float getRotationAcceleration(){
		return dr;
	}
	
	public float getAcceleration(){
		return this.acceleration;
	}
	
	public double getDirection(){
		return direction;
	}
	
	public float getFriction(){
		return friction;
	}
	
	public void setFriction(float friction){
		this.friction = friction;
	}
	
	public float getRotationFriction(){
		return rotationFriction;
	}
	
	public void setRotationFriction(float friction){
		this.rotationFriction = friction;
	}
	
	public float getHealth(){
		return health;
	}
	
	public void setHealth(float health){
		this.health = health;
	}
	
	public float getSpeed(){
		return speed;
	}
	
	public void setSpeed(float speed){
		this.speed = speed;
	}
	






}
