package subway.views.lineviews;

import subway.views.InputView;
import subway.views.OutputView;

import java.util.Scanner;

public class LineInputView implements InputView {
    private LineInputView() {
    }

    public static String selectLineMenu(Scanner scanner) {
        try {
            OutputView.printFeatureSelectMessage();
            return InputView.userInput(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return selectLineMenu(scanner);
        }
    }
}
