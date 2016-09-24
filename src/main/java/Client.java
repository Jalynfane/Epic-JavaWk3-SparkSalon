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

  public Client(String firstname, String lastname, String phone, String street, String city, String state, int zip, String email, int age, String notes, int stylistid) {
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
    this.stylistid = stylistid;

    try(Connection cn = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (firstname, lastname, phonenumber, address, city, state, zip, email, age, notes, stylistid) VALUES (:firstname, :lastname, :phonenumber, :address, :city, :state, :zip, :email, :age, :notes, :stylistid)";
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
        .addParameter("stylistid", this.stylistid)
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

  public void setStylistId(int stylistid) {
    this.stylistid=stylistid;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET stylistid = :stylistid WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("stylistid", stylistid)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getFirstName() {
    return firstname;
  }

  public void setFirstName(String name) {
    this.firstname=name;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET firstname = :firstname WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("firstname", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getLastName() {
    return lastname;
  }

  public void setLastName(String name) {
    this.lastname=name;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET lastname = :lastname WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("lastname", name)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getPhoneNumber() {
    return phonenumber;
  }

  public void setPhoneNumber(String phone) {
    this.phonenumber=phone;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET phonenumber = :phonenumber WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("phonenumber", phone)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address=address;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET address = :address WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("address", address)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city=city;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET city = :city WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("city", city)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state=state;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET state = :state WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("state", state)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public int getZip() {
    return zip;
  }

  public void setZip(int zip) {
    this.zip=zip;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET zip = :zip WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("zip", zip)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email=email;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET email = :email WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("email", email)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age=age;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET age = :age WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("age", age)
        .addParameter("id", id)
        .executeUpdate();
    }
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes=notes;
    try(Connection cn = DB.sql2o.open()) {
      String sql = "UPDATE clients SET notes = :notes WHERE id = :id";
      cn.createQuery(sql)
        .addParameter("notes", notes)
        .addParameter("id", id)
        .executeUpdate();
    }
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

  public static List<Client> allByStylist(int id) {
    String sql = "SELECT * FROM clients WHERE stylistid = :id ORDER BY lastname, firstname, age";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetch(Client.class);
    }
  }

  public static List<Client> all() {
    String sql = "SELECT * FROM clients ORDER BY lastname, firstname, age";
    try(Connection cn = DB.sql2o.open()) {
      return cn.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public static void delete(int id) {
    try(Connection cn = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id = :id;";
      cn.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

}
