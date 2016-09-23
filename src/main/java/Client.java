import org.sql2o.*;
import java.util.List;

public class Client {
  private int id=0;
  private int stylistid=0;
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

    try(Connection cn = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (firstname, lastname, phonenumber, address, city, state, zip, email, age, notes) VALUES (:firstname, :lastname, :phonenumber, :address, :city, :state, :zip, :email, :age, :notes)";
      this.id = (int) cn.createQuery(sql, true)
        .addParameter("lastname", this.lastname)
        .addParameter("firstname", this.firstname)
        .addParameter("phonenumber", this.phonenumber)
        .addParameter("address", this.address)
        .addParameter("city", this.city)
        .addParameter("state", this.state)
        .addParameter("zip", this.zip)
        .addParameter("email", this.email)
        .addParameter("age", this.age)
        .addParameter("notes", this.notes)
        .executeUpdate()
        .getKey();
    }

  }

  public int getId() {
    return id;
  }

  public int getStylistId() {
    return stylistid;
  }

  public String getFirstName() {
    return firstname;
  }

  public String getLastName() {
    return lastname;
  }

  public String getPhoneNumber() {
    return phonenumber;
  }

  public String getAddress() {
    return address;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public int getZip() {
    return zip;
  }

  public String getEmail() {
    return email;
  }

  public int getAge() {
    return age;
  }

  public String getNotes() {
    return notes;
  }

  public static Client find(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id=:id";
      Client client = cn.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

}
