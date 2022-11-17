package seed.views;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.ast.Node;
import io.dropwizard.views.View;
import seed.api.Policy;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class PolicyView extends View {
    private final Policy policy;
    private final String l;
    private final Parser parser;
    private final HtmlRenderer renderer;

    public PolicyView(Policy policy, String l, Parser parser, HtmlRenderer renderer) {
        super(l != null && l.equals("fr") ? "policy_fr.ftl" : "policy.ftl", StandardCharsets.UTF_8);
        this.policy = policy;
        this.l = l;
        this.parser = parser;
        this.renderer = renderer;
    }

    public Policy getPolicy() {
        return policy;
    }

    public String getLastUpdatedAt() {
        DateTimeFormatter DATE_TIME_FORMATTER = l != null && l.equals("fr") ? DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.FRENCH).withZone(ZoneId.systemDefault()) : DateTimeFormatter.ofPattern("MMMM d, yyyy").withZone(ZoneId.systemDefault());
        LocalDateTime dateTime = LocalDateTime.ofEpochSecond(policy.getUpdatedAt(), 0, ZoneOffset.UTC);
        return DATE_TIME_FORMATTER.format(dateTime);
    }

    public String getContent() {
        String content = l != null && l.equals("fr") ? policy.getContentFr() : policy.getContentEn();
        if (content == null || content.equals("")) {
            // Policies will not be translated from the get go
            content = policy.getContentEn();
        }
        Node document = parser.parse(content == null ? "" : content);
        return renderer.render(document);
    }
}
