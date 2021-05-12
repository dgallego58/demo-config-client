package co.com.properties;

import co.com.properties.config.AwsParameters;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SpringBootApplication
@Slf4j
public class DemoRemotePropertiesApplication {

    @Value("${custom.constant}")
    private String customConstant;

    @Value("#{ environment['custom.prop'] ?: 'No está en el perfil' }")
    private String remoteGitCustomProp;

    public static void main(String[] args) {
        SpringApplication.run(DemoRemotePropertiesApplication.class, args);
    }

    @Bean
    CommandLineRunner onInit(AwsParameters awsParameters, ConfigurableApplicationContext ctx) {
        return args -> {
            log.info("========= Los parámetros son  ===============");
            log.info("========= AWS PROPERTIES      ===============");
            log.info("========= el valor de custom name es : {} ", awsParameters.getCustomName());
            log.info("========= el valor del timeout es    : {} ", awsParameters.getLoadClientTimeout());
            log.info("========= ¿está activo?              : {} ", awsParameters.isActive());
            log.info("========= LOCAL FILE PROPERTIES ==========");
            log.info("========= Custom constant is {} ", customConstant);
            log.info("========= Active Profile is {}", String.join(",", Arrays.asList(ctx.getEnvironment().getActiveProfiles())));
            log.info("========= CONFIG SERVER PROPERTIES ==========");
            log.info("========= Custom constant is {} ", remoteGitCustomProp);
            log.info("==================== Fin de la inicialización ==========");
        };
    }

}
