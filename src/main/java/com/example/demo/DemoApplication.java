package com.example.demo;

import com.example.demo.Entity.Poetry;
import com.example.demo.Services.PoetryService;
import com.example.demo.Utils.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

@SpringBootApplication
@Controller
public class DemoApplication {
    @Autowired
    PoetryService poetryService;

    @ResponseBody
    @RequestMapping("/name/{name}/{page}")
    Object home(@PathVariable String name,@PathVariable int page ) {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageNum(page);
        pageRequest.setPageSize(10);
        return poetryService.getLikePoetry(name,pageRequest);
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
