package racingcar.domain;

public class Car implements Comparable<Car> {
    private String name;
    private Position position;

    public Car(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car car) {
        return this.position.compareTo(car.position);
    }
}
