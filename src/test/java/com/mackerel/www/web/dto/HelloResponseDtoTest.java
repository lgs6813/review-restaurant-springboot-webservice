package com.mackerel.www.web.dto;
import com.mackerel.www.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        //junit의 assertThat대신에 assertj의 asssertThat사용
        //장점 1. 추가적인 라이브러리 필요 x
        //장점 2.자동완성 잘 지원
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
