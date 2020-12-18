package subway.domain;

public class Station {
    private StationName name;
    private boolean isRegister;

    public Station(StationName name) {
        this.name = name;
    }

    public StationName getName() {
        return name;
    }

    // 추가 기능 구현
    public void setRegister(boolean register) {
        this.isRegister = register;
    }

    public boolean isRegister() {
        return isRegister;
    }
}
