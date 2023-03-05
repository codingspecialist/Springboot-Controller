package shop.mtcoding.conbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpPathController {

    @GetMapping("/data/path/v1/{id}")
    public String pathV1(@PathVariable("id") int id){
        return "받은 값 : "+id;
    }
}
