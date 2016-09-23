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
  public void getFirstName_returnsCorrectName_String() {
    assertEquals("Karen", client.getFirstName());
  }

  @Test
  public void setFristName_updatesName_String() {
    client2.setFirstName("Steve");
    assertEquals("Steve", Client.find(client2.getId()).getFirstName());
  }

  @Test
  public void getLastName_returnsCorrectName_String() {
    assertEquals("Freeman", client.getLastName());
  }

  @Test
  public void setLastName_updatesName_String() {
    client2.setFirstName("Freeman");
    assertEquals("Freeman", Client.find(client2.getId()).getFirstName());
  }

  @Test
  public void getPhoneNumber_returnsCorrectPhoneNumber_String() {
    assertEquals("503-331-2346", client.getPhoneNumber());
  }

  @Test
  public void setPhoneNumber_updatesPhoneNumber_String() {
    client2.setPhoneNumber("503-331-2346");
    assertEquals("503-331-2346", Client.find(client2.getId()).getPhoneNumber());
  }

  @Test
  public void getAddress_returnsCorrectAddress_String() {
    assertEquals("1710 Henderson Ave", client.getAddress());
  }

  @Test
  public void setAddress_updatesAddress_String() {
    client2.setAddress("1710 Henderson Ave");
    assertEquals("1710 Henderson Ave", Client.find(client2.getId()).getAddress());
  }


  @Test
  public void getCity_returnsCorrectCity_String() {
    assertEquals("Eugene", client.getCity());
  }

  @Test
  public void setCity_updatesCity_String() {
    client2.setCity("Eugene");
    assertEquals("Eugene", Client.find(client2.getId()).getCity());
  }

  @Test
  public void getState_returnsCorrectState_String() {
    assertEquals("OR", client.getState());
  }

  @Test
  public void setState_updatesState_String() {
    client2.setState("CA");
    assertEquals("CA", Client.find(client2.getId()).getState());
  }

  @Test
  public void getZip_returnsCorrectZip_int() {
    assertEquals(97403, client.getZip());
  }

  @Test
  public void setZip_updatesZip_int() {
    client2.setZip(97403);
    assertEquals(97403, Client.find(client2.getId()).getZip());
  }

  @Test
  public void getEmail_returnsCorrectEmail_String() {
    assertEquals("karen@sample.com", client.getEmail());
  }

  @Test
  public void setEmail_updatesEmail_String() {
    client2.setEmail("karen@sample.com");
    assertEquals("karen@sample.com", Client.find(client2.getId()).getEmail());
  }

  @Test
  public void getAge_returnsCorrectAge_String() {
    assertEquals(50, client.getAge());
  }

  @Test
  public void setFristAge_updatesAge_int() {
    client2.setAge(52);
    assertEquals(52, Client.find(client2.getId()).getAge());
  }

  @Test
  public void getNotes_returnsCorrectNotes_String() {
    assertEquals("allergies", client.getNotes());
  }

  @Test
  public void setNotes_updatesNotes_String() {
    client2.setNotes("allergies");
    assertEquals("allergies", Client.find(client2.getId()).getNotes());
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

  @Test
  public void delete_deletesClient_true() {
    int clientId = client2.getId();
    Client.delete(clientId);
    assertEquals(null, Client.find(clientId));
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
