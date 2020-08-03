package inc.develop.spring.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
/**
 * WebConfig 라는 Class를 세팅 하는 이유는 RestApi 형식으로 프로젝트를 하기 위해
 * 통신 cors 룰 세팅.
 * @addCrosMappings: 스프링 기본 WebMvnConfigurer 상속 받아 내부에 있는 전역 cors 
 *                   호출해서 개발 script 모드에 따른 구동 allow Origin 허용
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry regist) {
        // README에 구동 스크립트에 따른 prod 는 실제 개발모드를 뜻한다.
        // prod = 실제서버 모드가 아니라면 ? false : true
        boolean develop_check = System.getProperty("spring.profiles.active").equals("prod") ? false : true;
        if ( develop_check ) {
            regist.addMapping("/**").allowedOrigins("http://localhost", "http://localhost:80");
        } else {
            // 실제 서버 도메인 및 ip 세팅
            //regist.addMapping("/**").allowedOrigins("https://domain.com");
        }
    }
}