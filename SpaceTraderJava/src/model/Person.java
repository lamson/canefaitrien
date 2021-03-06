package model;

/**
 * Person class for holding info on the Person
 * 
 * @author Andrew Duda
 * @version 1.0
 */

public class Person {

	// Person info
	private String name;
	private int pilotPts, fighterPts, traderPts, engineerPts;

	/**
	 * Constructor for loading/ creating a Person
	 */
	public Person(String name, int pilotPts, int fighterPts, int traderPts,
			int engineerPts) {
		this.name = name;
		this.pilotPts = pilotPts;
		this.fighterPts = fighterPts;
		this.traderPts = traderPts;
		this.engineerPts = engineerPts;
	}

	public String toString() {
		return "Name: " + name + "\nPilot: " + pilotPts + "\nFighter: "
				+ fighterPts + "\nTrader: " + traderPts + "\nEngineer: "
				+ engineerPts;
	}
	
	/**
	 * getters and setters
	 */
	public String getName() {
		return name;
	}

	public int getPilotPts() {
		return pilotPts;
	}

	public int getFighterPts() {
		return fighterPts;
	}

	public int getTraderPts() {
		return traderPts;
	}

	public int getEngineerPts() {
		return engineerPts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPilotPts(int pilotPts) {
		this.pilotPts = pilotPts;
	}

	public void setFighterPts(int fighterPts) {
		this.fighterPts = fighterPts;
	}

	public void setTraderPts(int traderPts) {
		this.traderPts = traderPts;
	}

	public void setEngineerPts(int engineerPts) {
		this.engineerPts = engineerPts;
	}
}
