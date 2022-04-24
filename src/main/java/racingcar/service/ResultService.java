package racingcar.service;

import racingcar.constant.Configuration;
import racingcar.constant.ViewMessage;
import racingcar.domain.Car;
import racingcar.domain.CarEntry;
import racingcar.domain.Record;
import racingcar.domain.Result;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultService {
    private Result result;
    private CarEntry carEntry;

    public ResultService(CarEntry carEntry, Result result) {
        this.carEntry = carEntry;
        this.result = result;
    }

    public void printResult() {
        System.out.println("\n" + ViewMessage.GAME_RESULT);
        showRecordByRound();
        pickWinners();
        printWinner();
    }

    private void showRecordByRound() {
        List<Record> recordList = result.getRecordList();
        recordList.forEach(record -> showResult(record));
    }

    private void showResult(Record record) {
        record.getRecordsByRound().forEach(car -> {
            System.out.println(car.getKey() + ", "+ car.getValue());
        });
    }

    public void printWinner() {
        System.out.print(ViewMessage.WINNER_LIST);
        System.out.println(String.join(Configuration.NAME_DELIMITER, result.getWinner()));
    }


    private void pickWinners() {
        List<Car> cars = carEntry.getCars();
        Collections.sort(cars); // FIXME: 가능하면 원본은 안바꾸는게 좋다(immutable) (minor)

        Car firstPlace = cars.get(0);
        int maxDistance = firstPlace.getDistance();

        List<String> winners = pickSameDistanceCars(maxDistance, cars);
        result.setWinners(winners);
    }

    private List<String> pickSameDistanceCars(int maxDistance, List<Car> cars) {
        List<String> sameDistanceCars = new ArrayList<>();
        for (Car car: cars) {
            addIfHasSameDistance(sameDistanceCars, car, maxDistance);
        }
        return sameDistanceCars;
    }

    private void addIfHasSameDistance(List<String> list, Car candidate, int maxDistance) {
        if (candidate.getDistance() == maxDistance) {
            list.add(candidate.getName());
        }
    }
}
