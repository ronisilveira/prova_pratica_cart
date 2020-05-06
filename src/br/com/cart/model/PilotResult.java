package br.com.cart.model;

import java.time.Duration;

public class PilotResult {

	private Pilot pilot;
	
	private int position;
	
	private int completedLaps;
	
	private Duration raceTime;
	
	private Double avgRaceSpeed;
	
	private Duration timeAfterWinner;
	
	private BestLap bestLap;

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getCompletedLaps() {
		return completedLaps;
	}

	public void setCompletedLaps(int completedLaps) {
		this.completedLaps = completedLaps;
	}

	public Duration getRaceTime() {
		return raceTime;
	}

	public void setRaceTime(Duration raceTime) {
		this.raceTime = raceTime;
	}

	public Double getAvgRaceSpeed() {
		return avgRaceSpeed;
	}

	public void setAvgRaceSpeed(Double avgRaceSpeed) {
		this.avgRaceSpeed = avgRaceSpeed;
	}

	public Duration getTimeAfterWinner() {
		return timeAfterWinner;
	}

	public void setTimeAfterWinner(Duration timeAfterWinner) {
		this.timeAfterWinner = timeAfterWinner;
	}

	public BestLap getBestLap() {
		return bestLap;
	}

	public void setBestLap(BestLap bestLap) {
		this.bestLap = bestLap;
	}
}
