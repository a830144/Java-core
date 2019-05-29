package RocketMission;
public interface SpaceShip {

	
	public boolean launch();
	public boolean landing();
	public boolean canCarry(Item item);
	public void carry(Item item);
}
