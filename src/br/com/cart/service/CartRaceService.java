package br.com.cart.service;

import java.util.List;

import br.com.cart.model.BestTurn;
import br.com.cart.model.PilotResult;
import br.com.cart.repository.DataLogRepository;

public class CartRaceService {

	private DataLogRepository repository;

	public CartRaceService(DataLogRepository repository) {
		this.repository = repository;
	}

	public List<PilotResult> getRaceResult() {
		return null;
	}

	public List<BestTurn> getBestTurns() {
		return null;
	}

	public BestTurn getRaceBestTurn() {
		return null;
	}
}
