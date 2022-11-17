package seed.views;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import io.dropwizard.views.View;
import seed.api.Post;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class PostView extends View {
    private final Post post;
    private final String l;
    private final Parser parser;
    private final HtmlRenderer renderer;

    public PostView(Post post, String l, Parser parser, HtmlRenderer renderer) {
        super(l != null && l.equals("fr") ? "post_fr.ftl" : "post.ftl", StandardCharsets.UTF_8);
        this.post = post;
        this.l = l;
        this.parser = parser;
        this.renderer = renderer;
    }

    public Post getPost() {
        return post;
    }

    public String getFormattedPublishedOn() {
        DateTimeFormatter DATE_TIME_FORMATTER = l != null && l.equals("fr") ? DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRENCH).withZone(ZoneId.systemDefault()) : DateTimeFormatter.ofPattern("MMMM d, yyyy").withZone(ZoneId.systemDefault());
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(post.getPublishedOn(), 0, ZoneOffset.UTC);
        return DATE_TIME_FORMATTER.format(dateTime);
    }

    public String getContent() {
        String content = l != null && l.equals("fr") ? post.getContentFr() : post.getContentEn();
        Node document = parser.parse(content == null ? "" : content);
        return renderer.render(document);
    }
}
