package racingcar.domain;

public class Position {
    private int distance;
    private String distanceView;

    public Position() {
        this.distance = 0;
        this.distanceView = "";
    }

    public int getDistance() {
        return distance;
    }

    public String getDistanceView() {
        return distanceView;
    }

    public void increaseDistance() {
        this.distance += 1;
        this.distanceView += "-";
    }

    public int compareTo(Position position) {
        if (this.distance > position.distance) {
            return -1;
        } else if (this.distance < position.distance) {
            return 1;
        }
        return 0;
    }
}
