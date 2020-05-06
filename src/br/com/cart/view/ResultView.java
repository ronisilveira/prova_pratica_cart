package br.com.cart.view;

import java.util.List;
import java.util.Scanner;

import br.com.cart.model.BestLap;
import br.com.cart.model.PilotResult;

public class ResultView {

	public void showRaceResult(List<PilotResult> raceResult) {
		
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|                             Resultado da corrida                             |");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("| Posição | Piloto                         | Voltas complet. | Tempo de prova  |");
		System.out.println("|------------------------------------------------------------------------------|");

		raceResult.forEach(result -> {
			if (result.getPosition() < 999)
				System.out.printf("| %4dst. |", result.getPosition());
			else
				System.out.printf("|         |", result.getPosition());
			System.out.printf(" %03d - %-24s | %15d | %8d:%02d.%03d |\n",
					result.getPilot().getCode(), result.getPilot().getName(), 
					result.getCompletedLaps(),
					result.getRaceTime().toMinutes(),
					result.getRaceTime().toSecondsPart(),
					result.getRaceTime().toMillisPart());
		});
		System.out.println("+------------------------------------------------------------------------------+");
	}

	public void showBestLaps(List<PilotResult> raceResult) {

		System.out.println();
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|                          Melhor volta de cada piloto                         |");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("| Piloto                          | Volta  | Tempo da volta  | Vel. méd. volta |");
		System.out.println("|------------------------------------------------------------------------------|");

		raceResult.forEach(result -> {
			System.out.printf("| %03d - %-25s | %6d | %8d:%02d.%03d | %15.3f |\n",
					result.getPilot().getCode(), result.getPilot().getName(), 
					result.getBestLap().getLap(),
					result.getBestLap().getLapTime().toMinutes(),
					result.getBestLap().getLapTime().toSecondsPart(),
					result.getBestLap().getLapTime().toMillisPart(),
					result.getBestLap().getAvgLapSpeed());
		});
		System.out.println("+------------------------------------------------------------------------------+");
	}

	public void showRaceBestLap(BestLap raceBestLap) {

		System.out.println();
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|                            Melhor volta da corrida                           |");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("| Piloto                          | Volta  | Tempo da volta  | Vel. méd. volta |");
		System.out.println("|------------------------------------------------------------------------------|");

		System.out.printf("| %03d - %-25s | %6d | %8d:%02d.%03d | %15.3f |\n",
				raceBestLap.getPilot().getCode(), raceBestLap.getPilot().getName(), 
				raceBestLap.getLap(),
				raceBestLap.getLapTime().toMinutes(),
				raceBestLap.getLapTime().toSecondsPart(),
				raceBestLap.getLapTime().toMillisPart(),
				raceBestLap.getAvgLapSpeed());
		System.out.println("+------------------------------------------------------------------------------+");
	}

	public void showAvgSpeedAndTimeAfterWinner(List<PilotResult> raceResult) {
		
		System.out.println();
		System.out.println("+------------------------------------------------------------------------------+");
		System.out.println("|             Velocidade média da prova e tempo depois do primeiro             |");
		System.out.println("|------------------------------------------------------------------------------|");
		System.out.println("| Piloto                           | Tempo depois do 1o  | Vel. média da prova |");
		System.out.println("|------------------------------------------------------------------------------|");

		raceResult.forEach(result -> {
			if (result.getTimeAfterWinner() != null)
				System.out.printf("| %03d - %-26s | %12d:%02d.%03d | %19.3f |\n",
						result.getPilot().getCode(), result.getPilot().getName(), 
						result.getTimeAfterWinner().toMinutes(),
						result.getTimeAfterWinner().toSecondsPart(),
						result.getTimeAfterWinner().toMillisPart(),
						result.getAvgRaceSpeed());
			else
				System.out.printf("| %03d - %-26s |                     | %19.3f |\n",
						result.getPilot().getCode(), result.getPilot().getName(), 
						result.getAvgRaceSpeed());
		});
		System.out.println("+------------------------------------------------------------------------------+");
	}

	public int getStrategy() {
		
		System.out.println();
		System.out.println("Selecione uma das opções:");
		System.out.println();
		System.out.println(" 1 - Considera que a corrida só termina quando todos os pilotos completam a quarta volta ou desistem");
		System.out.println(" 2 - Considera que a corrida termina quando um dos pilotos completa a quarta volta");

		Scanner scanner = new Scanner(System.in);

		try {
			int opc;
			do {
				opc = scanner.nextInt();
				
				if (opc != 1 && opc != 2)
					System.out.println("Opção inválida. Informe 1 ou 2:");
	
			} while (opc != 1 && opc != 2);

			return opc;
			
		} finally {
			scanner.close();
		}
	}
}
