package huseyin.ocal.loan.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "loan")
@Getter
@Setter
public class LoanServiceConfig {

    private String msg;

    private String buildVersion;

    private Map<String, String> mailDetails;

    private List<String> activeBranches;
}
