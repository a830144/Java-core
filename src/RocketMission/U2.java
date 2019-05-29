package RocketMission;
public class U2 extends Rocket{
	public U2(){
		this.setRocketCost(120);
		this.setRocketWeight(18);
		this.setMaxWeight(29);
	}
	@Override
	public boolean launch() {
		this.setLaunchExplosion(0.04*this.getCurrentWeight()/this.getCurrentWeight());
		int random = (int)(Math.random()*10+1);
		if(random>5){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public boolean landing() {
		this.setLandingCrash(0.08*this.getCurrentWeight()/this.getCurrentWeight());
		int random = (int)(Math.random()*10+1);
		if(random>5){
			return false;
		}else{
			return true;
		}
	}
}
