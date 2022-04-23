package racingcar.domain;

import java.util.List;

public class CarEntry {
    private List<Car> cars;

    public CarEntry() {
    }

    public CarEntry(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }
}
