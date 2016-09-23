import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  private Client client;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    client = new Client("Karen", "Freeman", "503-331-2346", "1710 Henderson Ave", "Eugene", "OR", 97403, "karen@sample.com", 50, "allergies");
  }

  @Test
  public void Client_instantiates_true() {
    assertEquals(true, client instanceof Client);
  }

  @Test
  public void save_returnsIdFromDatabase_true() {
    assertEquals(true, client.getId()>0);
  }


  @Test
  public void find_returnCorrectClient_true() {
    assertTrue(Client.find(client.getId()).getEmail().equals(client.getEmail()));
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
