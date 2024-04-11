package org.highfives.bootproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* 설명. Rest API 서버 측에서 CORS 처리를 위한 설정 클래스 */
/* 어노테이션만 주석 처리하게 되면 작동하지 X */
//@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(
                        "http://localhost:5173",

                        /* 설명. vue 프로젝트를 8011로 접근되게 포트 포워딩(8011:5173)해서 컨테이너를 만들면 CORS 경로 변경 가능성*/
//                        "http://localhost:8011"

                        /* 설명. kubernetes 환경에서 프론트의 워커노드는 30000 백엔드 입장에서는 프론트의 워커노드 CORS 처리 필요 */
                        "http://localhost:30000"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
