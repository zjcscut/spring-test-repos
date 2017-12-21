package org.throwable.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author throwable
 * @version v1.0
 * @description
 * @since 2017/12/21 15:51
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello/get")
    public String getHello() {
        return "Hello get!";
    }

    @PostMapping(value = "/hello/post")
    public String pstHello(@RequestParam("name") String name) {
        return String.format("Hello post.I am %s!", name);
    }
}
