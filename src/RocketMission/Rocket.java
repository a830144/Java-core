package RocketMission;
public class Rocket implements SpaceShip {
	
	private int rocketCost;
	private int rocketWeight;
	private int maxWeight;
	private double launchExplosion;
	private double landingCrash;
	

	private int currentWeight;

	public int getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(int currentWeight) {
		this.currentWeight = currentWeight;
	}

	public int getRocketCost() {
		return rocketCost;
	}

	public void setRocketCost(int rocketCost) {
		this.rocketCost = rocketCost;
	}

	public int getRocketWeight() {
		return rocketWeight;
	}

	public void setRocketWeight(int rocketWeight) {
		this.rocketWeight = rocketWeight;
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public double getLaunchExplosion() {
		return launchExplosion;
	}

	public void setLaunchExplosion(double launchExplosion) {
		this.launchExplosion = launchExplosion;
	}

	public double getLandingCrash() {
		return landingCrash;
	}

	public void setLandingCrash(double landingCrash) {
		this.landingCrash = landingCrash;
	}

	@Override
	public boolean launch() {
		return true;
	}

	@Override
	public boolean landing() {
		return true;
	}

	@Override
	public boolean canCarry(Item item) {
		if(item.getWeight()<=this.getMaxWeight()-this.getCurrentWeight()){
			return true;
		}
		else{
			return false;
		}	
	}

	@Override
	public void carry(Item item) {
		this.setCurrentWeight(this.getCurrentWeight()+item.getWeight());

	}

}
