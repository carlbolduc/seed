package seed.resources;

import seed.views.HomeView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class HomeResource {

    public HomeResource() {}

    @GET
    public HomeView getHome(@QueryParam("l") String l) {
        return new HomeView(l);
    }
}
