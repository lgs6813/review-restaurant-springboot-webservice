package com.mackerel.www.web;
import com.mackerel.www.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/hello/dto")
    //@RequestParam은 쿼리스트링 처럼 뒤에 값 붙는 거임 ?name=x&amount=y 이런식으로
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}

