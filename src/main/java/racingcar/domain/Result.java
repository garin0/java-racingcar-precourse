package racingcar.domain;

import java.util.List;

public class Result {
    List<String> winner;
    List<Record> recordList;

    public Result(List<Record> recordList) {
        this.recordList = recordList;
    }

    public List<String> getWinner() {
        return winner;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setWinners(List<String> winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Result{" +
                "winner=" + winner +
                ", roundList=" + recordList +
                '}';
    }
}
