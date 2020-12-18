package subway;

import subway.controller.*;
import subway.domain.*;

import java.util.Arrays;
import java.util.List;

public class ApplicationInitializer {

    public static ApplicationContext injectDependencies() {
        StationRepository stationRepository = new StationRepository();
        LineRepository lineRepository = new LineRepository();
        initStation(stationRepository);
        initLine(lineRepository);
        ControllerMapper controllerMapper = getControllerMapper(stationRepository, lineRepository);
        return new ApplicationContext(controllerMapper);
    }

    private static void initStation(StationRepository stationRepository) {
        stationRepository.addStation(new Station(new StationName("교대역")));
        stationRepository.addStation(new Station(new StationName("강남역")));
        stationRepository.addStation(new Station(new StationName("역삼역")));
        stationRepository.addStation(new Station(new StationName("남부터미널역")));
        stationRepository.addStation(new Station(new StationName("양재역")));
        stationRepository.addStation(new Station(new StationName("양재시민의숲역")));
        stationRepository.addStation(new Station(new StationName("매봉역")));
    }

    private static void initLine(LineRepository lineRepository) {
        Line line1 = new Line(new LineName("2호선"));
        line1.addStation(new Station(new StationName("교대역")));
        line1.addStation(new Station(new StationName("강남역")));
        line1.addStation(new Station(new StationName("역삼역")));
        Line line2 = new Line(new LineName("3호선"));
        line2.addStation(new Station(new StationName("교대역")));
        line2.addStation(new Station(new StationName("남부터미널역")));
        line2.addStation(new Station(new StationName("양재역")));
        line2.addStation(new Station(new StationName("매봉역")));
        Line line3 = new Line(new LineName("신분당선"));
        line3.addStation(new Station(new StationName("강남역")));
        line3.addStation(new Station(new StationName("양재역")));
        line3.addStation(new Station(new StationName("양재시민의숲역")));
        lineRepository.addAll(Arrays.asList(line1, line2, line3));
    }

    public static ControllerMapper getControllerMapper(StationRepository stationRepository,
                                                            LineRepository lineRepository) {
        StationController stationController = new StationController(stationRepository);
        LineController lineController = new LineController(stationRepository, lineRepository);
        SectionController sectionController = new SectionController(stationRepository, lineRepository);
        List<Controller> controllers = Arrays.asList(stationController, lineController, sectionController);
        return new ControllerMapper(controllers);
    }

}
