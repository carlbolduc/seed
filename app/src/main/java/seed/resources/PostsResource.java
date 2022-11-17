package seed.resources;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import seed.api.Post;
import seed.db.Dao;
import seed.views.PostView;
import seed.views.PostsView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/posts")
@Produces({MediaType.TEXT_HTML})
public class PostsResource {
    private final Dao dao;
    private final Parser parser;
    private final HtmlRenderer renderer;

    public PostsResource(Dao dao, Parser parser, HtmlRenderer renderer) {
        this.dao = dao;
        this.parser = parser;
        this.renderer = renderer;
    }

    @GET
    public PostsView getBlogPosts(@QueryParam("l") String l) {
        return new PostsView(dao.findBlogPosts(), l);
    }

    @GET
    @Path("/{slug}")
    public Response getBlogPost(@PathParam("slug") String slug, @QueryParam("l") String l) {
        Response response = Response.status(Response.Status.NOT_FOUND).build();
        Post post = dao.findBlogPostBySlug(slug);
        if (post != null) {
            response = Response.ok(new PostView(post, l, parser, renderer)).build();
        }
        return response;
    }
}
