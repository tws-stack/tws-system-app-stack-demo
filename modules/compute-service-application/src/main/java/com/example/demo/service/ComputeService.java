package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class ComputeService {
 public Integer compute(Integer a,Integer b){
     Integer sum = a + b;
     return sum;
 }
}