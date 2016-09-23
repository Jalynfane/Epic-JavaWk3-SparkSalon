import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ProcedureTest {
  private Procedure procedure;
  private Procedure procedure2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    procedure = new Procedure("hair cut & color", 25.00f);
    procedure2 = new Procedure("women's haircut", 50.00f);
  }

  @Test
  public void Procedure_instantiates_true() {
    assertEquals(true, procedure instanceof Procedure);
  }

  @Test
  public void save_returnsIdFromDatabase_true() {
    assertEquals(true, procedure.getId()>0);
  }

  @Test
  public void getDescription_returnsCorrectDescription_String() {
    assertEquals("hair cut & color", procedure.getDescription());
  }

  @Test
  public void setDescription_updatesDescription_String() {
    procedure.setDescription("men's haircut");
    assertEquals("men's haircut", Procedure.find(procedure.getId()).getDescription());
  }

  @Test
  public void getPrice_returnsCorrectPrice_Float() {
    assertEquals(25.0f, procedure.getPrice(), 0.005);
  }

  @Test
  public void setPrice_updatesPrice_Float() {
    procedure.setPrice(25.0f);
    assertEquals(25.0, Procedure.find(procedure.getId()).getPrice(), 0.005);
  }

  @Test
  public void find_returnCorrectProcedure_true() {
    assertTrue(Procedure.find(procedure.getId()).getDescription().equals(procedure.getDescription()));
  }

  @Test
  public void Procedure_returnsAllInstances_true() {
    assertTrue(Procedure.all().size()>1);
  }


  @Test
  public void delete_deletesProcedure_true() {
    int procedureId = procedure2.getId();
    Procedure.delete(procedureId);
    assertEquals(null, Procedure.find(procedureId));
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM procedures *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
