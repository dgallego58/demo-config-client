package co.com.properties.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class AwsParameters {

    private final String customName;
    private final long loadClientTimeout;
    private final boolean active;

}
