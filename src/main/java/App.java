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
      model.put("stylists", Stylist.all());
      model.put("template", "templates/client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/clients/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      model.put("client", Client.find(id));
      model.put("stylists", Stylist.all());
      model.put("template", "templates/edit-client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/clients/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Client.find(id).setStylistId(Integer.parseInt(request.queryParams("stylist")));
      Client.find(id).setFirstName(request.queryParams("first"));
      Client.find(id).setLastName(request.queryParams("last"));
      Client.find(id).setPhoneNumber(request.queryParams("phone"));
      Client.find(id).setAddress(request.queryParams("address"));
      Client.find(id).setCity(request.queryParams("city"));
      Client.find(id).setState(request.queryParams("state"));
      Client.find(id).setZip(Integer.parseInt(request.queryParams("zip")));
      Client.find(id).setEmail(request.queryParams("email"));
      Client.find(id).setAge(Integer.parseInt(request.queryParams("age")));
      Client.find(id).setNotes(request.queryParams("notes"));
      model.put("client", Client.find(id));
      model.put("stylists", Stylist.all());
      model.put("template", "templates/edit-client.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/delete/clients/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Client.delete(id);
      response.redirect("/clients");
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
        request.queryParams("notes"),
        Integer.parseInt(request.queryParams("stylist"))
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
      model.put("stylists", Stylist.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      model.put("stylist", Stylist.find(id));
      model.put("clients", Client.allByStylist(id));
      model.put("template", "templates/edit-stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/stylists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Stylist.find(id).setName(request.queryParams("first"));
      model.put("stylist", Stylist.find(id));
      model.put("clients", Client.allByStylist(id));
      model.put("template", "templates/edit-stylist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/delete/stylists/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Stylist.delete(id);
      response.redirect("/stylists");
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

    get("/procedures/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      model.put("procedure", Procedure.find(id));
      model.put("template", "templates/edit-procedure.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/procedures/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Procedure.find(id).setDescription(request.queryParams("first"));
      Procedure.find(id).setPrice(Float.parseFloat(request.queryParams("age")));
      model.put("procedures", Procedure.all());
      model.put("template", "templates/procedure.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/delete/procedures/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int id = Integer.parseInt(request.params(":id"));
      Procedure.delete(id);
      response.redirect("/procedures");
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
