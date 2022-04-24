package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void increaseDistance() {
        this.distance += 1;
    }

    @Override
    public int compareTo(Car car) {
        if (this.distance > car.distance) {
            return -1;
        } else if (this.distance < car.distance) {
            return 1;
        }
        return 0;
    }
}
