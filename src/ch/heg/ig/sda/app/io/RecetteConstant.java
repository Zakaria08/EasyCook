package ch.heg.ig.sda.app.io;

public enum RecetteConstant {

    REVIEW( "Review"),
    RATING( "Rating");

    private int columnIndex;
    private final String columnName;

    RecetteConstant(String columnName) {
        this.columnIndex = -1;
        this.columnName = columnName;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int columnIndex) {
        this.columnIndex = columnIndex;
    }

    public String getColumnName() {
        return columnName;
    }

}
