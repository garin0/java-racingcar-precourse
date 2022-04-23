package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Configuration;
import racingcar.constant.ViewMessage;
import racingcar.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarRaceService {
    private CarEntry carEntry;
    private Circuit circuit;
    private List<String> winner = new ArrayList<>();

    public CarRaceService(CarEntry carEntry, Circuit circuit) {
        this.carEntry = carEntry;
        this.circuit = circuit;
    }

    public Result start() {
        playCarRaceByRound();
        Collections.sort(carEntry.getCars());
        // 우승자 뽑기
        Result result = setRaceWinner();
        return result;
    }

    private void playCarRaceByRound() {
        int totalRound = circuit.getRound();
        for (int i = 0; i < totalRound; i++) {
            goRandomDistance();
        }
    }

    private void goRandomDistance() {
        List<Car> cars = carEntry.getCars();
        cars.forEach(car -> {
            int distance = Randoms.pickNumberInRange(Configuration.MIN_DISTANCE, Configuration.MAX_DISTANCE);
            setDistanceOfCar(car, distance);
            printDistanceOfCar(car);
        });
        System.out.println();
    }

    private void printDistanceOfCar(Car car) {
        System.out.println(car.getName() + Configuration.NAME_COLON + car.getPosition().getDistanceView());
    }

    private void setDistanceOfCar(Car car, int distance) {
        Position position = car.getPosition();
        if (distance < Configuration.MIN_ACCELERATOR) {
            return;
        }
        position.increaseDistance();
    }

    private Result setRaceWinner() {
        List<Car> cars = carEntry.getCars();
        Car firstPlace = cars.get(0);
        int maxDistance = firstPlace.getPosition().getDistance();
        Result result = compareAllEntryCars(maxDistance, cars);
        return result;
    }

    private Result compareAllEntryCars(int maxDistance, List<Car> cars) {
        Result result = new Result();
        for (Car car : cars) {
            compareCandidateDistanceToWinner(car, maxDistance);
            result.setWinner(winner);
        }
        return result;
    }

    private void compareCandidateDistanceToWinner(Car candidate, int maxDistance) {
        Position positionOfCandidate = candidate.getPosition();
        if (positionOfCandidate.getDistance() == maxDistance) {
            winner.add(candidate.getName());
        }
    }
}
