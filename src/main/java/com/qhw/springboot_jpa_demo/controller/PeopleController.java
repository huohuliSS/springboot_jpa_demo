package com.qhw.springboot_jpa_demo.controller;

import com.qhw.springboot_jpa_demo.pojo.People;
import com.qhw.springboot_jpa_demo.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by asus on 2019/11/14  16:51
 */
@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @PostMapping("addPeople")
    public void addPeople(@RequestBody People people){
        peopleRepository.save(people);
    }

    @GetMapping("getAllPeople")
    public List<People> getPeople(){
        return peopleRepository.findAll();
    }

    @DeleteMapping("deletePeople")
    public void deletePeople(@RequestParam Long id){
        peopleRepository.deleteById(id);
    }

    @PutMapping("updatePeople")
    public void updatePeople(@RequestBody People people){
        peopleRepository.saveAndFlush(people);
    }

    @RequestMapping("findByName")
    public List<People> findByName(String name){
        return peopleRepository.findByNameContains(name);
    }

    @GetMapping("/findByNameEqualsAndAgeEquals/{name}/{age}")
    public People findByNameEqualsAndAgeEquals(@PathVariable("name") String name,@PathVariable("age") Integer age){
        return peopleRepository.findByNameEqualsAndAgeEquals(name, age);
    }

    //自定义sql
    @GetMapping("/xxxnameis/{name}")
    public People xxxnameis(@PathVariable("name") String name){
        return peopleRepository.xxxnameis(name);
    }

    //自定义sql根据用户名和年龄
    @GetMapping("/yyynameandage/{name}/{age}")
    public People yyynameandage(@PathVariable("name") String name,@PathVariable("age")Integer age){
        return peopleRepository.yyynameandage(name, age);
    }

    @GetMapping("/findnamelength")
    public List<People> findnamelength(){
        return peopleRepository.findnamelength();
    }

    @GetMapping("findListByName")
    public List<People> findListByName(String name){
        return peopleRepository.findListByName(name);
    }



}
