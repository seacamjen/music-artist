import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/genres/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/genre-new-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/genres/:id/artists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.params(":id")));
      model.put("type", genre);
      model.put("template", "templates/genre-artist-new-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/genres", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String type = request.queryParams("type");
      Genre newGenre = new Genre(type);
      model.put("template", "templates/genres-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/genres/:id/artists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.params(":id")));
      model.put("type", genre);
      String name = request.queryParams("name");
      Artist newArtist = new Artist(name);
      model.put("template", "templates/artist-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/genres", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("genres", Genre.all());
      model.put("template", "templates/all-genres.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/genres/:id/artists", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.params(":id")));
      // Artist artist = Artist.find(Integer.parseInt(request.params(":id1")));
      model.put("type", genre);
      // model.put("name", artist);

      // if (Artist.all().size()!=0){
      //     model.put("artists", Artist.all());
      // } This is an option for if statement in all-artists.vtl
      model.put("artists", Artist.all());
      model.put("template", "templates/all-artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/genres/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.params(":id")));
      model.put("type", genre);
      model.put("template", "templates/genre.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("genres/:id/artists/:id1", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Genre genre = Genre.find(Integer.parseInt(request.params(":id")));
      Artist artist = Artist.find(Integer.parseInt(request.params(":id1")));
      model.put("type", genre);
      model.put("name", artist);
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
