package by.lav.homework56;

import java.time.Month;

/**
 * Даны 2 класса:
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив,
 * где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм
 * - получить все фильмы по переданному году
 * - получить все фильмы по переданному году и месяцу
 * - получить все фильмы по переданному жанру
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения
 * ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * Продемонстрировать работу кинотеатра в отдельном классе
 */
public class CinemaRunner {

    public static void main(String[] args) {

        Cinema cinema = new Cinema();
        cinema.addMovie(new Movie(1, 2020, Month.JULY, Genre.ACTION, Rating.FIVE_STARS));
        cinema.addMovie(new Movie(2, 2020, Month.AUGUST, Genre.CARTOON, Rating.FIVE_STARS));
        cinema.addMovie(new Movie(3, 2021, Month.APRIL, Genre.COMEDY, Rating.THREE_STARS));
        cinema.addMovie(new Movie(4, 2021, Month.JANUARY, Genre.CARTOON, Rating.FOUR_STARS));
        cinema.addMovie(new Movie(4, 2021, Month.JANUARY, Genre.CARTOON, Rating.FOUR_STARS));
        cinema.addMovie(new Movie(5, 2020, Month.APRIL, Genre.HORROR, Rating.FOUR_STARS));

        System.out.println("Список фильмов в кинотеатре: ");
        System.out.println(cinema);

        System.out.println("Все фильмы 2020 года: ");
        System.out.println(cinema.getAllMoviesByYear(2020));

        System.out.println("Все фильмы июля 2020 года: ");
        System.out.println(cinema.getAllMoviesByYearAndMonth(2020, Month.JULY));

        System.out.println("Фильмы отсортированные по жанру CARTOON: ");
        System.out.println(cinema.getAllMoviesByGenre(Genre.CARTOON));

        System.out.println("Топ 10 фильмов: ");
        System.out.println(cinema.getTopTen());

    }
}
