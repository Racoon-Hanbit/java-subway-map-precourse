package subway;

import subway.controller.ControllerMapper;
import subway.view.InputView;

public class ApplicationContext {
    private ControllerMapper controllerMapper;
    private InputView inputView = InputView.getInstance();

    public ApplicationContext(ControllerMapper controllerMapper) {
        this.controllerMapper = controllerMapper;
    }

    public void run() {
        while (true) {
            try {
                String state = inputView.inputMainMenu();
                ManagementType managementType = ManagementType.findManagementNumber(state);
                System.out.println("선택완료");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
