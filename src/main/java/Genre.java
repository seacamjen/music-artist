import java.util.List;
import java.util.ArrayList;

public class Genre {
  private String mType;
  private static List<Genre> instances = new ArrayList<Genre>();
  private int mId;

  public Genre(String type) {
      mType = type;
      instances.add(this);
      mId = instances.size();
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
}
