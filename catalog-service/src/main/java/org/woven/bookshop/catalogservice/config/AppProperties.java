package org.woven.bookshop.catalogservice.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Getter
@Setter
@ConfigurationProperties("woven")
public class AppProperties {
    private String greeting;

}
