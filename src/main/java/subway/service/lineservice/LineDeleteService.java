package subway.service.lineservice;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.views.InputView;
import subway.views.lineviews.LineOutputView;

import java.util.Scanner;

public class LineDeleteService implements LineService{
    private static final String NOT_EXIST_LINE_MESSAGE = "\n[ERROR] 존재하지 않는 노선입니다.";
    private static final LineDeleteService lineDeleteService = new LineDeleteService();

    private LineDeleteService() {
    }

    public static LineService getInstance() {
        return lineDeleteService;
    }

    @Override
    public void lineService(Scanner scanner) {
        try {
            String lineNameToDelete = makeLineNameToDelete(scanner);
            deleteLineFromRepository(lineNameToDelete);
        } catch (IllegalArgumentException e) {
            goToMenu(e, scanner);
        }
    }

    private String makeLineNameToDelete(Scanner scanner) {
        LineOutputView.printLineNameToDeleteMessage();
        String lineNameToDelete = InputView.userInput(scanner);
        isNotExistLine(lineNameToDelete);
        return lineNameToDelete;
    }

    private void isNotExistLine(String lineNameToDelete) {
        if (!LineRepository.lines().contains(new Line(lineNameToDelete))) {
            throw new IllegalArgumentException(NOT_EXIST_LINE_MESSAGE);
        }
    }

    private void deleteLineFromRepository(String lineNameToDelete) {
        LineRepository.deleteLineByName(lineNameToDelete);
        LineOutputView.printDeleteSuccess();
    }
}
