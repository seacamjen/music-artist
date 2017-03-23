import java.util.ArrayList;
import java.util.List;

public class Artist {
  private String mName;
  private static List<Artist> instances = new ArrayList<Artist>();
  private int mId;

  public Artist(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
  }

  public String getName() {
    return mName;
  }

  public static List<Artist> all() {
    return instances;
  }

  public static void clearList() {
    instances.clear();
  }

  public int getId() {
    return mId;
  }

  public static Artist find(int id) {
    return instances.get(id - 1);
  }
}
