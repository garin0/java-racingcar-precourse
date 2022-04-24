package racingcar.domain;

import javafx.util.Pair;

import java.util.List;

public class Record {
    private List<Pair<String, Integer>> recordsByRound;

    public Record(List<Pair<String, Integer>> recordsByRound) {
        this.recordsByRound = recordsByRound;
    }

    public List<Pair<String, Integer>> getRecordsByRound() {
        return recordsByRound;
    }

    @Override
    public String toString() {
        return "Record{" +
                "recordsByRound=" + recordsByRound +
                '}';
    }
}
