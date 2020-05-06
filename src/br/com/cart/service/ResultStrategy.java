package br.com.cart.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import br.com.cart.model.BestLap;
import br.com.cart.model.DataLog;
import br.com.cart.model.Pilot;

public abstract class ResultStrategy {

	protected final static int FINAL_LAP = 4;

	public Duration timeAfterWinner(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {

		LocalTime finishTime = raceFinishTime(allDataLogs);

		Optional<DataLog> lastPilotLog = pilotDataLogs.stream()
				.sorted(Comparator.comparing(DataLog::getTime).reversed())
				.findFirst();
		
		if (lastPilotLog.isPresent() && lastPilotLog.get().getLap() == FINAL_LAP)
			return Duration.between(finishTime, lastPilotLog.get().getTime());
		
		return null;
	}

	protected LocalTime raceFinishTime(List<DataLog> dataLogs) {

		Optional<DataLog> finishLog = dataLogs.stream()
				.sorted(Comparator.comparing(DataLog::getTime))
				.filter(log -> log.getLap() == FINAL_LAP)
				.findFirst();

		if (finishLog.isPresent())
			return finishLog.get().getTime();

		finishLog = dataLogs.stream().sorted(Comparator.comparing(DataLog::getTime).reversed()).findFirst();

		if (finishLog.isPresent())
			return finishLog.get().getTime();

		return null;
	}

	protected BestLap createBestLap(DataLog dataLog) {
		
		BestLap bestLap = new BestLap();
		
		bestLap.setPilot(dataLog.getPilot());
		bestLap.setLap(dataLog.getLap());
		bestLap.setLapTime(dataLog.getLapTime());
		bestLap.setAvgLapSpeed(dataLog.getAvgLapSpeed());
		
		return bestLap;
	}

	public abstract int position(Pilot pilot, List<DataLog> allDataLogs);

	protected abstract int completedLaps(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs);

	protected abstract Duration raceTime(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs);

	protected abstract Double avgRaceSpeed(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs);

	protected abstract BestLap bestLap(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs);
}
