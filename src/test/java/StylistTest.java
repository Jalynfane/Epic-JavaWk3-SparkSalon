import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {
  private Stylist stylist;
  private Stylist stylist2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    stylist = new Stylist("Cheryl");
    stylist2 = new Stylist("Cheryl");
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
  public void getName_returnsCorrectName_String() {
    assertEquals("Cheryl", stylist.getName());
  }

  @Test
  public void setName_updatesName_String() {
    stylist.setName("Steve");
    assertEquals("Steve", Stylist.find(stylist.getId()).getName());
  }

  @Test
  public void find_returnCorrectStylist_true() {
    assertTrue(Stylist.find(stylist.getId()).getName().equals(stylist.getName()));
  }

  @Test
  public void Stylist_returnsAllInstances_true() {
    assertTrue(Stylist.all().size()>1);
  }


  @Test
  public void delete_deletesStylist_true() {
    int stylistId = stylist2.getId();
    Stylist.delete(stylistId);
    assertEquals(null, Stylist.find(stylistId));
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
