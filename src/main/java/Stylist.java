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


}
