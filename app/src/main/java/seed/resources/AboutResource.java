package seed.resources;

import seed.views.AboutView;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/about")
@Produces(MediaType.TEXT_HTML)
public class AboutResource {

    public AboutResource() {}

    @GET
    public AboutView getHome(@QueryParam("l") String l) {
        return new AboutView(l);
    }
}
