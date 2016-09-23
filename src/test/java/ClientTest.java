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



  // @Test
  // public void Task_instantiates_true() {
  //   assertEquals(true, task instanceof Task);
  // }

  // @Test
  // public void equals_returnsTrueIfDescriptionsAretheSame() {
  //   Task firstTask = new Task("Mow the lawn");
  //   Task secondTask = new Task("Mow the lawn");
  //   assertTrue(firstTask.equals(secondTask));
  // }

  // @After
  // public void tearDown() {
  //   Task.clear();
  //   try(Connection con = DB.sql2o.open()) {
  //     String sql = "DELETE FROM tasks *;";
  //     con.createQuery(sql).executeUpdate();
  //   }
  // }
}
