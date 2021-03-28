package za.co.entelect.invest.easy.dojo.messaging.domain;

public enum ShareCode {
    DSY("Discovery", true),
    MTN("MTN Group Limited", false);

    String description;
    Boolean top40;

    ShareCode(String description, Boolean top40) {
        this.description = description;
        this.top40 = top40;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getTop40() {
        return top40;
    }
}
