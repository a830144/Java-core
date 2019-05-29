package RocketMission;
public class U1 extends Rocket{

	
	public U1(){
		this.setRocketCost(100);
		this.setRocketWeight(10);
		this.setMaxWeight(18);
	}
	@Override
	public boolean launch() {
		this.setLaunchExplosion(0.05*this.getCurrentWeight()/this.getCurrentWeight());
		int random = (int)(Math.random()*10+1);
		if(random>5){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean landing() {
		this.setLandingCrash(0.01*this.getCurrentWeight()/this.getCurrentWeight());
		int random = (int)(Math.random()*10+1);
		if(random>5){
			return false;
		}else{
			return true;
		}
	}
}
