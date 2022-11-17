package seed.resources;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import seed.api.Policy;
import seed.db.Dao;
import seed.views.PoliciesView;
import seed.views.PolicyView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/policies")
@Produces(MediaType.TEXT_HTML)
public class PoliciesResource {
    private final Dao dao;
    private final Parser parser;
    private final HtmlRenderer renderer;

    public PoliciesResource(Dao dao, Parser parser, HtmlRenderer renderer) {
        this.dao = dao;
        this.parser = parser;
        this.renderer = renderer;
    }

    @GET
    public PoliciesView getPolicies(@QueryParam("l") String l) {
        return new PoliciesView(dao.findPolicies(), l);
    }

    @GET
    @Path("/{slug}")
    public Response getPolicy(@PathParam("slug") String slug, @QueryParam("l") String l) {
        Response response = Response.status(Response.Status.NOT_FOUND).build();
        Policy policy = dao.findPolicyBySlug(slug);
        if (policy != null) {
            response = Response.ok(new PolicyView(policy, l, parser, renderer)).build();
        }
        return response;
    }
}
