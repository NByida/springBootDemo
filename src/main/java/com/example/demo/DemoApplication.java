package com.example.demo;

import com.example.demo.Services.PoetryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class DemoApplication {
    @Autowired
    PoetryService poetryService;

    @RequestMapping("/name/{name}")
    @ResponseBody
    String home(@PathVariable String name ) {
        return (poetryService.getLikePoetry(name));
    }




    @RequestMapping("/index")
    @ResponseBody
    String index() {
        return "<html> aaaaa</html>";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
