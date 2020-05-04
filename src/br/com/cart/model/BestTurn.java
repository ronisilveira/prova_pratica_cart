package br.com.cart.model;

import java.time.Duration;

public class BestTurn {

	private Pilot pilot;
	
	private int turn;
	
	private Duration turnTime;
	
	private Double avgTurnSpeed;

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public Duration getTurnTime() {
		return turnTime;
	}

	public void setTurnTime(Duration turnTime) {
		this.turnTime = turnTime;
	}

	public Double getAvgTurnSpeed() {
		return avgTurnSpeed;
	}

	public void setAvgTurnSpeed(Double avgTurnSpeed) {
		this.avgTurnSpeed = avgTurnSpeed;
	}
}
