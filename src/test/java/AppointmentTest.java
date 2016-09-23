import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class AppointmentTest {
  private Appointment appointment;
  private Appointment appointment2;

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
    appointment = new Appointment("2016-10-19 10:00:00", 1, 1);
    appointment2 = new Appointment("2016-10-19 9:00:00", 1, 1);
  }

  @Test
  public void Appointment_instantiates_true() {
    assertEquals(true, appointment instanceof Appointment);
  }

  @Test
  public void save_returnsIdFromDatabase_true() {
    assertEquals(true, appointment.getId()>0);
  }

  @Test
  public void find_returnCorrectAppointment_true() {
    assertTrue(Appointment.find(appointment.getId()).getTime().equals(appointment.getTime()));
  }

  @Test
  public void Appointment_returnsAllInstances_true() {
    assertTrue(Appointment.all().size()>1);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM appointments *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
