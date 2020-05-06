package br.com.cart.model;

import java.time.Duration;

public class BestLap {

	private Pilot pilot;
	
	private int lap;
	
	private Duration lapTime;
	
	private Double avgLapSpeed;

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public int getLap() {
		return lap;
	}

	public void setLap(int lap) {
		this.lap = lap;
	}

	public Duration getLapTime() {
		return lapTime;
	}

	public void setLapTime(Duration lapTime) {
		this.lapTime = lapTime;
	}

	public Double getAvgLapSpeed() {
		return avgLapSpeed;
	}

	public void setAvgLapSpeed(Double avgTurnSpeed) {
		this.avgLapSpeed = avgTurnSpeed;
	}
}
