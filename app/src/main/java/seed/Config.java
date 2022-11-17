package seed;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

public class Config extends Configuration {
    @Valid
    @NotNull
    private final DataSourceFactory database = new DataSourceFactory();
    @Valid
    @NotNull
    private final Map<String, Map<String, String>> views = new HashMap<>();
    @Valid
    private String rewriteConfPath;

    public DataSourceFactory getDatabase() {
        return database;
    }

    public Map<String, Map<String, String>> getViews() {
        return views;
    }

    @JsonProperty
    public String getRewriteConfPath() {
        return this.rewriteConfPath;
    }

}
