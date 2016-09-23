import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class AppointmentTest {
  private Appointment appointment;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    appointment = new Appointment("2016-10-19 10:00", 1, 1);
  }

  @Test
  public void Appointment_instantiates_true() {
    assertEquals(true, appointment instanceof Appointment);
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
