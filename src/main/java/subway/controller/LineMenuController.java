package subway.controller;

import subway.menus.LineMenu;
import subway.views.lineviews.LineInputView;
import subway.views.lineviews.LineOutputView;

import java.util.Scanner;

public class LineMenuController implements Controller{
    private static final LineMenuController lineMenuController = new LineMenuController();

    private LineMenuController() {
    }

    public static LineMenuController getInstance() {
        return lineMenuController;
    }

    public void mappingMenu(Scanner scanner) {
          LineOutputView.printLineManagePage();
          branchBySelectedOption(scanner, LineInputView.selectLineMenu(scanner));
    }

    private void branchBySelectedOption(Scanner scanner, String selectedOption) {
        if (selectedOption.equals(LineMenu.GO_BACK_TO_MAIN_MENU)) {
            System.out.println();
            return;
        }
        LineMenu.execute(scanner, selectedOption);
    }
}
