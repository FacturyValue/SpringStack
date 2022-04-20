package com.springboot.java.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class AuthorizeController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/info",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getLocalInfo(@RequestParam(name = "code",defaultValue = "001") String code){
        return "{'user':'rudy','password':'root'}";
    }
}
