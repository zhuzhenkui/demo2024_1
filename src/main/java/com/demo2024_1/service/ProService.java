package com.demo2024_1.service;

import com.demo2024_1.entity.Proinfo;
import com.demo2024_1.mapper.ProMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProService {
    @Autowired
    private ProMapper proMapper;
    public List<Proinfo> getProList(){
        return proMapper.getProList();
    }
}
