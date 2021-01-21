package subway.menus;

import subway.service.lineservice.LineAddService;
import subway.service.lineservice.LineDeleteService;
import subway.service.lineservice.LineService;
import subway.service.lineservice.LinesPrintService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Supplier;

public enum LineMenu {
    LINE_ADD("1", "노선 등록", () -> {
        return LineAddService.lineService();
    }),
    LINE_DELETE("2", "노선 삭제", LineDeleteService::getInstance),
    LINE_SELECT("3", "노선 조회", LinesPrintService::getInstance),
    GO_BACK_TO_MAIN_MENU("B", "돌아가기", () -> {return null;});

    private final String option;
    private final String description;
    private final Supplier<LineService> run;

    LineMenu(String option, String description, Supplier<LineService> runToMethod) {
        this.option = option;
        this.description = description;
        this.run = runToMethod;
    }

    public static void execute(Scanner scanner, String lineMenu) {
        Arrays.stream(values())
            .filter(value -> value.option.equals(lineMenu))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("그런거 없습니다."))
            .run.get().lineService(scanner);
    }

    @Override
    public String toString() {
        return option + MenuConstant.POINT + description;
    }
}
