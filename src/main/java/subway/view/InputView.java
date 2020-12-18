package subway.view;

import java.util.Scanner;

public class InputView {
    private static InputView inputView;
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void initiate(Scanner scanner) {
        inputView = new InputView(scanner);
    }

    public static InputView getInstance() {
        return inputView;
    }

    public String inputMainMenu() {
        System.out.println("##메인 화면\n1. 역 관리\n2. 노선 관리\n" +
                "3. 구간 관리\n4. 지하철 노선도 출력\nQ. 종료");
        System.out.println("\n## 원하는 기능을 선택하세요.");
        return scanner.next();
    }
}
