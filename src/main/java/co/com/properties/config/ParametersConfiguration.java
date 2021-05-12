package co.com.properties.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ParametersConfiguration {


    /**
     * dada la estructura de:
     * /config/<name-of-the-spring-application>_<profile>/<parameter-name>
     *
     * @param customName
     * @param loadClientTimeout
     * @param active
     * @return
     */
    @Bean
    @RefreshScope
    public AwsParameters awsParameters(@Value("${customName: 'esNulo'}") String customName,
                                       @Value("#{ ${loadClientTimeout} > 10 ? 5 : ${loadClientTimeout} }") long loadClientTimeout,
                                       @Value("#{ ${active} == true? false : ${active} }") boolean active) {
        log.info("========= Context started/refreshed with {}, {}, {}", customName, loadClientTimeout, active);
        return new AwsParameters(customName, loadClientTimeout, active);

    }

}
