package shop.mtcoding.conbasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HttpQueryController {

    @GetMapping("/data/query/v1")
    public String queryV1(@RequestParam("keyword") String keyword){
        return "받은 값 : "+keyword;
    }

    @GetMapping("/data/query/v2")
    public String queryV2(@RequestParam(value = "keyword", required = false) String keyword){
        return "받은 값 : "+keyword;
    }

    @GetMapping("/data/query/v3")
    public String queryV3(@RequestParam(value = "keyword", required = false, defaultValue = "cos") String keyword){
        return "받은 값 : "+keyword;
    }

    @GetMapping("/data/query/v4")
    public String queryV4(String keyword){
        return "받은 값 : "+keyword;
    }

    @GetMapping("/data/query/v5")
    public String queryV5(String keyword, String type){
        return "받은 값 : "+keyword+", "+type;
    }
}
