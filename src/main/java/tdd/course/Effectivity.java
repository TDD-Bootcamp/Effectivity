package tdd.course;

public class Effectivity {
    private String ranges;

    public Effectivity(String ranges) {
        this.ranges = ranges;
    }

    public boolean isEffect(String tail) {
        if (ranges.equals("ALL")) {
            return true;
        }
        return false;
    }
}
