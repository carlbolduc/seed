package seed.db;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import seed.api.Policy;
import seed.api.Post;

import java.util.List;

public interface Dao {

    @SqlQuery("SELECT bidu")
    String healthCheck();


    @SqlQuery("SELECT title_en, title_fr, slug FROM policy WHERE slug <> '' AND published IS TRUE ORDER BY display_order")
    @RegisterBeanMapper(Policy.class)
    List<Policy> findPolicies();

    @SqlQuery("SELECT title_en, title_fr, description_en, description_fr, content_en, content_fr, slug, updated_at FROM policy WHERE slug = :slug AND published IS TRUE")
    @RegisterBeanMapper(Policy.class)
    Policy findPolicyBySlug(@Bind("slug") String slug);

    @SqlQuery("SELECT title_en, title_fr, slug, published_on FROM post WHERE slug <> '' AND category = 'blog-post' AND published_on < unixepoch() ORDER BY published_on DESC")
    @RegisterBeanMapper(Post.class)
    List<Post> findBlogPosts();

    @SqlQuery("SELECT title_en, title_fr, description_en, description_fr, content_en, content_fr, slug, published_on FROM post WHERE category = 'blog-post' AND published_on < unixepoch() AND slug = :slug")
    @RegisterBeanMapper(Post.class)
    Post findBlogPostBySlug(@Bind("slug") String slug);


}
