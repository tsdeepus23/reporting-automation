package util.reporting.enums;

public enum ReportSource {
    TABLE("Table", "object:9", 1), DATA_SOURCE("Data source", "object:8", 0), EXTERNAL_IMPORT("External import", "object:10", 2);

    private String visibleText;
    private String value;
    private int index;

    ReportSource(String visibleText, String value, int index) {
        this.visibleText = visibleText;
        this.value = value;
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public String getVisibleText() {
        return visibleText;
    }

    public int getIndex() {
        return index;
    }
}
