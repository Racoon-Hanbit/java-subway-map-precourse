package subway;

import subway.domain.Station;
import subway.domain.StationName;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.Scanner;

public class InputStationManager implements InputManager {
    private static final String STATION_MAIN_MENU = "## 역 관리 화면\n1. 역 등록\n" +
                                                        "2. 역 삭제\n3. 역 조회\nB. 돌아가기\n";
    private static final String WRONG_STATE_TRY_AGAIN = "[ERROR] 선택할 수 없는 기능입니다.";
    private static final String INPUT_STATION_TO_ENROLL = "## 등록할 역 이름을 입력하세요.";
    private static final String DUPLICATED_TRY_AGAIN = "[ERROR] 중복됩니다.";
    private static final String STATION_ENROLLED = "\n[INFO] 지하철 역이 등록되었습니다.\n";
    private static final String INPUT_STATION_TO_DELETE = "## 삭제할 역 이름을 입력하세요.";
    private static final String NOTHING_OR_ALREADY_ENROLLED_TRY_AGAIN = "[ERROR] 해당 역이 없거나 이미 노선에 등록되어 있습니다.";
    private static final String STATION_DELETED = "\n[INFO] 지하철 역이 삭제되었습니다.\n";
    private static final String STATION_MENU_NUMBER = "1";

    private Scanner scanner;

    private enum Menu {
        REGISTER("1",
                    ((InputStationManager) SubwayManager.getMenus(STATION_MENU_NUMBER))::register),
        DELETE("2",
                    ((InputStationManager) SubwayManager.getMenus(STATION_MENU_NUMBER))::delete),
        INQUIRY("3", StationRepository::printStation),
        BACK("B", System.out::println);

        private final String name;
        private final Runnable runnable;

        Menu(String name, Runnable runnable) {
            this.name = name;
            this.runnable = runnable;
        }
        public static void execute(String input) {
            Arrays.stream(values())
                    .filter(value -> value.name.equals(input))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(WRONG_STATE_TRY_AGAIN))
                    .runnable.run();
        }
    }

    public InputStationManager(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void selectMenu() {
        try {
            System.out.println(STATION_MAIN_MENU);
            String state = scanner.next();
            Menu.execute(state);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            selectMenu();
        }
    }

    @Override
    public void register() {
        try {
            System.out.println(INPUT_STATION_TO_ENROLL);
            Station station = new Station(new StationName(scanner.next()));
            if (StationRepository.stations().contains(station)) {
                throw new IllegalArgumentException(DUPLICATED_TRY_AGAIN);
            }
            StationRepository.addStation(station);
            System.out.println(STATION_ENROLLED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            register();
        }
    }

    @Override
    public void delete() {
        try {
            System.out.println(INPUT_STATION_TO_DELETE);
            String stationToDelete = scanner.next();
            if (StationRepository.isRegisteredStation(new Station(new StationName(stationToDelete)))
                    || !StationRepository.deleteStation(stationToDelete)) {
                throw new IllegalArgumentException(NOTHING_OR_ALREADY_ENROLLED_TRY_AGAIN);
            }
            System.out.println(STATION_DELETED);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            delete();
        }
    }

}
