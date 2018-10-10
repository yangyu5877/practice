package corejava;

import java.util.*;

/**
 * Created by yangyou on 2018/10/9.
 */
public class Comparetest {


    public static void main(String[] args) {
        Movie m1 = new Movie(1, "122", 1234);
        Movie m2 = new Movie(3, "sdf", 1586);
        Movie m3 = new Movie(2, "vvfdss", 11);
        Movie m4 = new Movie(4, "ssdaaaa", 6);
        List<Movie> movies = Arrays.asList(m1, m2, m3, m4);
//        Collections.sort(movies);
        movies.stream().forEach(System.out::println);
        YearComparator y = new YearComparator();
        movies.sort(y);
        movies.stream().forEach(System.out::println);



    }



    static class YearComparator implements Comparator<Movie> {

        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getYear() - o2.getYear();
        }
    }



    static class Movie implements Comparable<Movie> {
        public Movie(int rate, String name, int year) {
            this.rate = rate;
            this.name = name;
            this.year = year;
        }

        private int rate;

        private String name;

        private int year;


        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        @Override
        public int compareTo(Movie o) {
            return this.rate - o.rate;
        }
        @Override
        public String toString() {
            return this.name + " " + this.rate + " " + this.year;
        }
    }

}
