import java.util.List;
import java.util.ArrayList;

public class Genre {
  private String mType;
  private static List<Genre> instances = new ArrayList<Genre>();
  private int mId;
  private List<Artist> mArtists;

  public Genre(String type) {
      mType = type;
      instances.add(this);
      mId = instances.size();
      mArtists = new ArrayList<Artist>();
  }

  public String getType() {
    return mType;
  }

  public static List<Genre> all() {
    return instances;
  }

  public static void clearList() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Genre find(int id) {
    return instances.get(id - 1);
  }

  public List<Artist> getArtists() {
    return mArtists;
  }

  public void addArtist(Artist artist) {
    mArtists.add(artist);
  }
}
