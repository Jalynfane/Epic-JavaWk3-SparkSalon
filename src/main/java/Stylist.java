import org.sql2o.*;
import java.util.List;

public class Stylist {
  private String name;
  private int id=0;

  public Stylist(String name) {
    this.name=name;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists (name) VALUES (:name)";
      this.id = (int) cn.createQuery(sql, true)
        .addParameter("name", this.name)
        .executeUpdate()
        .getKey();
    }
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static Stylist find(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id";
      Stylist stylist = cn.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public static List<Stylist> all() {
    String sql = "SELECT * FROM stylists ORDER BY name";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

}
