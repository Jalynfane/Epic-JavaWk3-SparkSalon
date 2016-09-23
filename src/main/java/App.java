import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("appointents", Appointment.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("appointment", request.queryParams("day"));
      model.put("appointents", Appointment.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("clients", Client.all());
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Client client = new Client(
        request.queryParams("first"),
        request.queryParams("last"),
        request.queryParams("phone"),
        request.queryParams("address"),
        request.queryParams("city"),
        request.queryParams("state"),
        Integer.parseInt(request.queryParams("zip")),
        request.queryParams("email"),
        Integer.parseInt(request.queryParams("age")),
        request.queryParams("notes")
      );
      model.put("first", client.getFirstName());
      model.put("last", client.getLastName());
      model.put("phone", client.getPhoneNumber());
      model.put("address", client.getAddress());
      model.put("city", client.getCity());
      model.put("state", client.getState());
      model.put("zip", client.getZip());
      model.put("email", client.getEmail());
      model.put("age", client.getAge());
      model.put("notes", client.getNotes());
      model.put("clients", Client.all());
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Stylist stylist = new Stylist(request.queryParams("stylist"));
      model.put("stylist", stylist.getName());
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/procedures", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("procedures", Procedure.all());
      model.put("template", "templates/procedure.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/procedures", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Procedure procedure = new Procedure(request.queryParams("procedure"), Float.parseFloat(request.queryParams("price")));
      model.put("procedure", procedure.getDescription());
      model.put("price", procedure.getPrice());
      model.put("procedures", Procedure.all());
      model.put("template", "templates/procedure.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
