package by.lav.homework56;

public enum Rating {
    ONE_STAR(1),
    TWO_STARS(2),
    THREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);

    private final int ratingValue;

    Rating(int rating) {
        this.ratingValue = rating;
    }

    public int getRatingValue() {
        return ratingValue;
    }
}
