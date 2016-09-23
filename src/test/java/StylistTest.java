import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  private Stylist stylist;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    stylist = new Stylist("Cheryl");
  }

  @Test
  public void Stylist_instantiates_true() {
    assertEquals(true, stylist instanceof Stylist);
  }

  @Test
  public void save_returnsIdFromDatabase_true() {
    assertEquals(true, stylist.getId()>0);
  }

  @Test
  public void find_returnCorrectStylist_true() {
    assertTrue(Stylist.find(stylist.getId()).getName().equals(stylist.getName()));
  }


  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
