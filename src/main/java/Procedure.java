import org.sql2o.*;
import java.util.List;

public class Procedure {
  private int id=0;
  private String description;
  private float price;

  public Procedure(String description, float price) {
    this.description=description;
    this.price=price;

    try(Connection cn = DB.sql2o.open()) {
      String sql = "INSERT INTO procedures (description, price) VALUES (:description, :price)";
      this.id = (int) cn.createQuery(sql, true)
        .addParameter("description", this.description)
        .addParameter("price", this.price)
        .executeUpdate()
        .getKey();
    }
  }

  public int getId() {
    return id;
  }


}
