package com.mackerel.www.web;
import com.mackerel.www.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//테스트를 진행시 JUnit 에 내장된 실행자 외에 다른 실행자 실행시킴.
//Springrunner라는 실행자를 사용, 즉 JUnit과 스프링 부트 테스트 연결자 역할을 함.
@RunWith(SpringRunner.class)
//여러 스프링 테스트 어노테이션 중 WEB에 집중할 수 있는 어노테이션
//@Controller @controllerAdvice등은 사용가능, @Service,@Component,@Repository등은 사용 불가능
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    //스프링이 관리하는 빈을 주입받음
    @Autowired
    //웹 API를 테스트할 때 사용
    //스프링 MVC test의 시작점, GET POST 등의 API 테스트 가능
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                //mvc.perform의 결과중 status가 200인지 검증
                .andExpect(status().isOk())
                //결과를 검증
                .andExpect(content().string(hello));
    }
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        //API test할때 요청 파라미터를 설정
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                //오브젝트로 리턴하면 json이 표시된다.
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
