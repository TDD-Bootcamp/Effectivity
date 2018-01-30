package tdd.course;

public class Effectivity {
    public static final String ALL_EFFECT = "ALL";
    private String ranges;

    public Effectivity(String ranges) {
        this.ranges = ranges;
    }

    public boolean isEffect(String tail) {
        if (ranges.equals(ALL_EFFECT)) {
            return true;
        }
        boolean isEffect = false;
        for (String range : ranges.split(", ")) {
            isEffect |= isInRange(tail, range);
        }
        return isEffect;
    }

    private boolean isInRange(String tail, String ranges) {
        String[] limits = ranges.split("-");
        return tail.compareTo(limits[0]) >= 0 && tail.compareTo(limits[1]) <= 0;
    }
}
