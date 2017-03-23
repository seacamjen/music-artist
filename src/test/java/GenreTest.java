import org.junit.*;
import static org.junit.Assert.*;

public class GenreTest {

  @After
  public void tearDown() {
    Genre.clearList();
  }

  @Test
  public void genre_instantiatesCorrectly_true() {
    Genre testGenre = new Genre("Chill");
    assertEquals(true, testGenre instanceof Genre);
  }

  @Test
  public void getType_genreInstantiatesWithType_String() {
    Genre testGenre = new Genre("Chill");
    assertEquals("Chill", testGenre.getType());
  }

  @Test
  public void all_returnsAllInstancesofGenre_true() {
    Genre firstGenre = new Genre("Chill");
    Genre secondGenre = new Genre("No-chill");
    assertEquals(true, Genre.all().contains(firstGenre));
    assertEquals(true, Genre.all().contains(secondGenre));
  }

  @Test
  public void clearList_emptiesAllGenresFromList_0() {
    Genre testGenre = new Genre("Chill");
    Genre.clearList();
    assertEquals(0, Genre.all().size());
  }

  @Test
  public void getId_genresInstantiatesWithAnId_1() {
    Genre testGenre = new Genre("Chill");
    assertEquals(1, testGenre.getId());
  }

  @Test
  public void find_returnsGenreWithSameId_secondGenre() {
    Genre firstGenre = new Genre("Chill");
    Genre secondGenre = new Genre("No-chill");
    assertEquals(secondGenre, Genre.find(secondGenre.getId()));
  }
}
