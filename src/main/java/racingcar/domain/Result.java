package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    List<String> winner;

    public Result() {
        this.winner = new ArrayList<>();
    }

    public List<String> getWinner() {
        return winner;
    }

    public void setWinner(List<String> winner) {
        this.winner = winner;
    }
}
