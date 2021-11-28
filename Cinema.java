package by.lav.homework56;

import java.time.Month;
import java.util.*;

/**
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
 */
public class Cinema {

    private Map<Integer, LinkedHashSet<Movie>> cinemaList = new HashMap<>();

    public Cinema() {
    }

    public Cinema(Map<Integer, LinkedHashSet<Movie>> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public void addMovie(Movie movie) {
        LinkedHashSet<Movie> movieTemp;
        if (cinemaList.containsKey(movie.getYear())) {
            movieTemp = cinemaList.get(movie.getYear());
        } else {
            movieTemp = new LinkedHashSet<>();
        }
        movieTemp.add(movie);
        cinemaList.put(movie.getYear(), movieTemp);
    }

    public Set<Movie> getAllMoviesByYear(Integer year) {
        Set<Movie> result = null;
        if (cinemaList.containsKey(year)) {
            result = cinemaList.get(year);
        }
        return result;
    }

    public List<Movie> getAllMoviesByYearAndMonth(Integer year, Month month) {
        List<Movie> result;
        if (cinemaList.containsKey(year)) {
            result = new LinkedList<>(cinemaList.get(year));
        } else {
            result = null;
        }
        if (result != null) {
            ListIterator<Movie> listIterator = result.listIterator();
            while (listIterator.hasNext()) {
                Movie nextMovie = listIterator.next();
                if (!nextMovie.getMonth().equals(month)) {
                    listIterator.remove();
                }
            }
        }
        return result;
    }

    public List<Movie> getAllMoviesByGenre(Genre genre) {
        List<Movie> result = new ArrayList<>();
        for (LinkedHashSet<Movie> movieList : cinemaList.values()) {
            for (Movie movie : movieList) {
                if (movie.getGenre().equals(genre)) {
                    result.add(movie);
                }
            }
        }
        return result;
    }

    public List<Movie> getTopTen() {
        List<Movie> tempResult = new ArrayList<>();
        for (LinkedHashSet<Movie> movieList : cinemaList.values()) {
            tempResult.addAll(movieList);
        }
        tempResult.sort(new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return -(o1.getRating().getRatingValue() - o2.getRating().getRatingValue());
            }
        });
        int size = Math.min(tempResult.size(), 10);
        return tempResult.subList(0, size);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "cinemaList=" + cinemaList +
                '}';
    }
}
