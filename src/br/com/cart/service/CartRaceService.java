package br.com.cart.service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import br.com.cart.model.BestLap;
import br.com.cart.model.DataLog;
import br.com.cart.model.Pilot;
import br.com.cart.model.PilotResult;
import br.com.cart.repository.DataLogRepository;

public class CartRaceService {

	private DataLogRepository repository;
	
	private ResultStrategy resultStrategy;
	
	public CartRaceService(DataLogRepository repository, ResultStrategy resultStrategy) {
		this.repository = repository;
		this.resultStrategy = resultStrategy;
	}

	public List<PilotResult> getRaceResult() {

		List<DataLog> allDataLogs = repository.loadDataLog();
		
		Map<Pilot, List<DataLog>> logsByPilot = allDataLogs.stream()
				.collect(Collectors.groupingBy(DataLog::getPilot));

		return logsByPilot.entrySet().stream()
				.map(entry -> createPilotResult(entry, allDataLogs))
				.sorted(Comparator.comparing(PilotResult::getPosition))
				.collect(Collectors.toList());
	}

	private PilotResult createPilotResult(Entry<Pilot, List<DataLog>> entry, List<DataLog> allDataLogs) {

		PilotResult result = new PilotResult();

		result.setPilot(entry.getKey());
		result.setPosition(resultStrategy.position(entry.getKey(), allDataLogs));
		result.setCompletedLaps(resultStrategy.completedLaps(entry.getValue(), allDataLogs));
		result.setRaceTime(resultStrategy.raceTime(entry.getValue(), allDataLogs));
		result.setAvgRaceSpeed(resultStrategy.avgRaceSpeed(entry.getValue(), allDataLogs));
		result.setTimeAfterWinner(resultStrategy.timeAfterWinner(entry.getValue(), allDataLogs));
		result.setBestLap(resultStrategy.bestLap(entry.getValue(), allDataLogs));
		
		return result;
	}

	public BestLap getRaceBestLaps() {

		List<DataLog> allDataLogs = repository.loadDataLog();
		return resultStrategy.bestLap(allDataLogs, allDataLogs);
	}
}
