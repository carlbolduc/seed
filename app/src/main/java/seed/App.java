package seed;

import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.jdbi.v3.core.Jdbi;
import seed.db.Dao;
import seed.resources.AboutResource;
import seed.resources.PostsResource;
import seed.resources.HomeResource;
import seed.resources.PoliciesResource;

import java.util.Map;

public class App extends Application<Config> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    public void initialize(Bootstrap<Config> bootstrap) {
        // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
        bootstrap.addBundle(new MigrationsBundle<>() {
            @Override
            public DataSourceFactory getDataSourceFactory(Config config) {
                return config.getDatabase();
            }
        });
        bootstrap.addBundle(new ViewBundle<>() {
            @Override
            public Map<String, Map<String, String>> getViewConfiguration(Config config) {
                return config.getViews();
            }
        });
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new UrlRewriteBundle());
    }

    @Override
    public void run(Config config, Environment env) {
        MutableDataSet options = new MutableDataSet();
        final Parser parser = Parser.builder(options).build();
        final HtmlRenderer renderer = HtmlRenderer.builder(options).build();
        final JdbiFactory jdbiFactory = new JdbiFactory();
        final Jdbi jdbi = jdbiFactory.build(env, config.getDatabase(), "main");
        final Dao dao = jdbi.onDemand(Dao.class);
        env.jersey().register(new HomeResource());
        env.jersey().register(new AboutResource());
        env.jersey().register(new PoliciesResource(dao, parser, renderer));
        env.jersey().register(new PostsResource(dao, parser, renderer));
    }

}
