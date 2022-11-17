package seed.views;

import io.dropwizard.views.View;
import seed.api.Policy;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class PoliciesView extends View {
    private final List<Policy> policies;

    public PoliciesView(List<Policy> policies, String l) {
        super(l != null && l.equals("fr") ? "policies_fr.ftl" : "policies.ftl", StandardCharsets.UTF_8);
        this.policies = policies;
    }

    public List<Policy> getPolicies() {
        return policies;
    }
}
