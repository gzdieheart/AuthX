package org.gzdieheart.authx.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

/**
 * @author hyj
 * @version 1.0
 * @date  2024/12/29
 * Api接口文档配置
 */

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("鉴权管理 API")
                        .version("1.0")
                        .description("这是authx项目中的REST API文档"));
    }
}
