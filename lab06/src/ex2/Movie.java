package ex2;

import java.util.List;
import java.sql.Array;
import java.util.ArrayList;

class MovieBuilder {
   private String title;
   private int year;
   private Person director;
   private Person writer;
   private String series;
   private List<Person> cast;
   private List<Place> locations;
   private List<String> languages;
   private List<String> genres;
   private boolean isTelevision;
   private boolean isNetflix;
   private boolean isIndependent;


   public MovieBuilder() {
      this.reset();
   }

   public MovieBuilder reset() {
      this.title = "";
      this.year = 0;
      this.director = null;
      this.writer = null;
      this.series = null;
      this.cast = new ArrayList<>();
      this.locations = new ArrayList<>();
      this.languages = new ArrayList<>();
      this.genres = new ArrayList<>();
      this.isTelevision = false;
      this.isNetflix = false;
      this.isIndependent = false;

      return this;
   }


   public MovieBuilder setTitle(String title) {
      this.title = title;
      return this;
   }

   public MovieBuilder setYear(int year) {
      this.year = year;
      return this;
   }


   public MovieBuilder setDirector(Person director) {
      this.director = director;
      return this;
   }

   public MovieBuilder setDirector(String directorFirstName, String directorLastName) {
      this.director = new Person(directorFirstName, directorLastName);
      return this;
   }


   public MovieBuilder setWriter(Person writer) {
      this.writer = writer;
      return this;
   }

   public MovieBuilder setWriter(String writerFirstName, String writerLastName) {
      this.writer = new Person(writerFirstName, writerLastName);
      return this;
   }


   public MovieBuilder setSeries(String series) {
      this.series = series;
      return this;
   }


   public MovieBuilder addCastMember(Person castMember) {
      this.cast.add(castMember);
      return this;
   }

   public MovieBuilder addCastMember(String castMemberFirstName, String castMemberLastName) {
      this.cast.add(new Person(castMemberFirstName, castMemberLastName));
      return this;
   }


   public MovieBuilder addLocation(Place location) {
      this.locations.add(location);
      return this;
   }

   public MovieBuilder addLocation(String locationName, String locationCity, String locationCountry) {
      this.locations.add(new Place(locationName, locationCity, locationCountry));
      return this;
   }

   public MovieBuilder addLocation(String locationCity, String locationCountry) {
      this.locations.add(new Place(locationCity, locationCountry));
      return this;
   }


   public MovieBuilder addLanguage(String language) {
      this.languages.add(language);
      return this;
   }


   public MovieBuilder addGenre(String genre) {
      this.genres.add(genre);
      return this;
   }


   public MovieBuilder setTelevistion() {
      this.isTelevision = true;
      this.isNetflix = false;
      this.isIndependent = false;
      return this;
   }

   public MovieBuilder setNetflix() {
      this.isTelevision = false;
      this.isNetflix = true;
      this.isIndependent = false;
      return this;
   }

   public MovieBuilder setIndependent() {
      this.isTelevision = false;
      this.isNetflix = false;
      this.isIndependent = true;
      return this;
   }

   public Movie build() {
      return new Movie(
         this.title,
         this.year,
         this.director,
         this.writer,
         this.series,
         this.cast,
         this.locations,
         this.languages,
         this.genres,
         this.isTelevision,
         this.isNetflix,
         this.isIndependent
      );
   }

}

public class Movie {
   private final String title;
   private final int year;
   private final Person director;
   private final Person writer;
   private final String series;
   private final List<Person> cast;
   private final List<Place> locations;
   private final List<String> languages;
   private final List<String> genres;
   private final boolean isTelevision;
   private final boolean isNetflix;
   private final boolean isIndependent;

   public Movie(
      final String movieTitle,
      final int movieYear,
      final Person movieDirector,
      final Person movieWriter,
      final String movieSeries,
      final List<Person> movieCast,
      final List<Place> movieLocations,
      final List<String> movieLanguages,
      final List<String> movieGenres,
      final boolean television,
      final boolean netflix,
      final boolean independent)    {
      this.title = movieTitle;
      this.year = movieYear;
      this.director = movieDirector;
      this.writer = movieWriter;
      this.series = movieSeries;
      this.cast = movieCast;
      this.locations = movieLocations;
      this.languages = movieLanguages;
      this.genres = movieGenres;
      this.isTelevision = television;
      this.isNetflix = netflix;
      this.isIndependent = independent;
   }

   public static MovieBuilder Builder() {
      return new MovieBuilder();
   }

   @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();

      sb.append("Title: ").append(title).append("\n");
      sb.append("Year: ").append(year).append("\n");

      if (director != null) sb.append("Director: ").append(director.toString()).append("\n");
      if (writer != null) sb.append("Writer: ").append(writer.toString()).append("\n");
      if (series != null) sb.append("Series: ").append(series).append("\n");

      sb.append("Cast: ");
      for (Person person : cast) {
         sb.append(person.toString()).append("; ");
      }
      sb.append("\n");

      sb.append("Locations: ");
      for (Place movieLocation : locations) {
         sb.append(movieLocation.toString()).append("; ");
      }
      sb.append("\n");

      sb.append("Languages: ");
      for (String language : languages) {
         sb.append(language).append("; ");
      }
      sb.append("\n");

      sb.append("Genres: ");
      for (String genre : genres) {
         sb.append(genre).append("; ");
      }
      sb.append("\n");

      sb.append("Television: ").append(isTelevision).append("\n");
      sb.append("Netflix: ").append(isNetflix).append("\n");
      sb.append("Independent: ").append(isIndependent).append("\n");
      
      return sb.toString();
   }
}

