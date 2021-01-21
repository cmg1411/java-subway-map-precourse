package subway.service.lineservice;

import subway.repository.LineRepository;
import subway.views.lineviews.LineOutputView;

import java.util.Scanner;

public class LinesPrintService implements LineService{
    private static final LinesPrintService linesPrintService = new LinesPrintService();

    private LinesPrintService() {
    }

    public static LineService getInstance() {
        return linesPrintService;
    }

    @Override
    public void lineService(Scanner scanner) {
        LineOutputView.printLines(LineRepository.lines());
    }
}
