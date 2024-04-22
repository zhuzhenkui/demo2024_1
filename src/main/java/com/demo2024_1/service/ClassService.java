package com.demo2024_1.service;

import com.demo2024_1.entity.Classinfo;
import com.demo2024_1.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassMapper cmapper;

    public List<Classinfo> getClassList(){

        return cmapper.getClassList();
    }
}
