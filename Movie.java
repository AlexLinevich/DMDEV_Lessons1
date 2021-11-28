package by.lav.homework56;

import java.time.Month;
import java.util.Objects;

/**
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 */
public class Movie {

    private final int id;
    private final int year;
    private final Month month;
    private final Genre genre;
    private final Rating rating;

    public Movie(int id, int year, Month month, Genre genre, Rating rating) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                year == movie.year &&
                month == movie.month &&
                genre == movie.genre &&
                rating == movie.rating;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, genre, rating);
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public Month getMonth() {
        return month;
    }

    public Genre getGenre() {
        return genre;
    }

    public Rating getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }
}
