package racingcar.service;

import racingcar.constant.Configuration;
import racingcar.constant.ViewMessage;
import racingcar.domain.Result;

public class OutputViewService {
    public void printWinner(Result result) {
        System.out.print(ViewMessage.WINNER_LIST);
        System.out.println(String.join(Configuration.NAME_DELIMITER, result.getWinner()));
    }
}
