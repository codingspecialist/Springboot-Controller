package shop.mtcoding.conbasic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.conbasic.dto.BoardRespDto;

@Controller
public class ResponseController {

    @GetMapping("/resp/v1")
    public String respV1() {
        return "home";
    }

    @GetMapping("/resp/v2")
    public String respV2(Model model) {
        model.addAttribute("title", "제목1");
        return "main";
    }

    @GetMapping("/resp/v3")
    public @ResponseBody String respV3() {
        return "<h1>text/html 응답</h1>";
    }

    @GetMapping("/resp/v4")
    public @ResponseBody BoardRespDto respV4() {
        return new BoardRespDto(1, "제목1", "내용1");
    }

    @GetMapping("/resp/v5")
    public ResponseEntity<Void> respV5() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/resp/v6")
    public ResponseEntity<String> respV6() {
        return ResponseEntity.ok().body("hello");
    }

    @GetMapping("/resp/v7")
    public ResponseEntity<?> respV7() {
        BoardRespDto boardRespDto = new BoardRespDto(2, "제목2", "내용2");
        return ResponseEntity.ok().body(boardRespDto);
    }

    @GetMapping("/resp/v8")
    public String respV8() {
        return "redirect:/resp/v1";
    }
}
