package com.rocketseat.certification_nlw.modules.students.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.rocketseat.certification_nlw.modules.students.UseCases.VerifyIfHasCertificationUseCase;
import com.rocketseat.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;

@RestController
@RequestMapping("/students")

public class StudentController {

    @Autowired
    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyHasCertificationDTO verifyIfHasCertificationDTO){
        var result = verifyIfHasCertificationUseCase.execute(verifyIfHasCertificationDTO);
        if (result){
            return "Usuario ja fez a prova";
        } 
        return "Usuario pode fazer a prova";
    }    
}
