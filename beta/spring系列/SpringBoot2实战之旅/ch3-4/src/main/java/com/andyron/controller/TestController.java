package com.andyron.controller;

import com.andyron.entity.BookConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author Andy Ron
 */
@RestController
public class TestController {

    @Autowired
    private BookConfigBean bookConfigBean;

    @Value("${book.name}")
    private String bookName;

    @Value("${book.reader}")
    private String bookReader;

    @GetMapping("test1")
    public String test1() {
        return "本书书名是：" + bookName + ", 读者是：" + bookReader;
    }

    @GetMapping("test2")
    public BookConfigBean test2() {
        return bookConfigBean;
    }



}
