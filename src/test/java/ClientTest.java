import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {
  private Client client;
  private Client client2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    client = new Client("Karen", "Freeman", "503-331-2346", "1710 Henderson Ave", "Eugene", "OR", 97403, "karen@sample.com", 50, "allergies");
    client2 = new Client("Karen", "Smith", "503-883-9533", "5392 Knightwood Drive", "Klamath Falls", "OR", 97603, "ksmith@sample.com", 18, "new client");
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

  @Test
  public void Client_returnsAllInstances_true() {
    assertTrue(Client.all().size()>1);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
