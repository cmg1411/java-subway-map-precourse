package subway.service.lineservice;

import subway.controller.LineMenuController;

import java.util.Scanner;

public interface LineService {

    default void goToMenu(IllegalArgumentException e, Scanner scanner) {
        System.out.println(e.getMessage());
        LineMenuController lineMenuController = LineMenuController.getInstance();
        lineMenuController.mappingMenu(scanner);
    }

    void lineService(Scanner scanner);
}
