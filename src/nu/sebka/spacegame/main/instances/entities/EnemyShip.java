package nu.sebka.spacegame.main.instances.entities;


import nu.sebka.spacegame.main.Instance;
import nu.sebka.spacegame.main.Main;
import nu.sebka.spacegame.main.TextureBank;
import nu.sebka.spacegame.main.Utili;





public  class EnemyShip extends Ship {

	private float goalx = 0, goaly = 0;
	private float goaldirection = 0;
	boolean canMove = true;
	private int stuckTimer = 500;
	private int agro = 0;
	private int agroLimit = 3;
	private float agrospeed = 1.5f;
	private Instance target;

	public EnemyShip(float x, float y) {
		super(x, y);
		newGoal();
		setRotationFriction(0.2f);
		sprite.images.add(TextureBank.TEST);
	}


	@Override
	public void tick() {

	


		if(!canMove){
			if(stuckTimer > 0){
				stuckTimer -= 1;
			}else{
				stuckTimer = 500;
				canMove = true;
			}
		}

		


		if(canMove){
			goaldirection = (float) Math.toDegrees((Math.atan2(goaly - y , goalx - x)));
			
			
			if(target != null){
				if(Main.getCurrentScene().getDistance(this, target) > 100){
					goalx = target.x;
					goaly = target.y;
				}
				setSpeed(agrospeed);
				if(getRotation() > goaldirection-10 && getRotation() < goaldirection+10 ){
					shoot();
				}
				
				if(Main.getCurrentScene().getDistance(this, target) > 64){
					setForce(goaldirection,getSpeed(),"both");

				}

			}

			else if(target == null){
				setForce(goaldirection,getSpeed(),"both");

				if(Main.getCurrentScene().getDistance(x, y, goalx, goaly) < 64){
					newGoal();
				}

			}


		}

		if(getRotation() < goaldirection){
			addRotationForce(0.3f);
		}
		if(getRotation() > goaldirection){
			addRotationForce(-0.3f);
		}

		if(target == null){
			if(random.nextInt(360) == 0){
				newGoal();
			}
		}

		if(getHealth() < 1){
			destroy();
		}


	}

	public void newGoal(){
		goalx = x+100+random.nextInt(150)*Utili.chooseInt(1,-1);
		goaly = y+100+random.nextInt(150)*Utili.chooseInt(1,-1);
	}

	public void setTarget(Instance instance){
		target = instance;
	}

	public Instance getTarget(){
		return target;
	}

	public int getAgro(){
		return agro;
	}

	public void setAgro(int agro){
		this.agro = agro;
	}

	public double getGoalDirection(){
		return goaldirection;
	}

	public float getAgroSpeed(){
		return agrospeed;
	}

	public int getAgroLimit(){
		return agroLimit;
	}

	public void setAgroLimit(int agroLimit){
		this.agroLimit = agroLimit;
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
