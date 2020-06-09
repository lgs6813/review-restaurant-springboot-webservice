package com.mackerel.www;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//스프링 부트의 자동설정 스프링 bean 읽기와 생성을 모두 자동으로 설정
//이 위치부터 설정을 읽어가기 때문에 프로젝트의 최상단에 위치해야만 한다.
@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        //내장 WAS 사용가능
        //언제 어디서나 같은 환경에서 스프링 부트를 배포할수 있음(권장)
        //여러 서버에 WAS 환경을 구축해야한다면 실수할 가능성이 생김.
        SpringApplication.run(Application.class,args);
    }
}
