package subway.controller;

import subway.domain.StationRepository;

public class StationController implements Controller {
    private StationRepository stationRepository;

    public StationController(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    @Override
    public void register() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void select() {

    }
}
