package racingcar.service;

import racingcar.constant.Configuration;
import racingcar.domain.Car;
import racingcar.domain.CarEntry;
import racingcar.domain.Circuit;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Position;

import java.util.Collections;
import java.util.List;

public class CarRaceService {
    private CarEntry carEntry;
    private Circuit circuit;

    public CarRaceService(CarEntry carEntry, Circuit circuit) {
        this.carEntry = carEntry;
        this.circuit = circuit;
    }

    public void start() {
        playCarRaceByRound();
        Collections.sort(carEntry.getCars());

        for(Car car : carEntry.getCars()) {
            System.out.print(car.getName() + " ");
        }
        // 우승자 뽑기
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

    private setRaceWinner() {
        int maxDistance = Integer.MIN_VALUE;

    }
}
