package huseyin.ocal.card.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "card")
@Getter
@Setter
public class CardServiceConfig {

    private String msg;

    private String buildVersion;

    private Map<String, String> mailDetails;

    private List<String> activeBranches;
}
