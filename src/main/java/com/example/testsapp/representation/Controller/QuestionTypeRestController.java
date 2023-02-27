package com.example.testsapp.representation.Controller;

import com.example.testsapp.representation.DTO.QuestionTypeDto;
import com.example.testsapp.service.QuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/QuestionType")
public class QuestionTypeRestController {

    @Autowired
    private QuestionTypeService questionTypeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<QuestionTypeDto> get(@PathVariable Long id)
    {
        if(id == null) {
            return ResponseEntity.badRequest().build();
        }

        QuestionTypeDto questionTypeDto = this.questionTypeService.getById(id);

        if (questionTypeDto == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(questionTypeDto);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<QuestionTypeDto>> getAll()
    {
        List<QuestionTypeDto> list = this.questionTypeService.getAll();

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(list);
    }


    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<QuestionTypeDto> post(@RequestBody QuestionTypeDto questionTypeDto)
    {
        if (questionTypeDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.questionTypeService.save(questionTypeDto.toEntity());
        return ResponseEntity.ok().build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<QuestionTypeDto> delete(@PathVariable Long id)
    {
        QuestionTypeDto questionTypeDto = this.questionTypeService.getById(id);
        if (questionTypeDto == null) {
            return ResponseEntity.notFound().build();
        }

        this.questionTypeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<QuestionTypeDto> update(@RequestBody @Validated QuestionTypeDto questionTypeDto, UriComponentsBuilder builder)
    {
        if(questionTypeDto == null) {
            return ResponseEntity.badRequest().build();
        }

        this.questionTypeService.save(questionTypeDto.toEntity());
        return ResponseEntity.ok().build();
    }

}
