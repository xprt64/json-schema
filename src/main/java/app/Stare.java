package app;

public enum Stare {
    ACTIVAT("activat"),
    DEACTIVAT("dezactivat");

    private final String stare;

    Stare(String stare) {
        this.stare = stare;
    }

    public String getStare() {
        return stare;
    }

    @Override
    public String toString() {
        return stare;
    }
}