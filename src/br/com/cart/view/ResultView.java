package br.com.cart.view;

import java.util.List;

import br.com.cart.model.BestLap;
import br.com.cart.model.PilotResult;

public class ResultView {

	public void showRaceResult(List<PilotResult> raceResult) {
		
		raceResult.forEach(result -> System.out.println(result.getPosition() 
				+ "st. " 
				+ result.getPilot().getCode()
				+ " - " 
				+ result.getPilot().getName() 
				+ " / Laps: " 
				+ result.getCompletedLaps() 
				+ " / Total time: " 
				+ result.getRaceTime()));
	}

	public void showBestLaps(List<PilotResult> raceResult) {

		System.out.println("");
		
		raceResult.forEach(result -> System.out.println(result.getPilot().getCode()
				+ " - " 
				+ result.getPilot().getName() 
				+ " / Best lap: " 
				+ result.getBestLap().getLap()
				+ " - "
				+ result.getBestLap().getAvgLapSpeed()));
	}

	public void showRaceBestLap(BestLap raceBestLap) {

		System.out.println("");
		System.out.println("Melhor volta da corrida");
		
		System.out.println(raceBestLap.getPilot().getCode()
				+ " - " 
				+ raceBestLap.getPilot().getName() 
				+ " / Best lap: " 
				+ raceBestLap.getLap()
				+ " - "
				+ raceBestLap.getAvgLapSpeed());
	}

	public void showAvgSpeed(List<PilotResult> raceResult) {
		
		System.out.println("");
		
		raceResult.forEach(result -> System.out.println(result.getPilot().getCode()
				+ " - " 
				+ result.getPilot().getName() 
				+ " / Avg speed: " 
				+ result.getAvgRaceSpeed()));
	}

	public void showTimeAfterWinner(List<PilotResult> raceResult) {
		
		System.out.println("");
		
		raceResult.forEach(result -> System.out.println(result.getPilot().getCode()
				+ " - " 
				+ result.getPilot().getName() 
				+ " / Time after winner: " 
				+ result.getTimeAfterWinner()));
	}

	public int getStrategy() {
		return 1;
	}

}
