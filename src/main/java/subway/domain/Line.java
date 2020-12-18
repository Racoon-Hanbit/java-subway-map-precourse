package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private LineName name;
    private List<Station> stations = new ArrayList<>();

    public Line(LineName name) {
        this.name = name;
    }

    public LineName getName() {
        return name;
    }

    // 추가 기능 구현
    public void addStation(Station station) {
        if (stations.contains(station)) {
            throw new IllegalArgumentException("[ERROR] 중복됩니다.");
        }
        station.setRegister(true);
        stations.add(station);
    }
}
