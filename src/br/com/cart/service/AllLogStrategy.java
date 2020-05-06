package br.com.cart.service;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import br.com.cart.model.BestLap;
import br.com.cart.model.DataLog;

public class AllLogStrategy extends ResultStrategy {

	@Override
	public int completedLaps(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {

		return pilotDataLogs.size();
	}

	@Override
	public Duration raceTime(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {
		
		return pilotDataLogs.stream().reduce(
				Duration.ZERO, 
				(duration, log) -> duration.plus(log.getLapTime()), 
				(dur1, dur2) -> dur1.plus(dur2));
	}

	@Override
	public Double avgRaceSpeed(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {

		OptionalDouble result = pilotDataLogs.stream()
				.mapToDouble(DataLog::getAvgLapSpeed)
				.average();
		
		if (result.isPresent())
			return result.getAsDouble();

		return null;
	}

	@Override
	protected BestLap bestLap(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {

		Optional<DataLog> bestLog = pilotDataLogs.stream()
				.sorted(Comparator.comparing(DataLog::getLapTime))
				.findFirst();
		
		if (bestLog.isPresent())
			return createBestLap(bestLog.get());
		
		return null;
	}
}
