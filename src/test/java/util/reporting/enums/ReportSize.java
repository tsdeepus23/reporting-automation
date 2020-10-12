package util.reporting.enums;

public enum ReportSize {
    SMALL("Small", "string:small", 2), MEDIUM("Medium", "string:medium", 1), LARGE("Large", "string:large", 0);
    private String visibleText;
    private String value;
    private int index;

    ReportSize(String visibleText, String value, int index) {
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
