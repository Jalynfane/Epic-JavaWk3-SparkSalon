import org.sql2o.*;
import java.util.List;

public class Client {
  private int id;
  private String firstname;
  private String lastname;
  private String phonenumber;
  private String address;
  private String city;
  private String state;
  private int zip;
  private String email;
  private int age;
  private String notes;

  public Client(String firstname, String lastname, String phone, String street, String city, String state, int zip, String email, int age, String notes) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.phonenumber = phone;
    this.address = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.email = email;
    this.age = age;
    this.notes = notes;

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
