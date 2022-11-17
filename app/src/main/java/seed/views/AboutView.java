package seed.views;

import io.dropwizard.views.View;

import java.nio.charset.StandardCharsets;

public class AboutView extends View {
    public AboutView(String l) {
        super(l != null && l.equals("fr") ? "about_fr.ftl" : "about.ftl", StandardCharsets.UTF_8);
    }
}
