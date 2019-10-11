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

    @ResponseBody
    @RequestMapping("/all/{page}")
    Object all(@PathVariable int page ) {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageNum(page);
        pageRequest.setPageSize(10);
        return poetryService.getAllPoetry(pageRequest);
    }


    @ResponseBody
    @RequestMapping("/auth/{name}/{page}")
    Object auth(@PathVariable String name,@PathVariable int page ) {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageNum(page);
        pageRequest.setPageSize(10);
        return poetryService.getPoetLikePoetry(name,pageRequest);
    }

    @ResponseBody
    @RequestMapping("/content/{name}/{page}")
    Object content(@PathVariable String name,@PathVariable int page ) {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageNum(page);
        pageRequest.setPageSize(10);
        return poetryService.getContentLikePoetry(name,pageRequest);
    }

    @ResponseBody
    @RequestMapping("/all/{name}/{page}")
    Object getAllLike(@PathVariable String name,@PathVariable int page ) {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setPageNum(page);
        pageRequest.setPageSize(10);
        return poetryService.getAllLike(name,pageRequest);
    }



    @RequestMapping("/index")
    @ResponseBody
    String index() {
        return "<html> </html>";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
