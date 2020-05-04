package br.com.cart;

import java.util.List;

import br.com.cart.model.PilotResult;
import br.com.cart.repository.DataLogRepository;
import br.com.cart.service.CartRaceService;
import br.com.cart.view.ResultView;

public class CartApplication {

	public static void main(String[] args) {
		
		CartRaceService service = new CartRaceService(new DataLogRepository());
		ResultView view = new ResultView();
		
		List<PilotResult> raceResult = service.getRaceResult();
		
		view.showRaceResult(raceResult);
		view.showBestTurns(service.getBestTurns());
		view.showRaceBestTurn(service.getRaceBestTurn());
		view.showAvgSpeed(raceResult);
		view.showTimeAfterWinner(raceResult);
	}
}
