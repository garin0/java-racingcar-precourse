package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.constant.Configuration;
import racingcar.constant.ErrorMessage;
import racingcar.constant.ViewMessage;
import racingcar.domain.Car;
import racingcar.domain.CarEntry;
import racingcar.domain.Circuit;
import racingcar.domain.Position;

import java.util.ArrayList;
import java.util.List;


public class InputViewService {

    public CarEntry setCarRaceEntity() {
        CarEntry carEntry = new CarEntry();
        try {
            carEntry = readCarEntryFromUser();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return carEntry;
    }

    public Circuit setCarRaceCircuit() {
        return readCircuitRoundFromUser();
    }

    private Circuit readCircuitRoundFromUser() {
        System.out.println(ViewMessage.RACE_COUNT);
        String roundStr = Console.readLine();
        int round = Integer.parseInt(roundStr);
        try {
            validateCircuitRound(round);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return new Circuit(round);
    }

    private void validateCircuitRound(int round) {
        if (round < Configuration.MIN_ROUND_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_INPUT);
        }
    }


    private CarEntry readCarEntryFromUser() {
        System.out.println(ViewMessage.ENTRY_CAR_NAME);
        String nameStr = Console.readLine();
        String[] nameList = nameStr.split(Configuration.SPLIT_CHAR);
        return addCarsToCarEntity(nameList);
    }

    private void validateCarNameLengthIsOver(String name) {
        if (name.length() > Configuration.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_INPUT);
        }
    }

    private CarEntry addCarsToCarEntity(String[] nameList) {
        List<Car> carList = new ArrayList<>();
        for(String name : nameList) {
            validateCarNameLengthIsOver(name);
            carList.add(new Car(name, new Position()));
        }
        return new CarEntry(carList);
    }

}
