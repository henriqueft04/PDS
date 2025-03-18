package ex2;

public class Lab06ex2 {
    public static void main(String[] args) {
        MovieBuilder mb = new MovieBuilder()
                            .setTitle("Guys and Dolls")
                            .setYear(1955)
                            .setDirector("Joseph", "Mankiewicz")
                            .setWriter("Joseph", "Mankiewicz")
                            .addCastMember("Frank", "Sinatra") // we can call addCastMember(String, String) ...
                            .addCastMember(new Person("Marlon", "Brando")) // ... or addCastMember(Person)
                            .addLocation(new Place("Hollywood", "Los Angeles", "USA")) // and we can call addLocation(Place) ...
                            .addLocation( "New York", "USA") // ... or addLocation(String, String)
                            .addLanguage("English")
                            .addGenre("Musical");
        
        Movie movie = mb.build();
        System.out.println(movie);

        mb.reset()
            .setTitle("The Godfather")
            .setYear(1972)
            .setDirector("Francis Ford", "Coppola")
            .addCastMember("Marlon", "Brando")
            .addCastMember("Al", "Pacino")
            .addLocation( "New York", "USA")
            .addLocation("Sicily", "Italy")
            .addLanguage("English")
            .addLanguage("Italian")
            .addGenre("Crime")
            .addGenre("Drama");
        
        movie = mb.build();
        System.out.println(movie);
    }
}
