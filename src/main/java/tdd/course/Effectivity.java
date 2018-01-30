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
        String[] rangeArr = ranges.split(", ");
        boolean isEffect = false;
        for (String range : rangeArr) {
            isEffect |= isInRange(tail, range);
        }
        return isEffect;
    }

    private boolean isInRange(String tail, String ranges) {
        String[] limits = ranges.split("-");
        String lowLimit = limits[0];
        String highLimit = limits[1];
        if (tail.compareTo(lowLimit) >= 0 && tail.compareTo(highLimit) <= 0) {
            return true;
        }
        return false;
    }
}
