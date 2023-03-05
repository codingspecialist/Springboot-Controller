package shop.mtcoding.conbasic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.conbasic.dto.UserRespDto;

import java.net.URI;

@Controller
public class UserController {

    @PostMapping("/api/users")
    public ResponseEntity<?> addUser(String username, String password, String tel){
        // 1. 유효성 검사
        if(username == null || username.isEmpty()){
            return ResponseEntity.badRequest().body("<h1>username 입력하세요</h1>");
        }
        if(password == null || password.isEmpty()){
            return ResponseEntity.badRequest().body("<h1>password 입력하세요</h1>");
        }
        if(tel == null || tel.isEmpty()){
            return ResponseEntity.badRequest().body("<h1>tel 입력하세요</h1>");
        }

        // 2. 비지니스 로직 처리 (아직 배우지 않았음)
        int id = 1; // DB에 저장된 PK값을 받아옴

        // 3. 저장된 User 정보의 URI 응답 (201 - 새로운 리소스가 서버에 추가되었을 때)
        URI location = URI.create("/api/users/"+id);
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id){
        // 1. 인증 검사 (아직 배우지 않았음)

        // 2. 비지니스 로직 처리 (아직 배우지 않았음)
        UserRespDto userRespDto = new UserRespDto(1, "ssar", "0102222"); // DB에 저장된 User 정보를 받아옴

        // 3. 조회된 데이터를 응답(200)
        return ResponseEntity.ok().body(userRespDto);
    }

    @GetMapping("/users/{id}")
    public String detail(@PathVariable int id, Model model){
        // 1. 인증 검사 (아직 배우지 않았음)

        // 2. 비지니스 로직 처리 (아직 배우지 않았음)
        UserRespDto userRespDto = new UserRespDto(1, "ssar", "0102222"); // DB에 저장된 User 정보를 받아옴

        // 3. 받아온 Data를 Model에 담기 (request Scope에 담는 것과 동일)
        model.addAttribute("user", userRespDto);
        
        // 4. View 응답
        return "detail";
    }

}
