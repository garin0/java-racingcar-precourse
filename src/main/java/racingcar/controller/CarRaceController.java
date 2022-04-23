package racingcar.controller;

import racingcar.domain.CarEntry;
import racingcar.domain.Circuit;
import racingcar.domain.Result;
import racingcar.service.CarRaceService;
import racingcar.service.InputViewService;
import racingcar.service.OutputViewService;

public class CarRaceController {
    private CarRaceService carRaceService;
    private InputViewService inputViewService;
    private OutputViewService outputViewService;

    public CarRaceController() {
        inputViewService = new InputViewService();
        outputViewService = new OutputViewService();
    }

    public void run() {
        CarEntry entry = inputViewService.setCarRaceEntity();
        Circuit circuit = inputViewService.setCarRaceCircuit();
        outputViewService.printResult();
        carRaceService = new CarRaceService(entry, circuit);
        Result result = carRaceService.start();
        outputViewService.printWinner(result);
    }
}
