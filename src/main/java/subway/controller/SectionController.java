package subway.controller;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class SectionController implements Controller {
    private StationRepository stationRepository;
    private LineRepository lineRepository;

    public SectionController(StationRepository stationRepository,
                          LineRepository lineRepository) {
        this.stationRepository = stationRepository;
        this.lineRepository = lineRepository;
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
