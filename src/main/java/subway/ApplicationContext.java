package subway;

import subway.controller.ControllerMapper;

public class ApplicationContext {
    private ControllerMapper controllerMapper;

    public ApplicationContext(ControllerMapper controllerMapper) {
        this.controllerMapper = controllerMapper;
    }

}
