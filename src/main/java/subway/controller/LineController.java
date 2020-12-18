package subway.controller;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

public class LineController implements Controller {
    private StationRepository stationRepository;
    private LineRepository lineRepository;

    public LineController(StationRepository stationRepository,
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
