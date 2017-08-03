package com.example.demo.controller;

import com.example.demo.service.ComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/compute")
public class ComputeController {
    private ComputeService computeService;

    @Autowired
    public ComputeController(ComputeService computeService){
        this.computeService = computeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Integer compute(@RequestParam Integer a,Integer b){
        return computeService.compute(a,b);
    }
}
