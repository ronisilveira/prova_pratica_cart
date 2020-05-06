package br.com.cart.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import br.com.cart.model.BestLap;
import br.com.cart.model.DataLog;

public class UntilWinnerStrategy extends ResultStrategy {

	@Override
	public int completedLaps(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {

		LocalTime finishTime = raceFinishTime(allDataLogs);

		return (int) pilotDataLogs.stream()
				.filter(log -> log.getTime().isBefore(finishTime) || log.getTime().equals(finishTime))
				.count();
	}

	@Override
	public Duration raceTime(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {

		Optional<DataLog> firstLog = pilotDataLogs.stream()
				.sorted(Comparator.comparing(DataLog::getTime))
				.findFirst();

		if (firstLog.isPresent()) {
			LocalTime finishTime = raceFinishTime(allDataLogs);
			return Duration.between(firstLog.get().getTime().minus(firstLog.get().getLapTime()), finishTime);
		}

		return null;
	}

	@Override
	public Double avgRaceSpeed(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {
		
		
		LocalTime finishTime = raceFinishTime(allDataLogs);

		OptionalDouble result = pilotDataLogs.stream()
				.filter(log -> log.getTime().isBefore(finishTime) || log.getTime().equals(finishTime))
				.mapToDouble(DataLog::getAvgLapSpeed)
				.average();
		
		if (result.isPresent())
			return result.getAsDouble();

		return null;
	}

	@Override
	protected BestLap bestLap(List<DataLog> pilotDataLogs, List<DataLog> allDataLogs) {

		LocalTime finishTime = raceFinishTime(allDataLogs);

		Optional<DataLog> bestLog = pilotDataLogs.stream()
				.filter(log -> log.getTime().isBefore(finishTime) || log.getTime().equals(finishTime))
				.sorted(Comparator.comparing(DataLog::getLapTime))
				.findFirst();
		
		if (bestLog.isPresent())
			return createBestLap(bestLog.get());
		
		return null;
	}
}
