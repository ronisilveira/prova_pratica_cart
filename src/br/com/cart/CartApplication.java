package br.com.cart;

import java.util.List;

import br.com.cart.model.PilotResult;
import br.com.cart.repository.DataLogRepository;
import br.com.cart.service.AllLogStrategy;
import br.com.cart.service.CartRaceService;
import br.com.cart.service.ResultStrategy;
import br.com.cart.service.UntilWinnerStrategy;
import br.com.cart.view.ResultView;

public class CartApplication {

	public static void main(String[] args) {

		ResultView view = new ResultView();
		int option = view.getStrategy();
		CartRaceService service = new CartRaceService(new DataLogRepository(), createStrategy(option));

		List<PilotResult> raceResult = service.getRaceResult();

		view.showRaceResult(raceResult);
		view.showBestLaps(raceResult);
		view.showRaceBestLap(service.getRaceBestLaps());
		view.showAvgSpeed(raceResult);
		view.showTimeAfterWinner(raceResult);
	}

	private static ResultStrategy createStrategy(int option) {
		switch (option) {
		case 0:
			return new AllLogStrategy();
		case 1:
			return new UntilWinnerStrategy();
		default:
			return null;
		}
	}
}
