package shop.mtcoding.conbasic.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import shop.mtcoding.conbasic.dto.UserRespDto;

@WebMvcTest // Filter, DispatcherServlet, Controller, MockMvc를 IoC 컨테이너에 로드한다. (웹 계층 관련된 모든 객체)
public class UserControllerTest {

    @Autowired // DI
    private MockMvc mockMvc;

    @Test // @Test를 붙이면 해당 메서드를 테스트할 수 있다.
    public void addUser_test() throws Exception { // test 메서드는 파라메터를 전달받을 수 없다.
        // given (파라메터로 요청되는 데이터를 임의로 준비한다)
        String requestBody = "username=ssar&password=1234&tel=0102222"; // x-www-form-urlencoded

        // when (본코드 테스트를 수행한다)
        MockHttpServletRequestBuilder builders = MockMvcRequestBuilders
                .post("/api/users")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResultActions actions = mockMvc.perform(builders);

        // then (본코드 테스트 결과를 검증한다)
        ResultMatcher isCreated = MockMvcResultMatchers.status().isCreated();
        actions.andExpect(isCreated);

        ResultMatcher location = MockMvcResultMatchers.header().string("Location", "/api/users/1");
        actions.andExpect(location);
    }

    @Test
    public void getUser_test() throws Exception {
        // given
        int id = 1;

        // when
        MockHttpServletRequestBuilder builders = MockMvcRequestBuilders
                .get("/api/users/" + id);
        ResultActions actions = mockMvc.perform(builders);

        // then
        ResultMatcher isOk = MockMvcResultMatchers.status().isOk();
        actions.andExpect(isOk);

        ResultMatcher isSameId = MockMvcResultMatchers.jsonPath("id").value("1");
        ResultMatcher isSameUsername = MockMvcResultMatchers.jsonPath("username").value("ssar");
        ResultMatcher isSameTel = MockMvcResultMatchers.jsonPath("tel").value("0102222");
        actions.andExpect(isSameId);
        actions.andExpect(isSameUsername);
        actions.andExpect(isSameTel);
    }

    @Test
    public void detail_test() throws Exception {
        // given
        int id = 1;

        // when
        MockHttpServletRequestBuilder builders = MockMvcRequestBuilders
                .get("/users/" + id);
        ResultActions actions = mockMvc.perform(builders);

        // then
        ResultMatcher isOk = MockMvcResultMatchers.status().isOk();
        actions.andExpect(isOk);

        UserRespDto userRespDto =  (UserRespDto) actions.andReturn().getModelAndView().getModel().get("user");
        Assertions.assertThat(userRespDto.toString()).isEqualTo(new UserRespDto(1, "ssar", "0102222").toString());
    }
}
