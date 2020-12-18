package subway.domain;

public class StationName {
    private final String ERROR_NAME_LIMIT = "[ERROR] 지하철 역 이름 길이는 2이상 입니다.";

    private String name;

    public StationName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(ERROR_NAME_LIMIT);
        }
        this.name = name;
    }
}
