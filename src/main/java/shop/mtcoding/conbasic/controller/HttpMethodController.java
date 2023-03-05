package shop.mtcoding.conbasic.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpMethodController {

    @GetMapping("/req/get")
    public String methodGet() {
        return "<h1>get 요청</h1>";
    }

    @PostMapping("/req/post")
    public String methodPost() {
        return "<h1>post 요청</h1>";
    }

    @PutMapping("/req/put")
    public String methodPut() {
        return "<h1>put 요청</h1>";
    }

    @DeleteMapping("/req/delete")
    public String methodDelete() {
        return "<h1>delete 요청</h1>";
    }

}
