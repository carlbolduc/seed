package seed.views;

import io.dropwizard.views.View;
import seed.api.Post;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class PostsView extends View {
    private final List<Post> posts;

    public PostsView(List<Post> posts, String l) {
        super(l != null && l.equals("fr") ? "posts_fr.ftl" : "posts.ftl", StandardCharsets.UTF_8);
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
