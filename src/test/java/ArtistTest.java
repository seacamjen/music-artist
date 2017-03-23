import org.junit.*;
import static org.junit.Assert.*;

public class ArtistTest {

  @After
  public void tearDown(){
    Artist.clearList();
  }

  @Test
  public void Artist_instantiatesCorrectly_true() {
    Artist myArtist = new Artist("The Beats");
    assertEquals(true, myArtist instanceof Artist);
  }

  @Test
  public void Arist_instantiatesWithName_String() {
    Artist myArtist = new Artist("The Beats");
    assertEquals("The Beats", myArtist.getName());
  }

  @Test
  public void all_returnsAllInstancesofArtist_true() {
    Artist firstArtist = new Artist("The Beats");
    Artist secondArtist = new Artist("The Cheats");
    assertEquals(true, Artist.all().contains(firstArtist));
    assertEquals(true, Artist.all().contains(secondArtist));
  }

  @Test
  public void clearList_emptiesAllArtistsFromArrayList_0() {
    Artist myArtist = new Artist("The Beats");
    Artist.clearList();
    assertEquals(0, Artist.all().size());
  }

  @Test
  public void getId_artistsInstantiatesWithAnId_1() {
    Artist.clearList();
    Artist myArtist = new Artist("The Weeps");
    assertEquals(1, myArtist.getId());
  }

  @Test
  public void find_returnsArtistWithSameId_secondArtist() {
    Artist firstArtist = new Artist("The Beeps");
    Artist secondArtist = new Artist("The Cheaps");
    assertEquals(secondArtist, Artist.find(secondArtist.getId()));
  }
}
