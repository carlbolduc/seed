package seed.views;

import io.dropwizard.views.View;

import java.nio.charset.StandardCharsets;

public class HomeView extends View {
    public HomeView(String l) {
        super(l != null && l.equals("fr") ? "home_fr.ftl" : "home.ftl", StandardCharsets.UTF_8);
    }
}
