package br.com.cart.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.cart.model.DataLog;
import br.com.cart.model.Pilot;

public class DataLogRepository {

	private static final String FILENAME = "resources/logData.txt";

	private static final int TIME_IDX = 0;
	private static final int PILOT_CODE_IDX = 1;
	private static final int PILOT_NAME_IDX = 3;
	private static final int TURN_IDX = 4;
	private static final int TURN_TIME_IDX = 5;
	private static final int SPEED_IDX = 6;

	public List<DataLog> loadDataLog() {

		List<DataLog> result = new ArrayList<>();
		Map<Integer, Pilot> pilots = new HashMap<>();

		try {

			File file = new File(getClass().getClassLoader().getResource(FILENAME).getFile());
			Scanner reader = new Scanner(file);

			while (reader.hasNextLine()) {
				String data = reader.nextLine();
				result.add(parseData(data, pilots));
			}

			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		return result;
	}

	private DataLog parseData(String data, Map<Integer, Pilot> pilots) {

		String[] parts = data.split(" ");

		DataLog result = new DataLog();

		result.setTime(getTime(parts[TIME_IDX]));
		result.setPilot(getPilot(parts[PILOT_CODE_IDX], parts[PILOT_NAME_IDX], pilots));
		result.setLap(Integer.parseInt(parts[TURN_IDX]));
		result.setLapTime(getDuration(parts[TURN_TIME_IDX]));
		result.setAvgLapSpeed(Double.parseDouble(parts[SPEED_IDX].replace(",", ".")));

		return result;
	}

	private Duration getDuration(String strDuration) {
		String[] parts = strDuration.split(":");
		String isoDuration = "PT" + parts[0] + "M" + parts[1] + "S";
		return Duration.parse(isoDuration);
	}

	private LocalTime getTime(String strTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
		return LocalTime.parse(strTime, formatter);
	}

	private Pilot getPilot(String pilotCode, String name, Map<Integer, Pilot> pilots) {

		Integer intPilotCode = Integer.parseInt(pilotCode);
		if (pilots.containsKey(intPilotCode))
			return pilots.get(intPilotCode);

		Pilot pilot = new Pilot();
		pilot.setCode(intPilotCode);
		pilot.setName(name);
		pilots.put(intPilotCode, pilot);

		return pilot;
	}
}