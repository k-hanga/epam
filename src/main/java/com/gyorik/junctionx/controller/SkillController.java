package com.gyorik.junctionx.controller;

import com.gyorik.junctionx.domain.Skill;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class SkillController {
    //ennek nem itt a helye
    public static <T> List<T> convertArrayToList(T array[])
    {

        // Create the List by passing the Array
        // as parameter in the constructor
        List<T> list = new ArrayList<>();

        // Add the array to list
        Collections.addAll(list, array);

        // Return the converted List
        return list;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/skills")
    List<Skill> all() {
        return convertArrayToList(Skill.values());
    }
    // end::get-aggregate-root[]
}
