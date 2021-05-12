package co.com.properties.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RefreshedListener implements ApplicationListener<RefreshScopeRefreshedEvent> {

    private final AwsParameters awsParameters;

    public RefreshedListener(AwsParameters awsParameters) {
        this.awsParameters = awsParameters;
    }

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent event) {
        log.info("======== CONTEXT REFRESHED BEGIN ========");
        log.info("Event refreshed on {}", event.getName());
        log.info("Context refresh with {}", event);
        log.info("Aware of {}", event.getSource());
        log.info("======== Object renewal {}", awsParameters);
        log.info("======== CONTEXT REFRESHED END ========");

    }
}
