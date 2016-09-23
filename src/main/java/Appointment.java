import org.sql2o.*;
import java.util.List;

public class Appointment {
  private int id;
  private String time;
  private int clientid;
  private int procedureid;

  public Appointment (String time, int clientid, int procedureit) {
    this.time = time;
    this.clientid = clientid;
    this.procedureid = procedureid;
    
  }

  // public static List<Task> all() {
  //   String sql = "SELECT id, description FROM tasks";
  //   try(Connection con = DB.sql2o.open()) {
  //     return con.createQuery(sql).executeAndFetch(Task.class);
  //   }
  // }

  // @Override
  // public boolean equals(Object otherTask) {
  //   if (!(otherTask instanceof Task)) {
  //     return false;
  //   } else {
  //     Task newTask = (Task) otherTask;
  //     return this.getDescription().equals(newTask.getDescription());
  //   }
  // }
}
