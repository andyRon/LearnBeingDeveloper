package com.andyron.controller;

import com.andyron.sender.DirectSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andy Ron
 */
@RestController
public class DirectController {

    @Autowired
    private DirectSender directSender;

    @GetMapping("directTest")
    public void directTest() {
        directSender.sendDirectQueue();
    }
}
