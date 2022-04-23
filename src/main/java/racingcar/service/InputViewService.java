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
        return getCircuitSetting();
    }

    private Circuit getCircuitSetting() {
        String roundStr = getRoundCount();
        while(!isValidCircuitRoundCount(roundStr)) {
            roundStr = getRoundCount();
        }
        return new Circuit(Integer.parseInt(roundStr));
    }

    private String getRoundCount() {
        System.out.println(ViewMessage.RACE_COUNT);
        return Console.readLine();
    }

    private String getCarNames() {
        System.out.println(ViewMessage.ENTRY_CAR_NAME);
        return Console.readLine();
    }

    private boolean isValidCircuitRoundCount(String roundStr) {
        int round = Integer.parseInt(roundStr);
        try {
            validateCircuitRound(round);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private void validateCircuitRound(int round) {
        if (round < Configuration.MIN_ROUND_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_INPUT);
        }
    }


    private CarEntry readCarEntryFromUser() {
        String nameStr = getCarNames();
        while(!isValidCarNameLength(nameStr)){
            nameStr = getCarNames();
        }
        String[] nameList = nameStr.split(Configuration.SPLIT_CHAR);
        return addCarsToCarEntity(nameList);
    }

    private void validateCarNameLengthIsOver(String name) {
        if (name.length() > Configuration.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_OVER);
        }
    }

    private boolean isValidCarNameLength(String nameStr) {
        String[] nameList = nameStr.split(Configuration.SPLIT_CHAR);
        try {
            addCarsToCarEntity(nameList);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
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
