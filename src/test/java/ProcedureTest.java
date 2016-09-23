import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ProcedureTest {
  private Procedure procedure;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    procedure = new Procedure("hair cut & color", 25.00f);
  }

  @Test
  public void Procedure_instantiates_true() {
    assertEquals(true, procedure instanceof Procedure);
  }

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
