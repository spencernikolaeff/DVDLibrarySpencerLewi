# DVDLibrarySpencerLewi
our group project for further implementing the DVD Library


NOTES FOR PROJECT


Requirements
You will add the following features to your program:

Find all movies released in the last N years
    ADD YEAR METHOD TO DVD DTO OR DAO?
    
  hmap.stream()
    .filter((DVD) -> DVD.getYear()
  List<DVD> lastNYears = hmap.stream()
    .filter((DVD) -> DVD.getYear()
    .collect(Collectors.toList());
    
    
Find all the movies with a given MPAA rating
    ***similar stuff from above***
    .filter((DVD) -> DVD.getRating() == G)
    
Find all the movies by a given director
    ***
    .filter((DVD) -> DVD.getDirector() == "director")
    
When searching by director, the movies should be sorted into separate data structures by MPAA rating.
    ***
    .filter((DVD) -> DVD.getDirector() ???
    
Find all the movies released by a particular studio
    ***
    .filter((DVD) -> DVD.getStudio() == "studio")
    
Find the average age of the movies in the collection
    ***
    ??? in years, days, months?
    
Find the newest movie in your collection
Find the oldest movie in your collection
Find the average number of notes associated with movies in your collection
